package me.taste2plate.app.customer.ui.home

import android.app.SearchManager
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.fueled.reclaim.AdapterItem
import com.fueled.reclaim.ItemsViewAdapter
import kotlinx.android.synthetic.main.content_product.*
import kotlinx.android.synthetic.main.fragment_home.*
import me.taste2plate.app.customer.common.BaseActivity
import me.taste2plate.app.customer.common.Status
import me.taste2plate.app.customer.events.AddToWishlistEvent
import me.taste2plate.app.customer.events.DeleteFromWishlistEvent
import me.taste2plate.app.customer.ui.address.AddressSelectionFragment
import me.taste2plate.app.customer.ui.address.SaveAddressListener
import me.taste2plate.app.customer.ui.items.CarouselAdapterItem
import me.taste2plate.app.customer.ui.items.CategoryAdapterItems
import me.taste2plate.app.customer.ui.items.ProductsAdapterItem
import me.taste2plate.app.customer.ui.items.SectionAdapterItem
import me.taste2plate.app.customer.ui.product.ProductSearchActivity
import me.taste2plate.app.customer.ui.state.ProgressDialogFragment
import me.taste2plate.app.customer.utils.AppUtils
import me.taste2plate.app.customer.viewmodels.ProductViewModel
import me.taste2plate.app.models.filters.ProductCategoryFilter
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

class HomeFragment : Fragment(), SaveAddressListener {

    private lateinit var progressDialog: ProgressDialogFragment

    fun showLoading(title: String, message: String) {
        val manager = fragmentManager
        progressDialog = ProgressDialogFragment.newInstance(title, message)
        progressDialog.isCancelable = false
        progressDialog.show(manager!!, "progress")
    }


    companion object {
        @JvmStatic
        fun newInstance() =
            HomeFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }

    lateinit var viewModel: ProductViewModel
    private val itemsAdapter = ItemsViewAdapter()
    val TAG = "HomeFragment"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(
            me.taste2plate.app.customer.R.layout.fragment_home,
            container,
            false
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = (activity as HomeActivity).getViewModel(ProductViewModel::class.java)
        progressBar.visibility = VISIBLE
        search_container.setOnClickListener {
            startActivity(
                Intent(context, ProductSearchActivity::class.java)
                    .setAction(Intent.ACTION_SEARCH)
                    .putExtra(SearchManager.QUERY, "")
            )
        }

        location_banner.setOnClickListener {
            val addressSelection = AddressSelectionFragment()
            addressSelection.saveSetSaveListener(this)
            addressSelection.show(fragmentManager!!, addressSelection.tag)
        }


        homePage.run {
            layoutManager = LinearLayoutManager(context)
            adapter = itemsAdapter
        }


        getHomePageData()
        refreshAddress()
    }

    fun getWishlist() {
        viewModel.getWishlist(AppUtils(context).user.id).observe(viewLifecycleOwner){response ->
            when(response.status()){
                Status.LOADING -> {
                    progressBar.visibility = VISIBLE
                }
                Status.SUCCESS -> {
                    val totalWishItem = response.data().result.size

                    (activity as BaseActivity).wishlistCounter = totalWishItem.toString()
                    (activity as BaseActivity).invalidateOptionsMenu()
                    progressBar.visibility = GONE
                    (activity as HomeActivity).invalidateOptionsMenu()
                }

                Status.ERROR -> {
                    progressBar.visibility = GONE
                }

                Status.EMPTY -> {
                    progressBar.visibility = GONE
                }
            }
        }
    }

    override fun onResume() {
        super.onResume()
        Log.e("home", "inside on resume function")
        val address = AppUtils(context).defaultAddress
        getWishlist()
        if (address != null) {
            selected_address.text =
                "${address.address}, ${address.city!!.name}, ${address.pincode.orEmpty()}"
            cart(address.city!!._id, address.pincode!!)
        } else {
            getAddress()
        }
    }

    private fun getAddress() {
        val userId = AppUtils(context).user.id
        viewModel.fetchUserAddress(userId).observe(this) {
            when (it.status()) {
                Status.SUCCESS -> {
                    if (it.data().result.isNotEmpty()) {
                        AppUtils(context).saveDefaultAddress(it.data().result[0])
                        val address = AppUtils(context).defaultAddress
                        selected_address.text =
                            "${address.address}, ${address.city.name}, ${address.pincode}"
                        cart(address.city._id, address.pincode)
                    } else {
                        progressBar.visibility = GONE
                        Toast.makeText(context, "Set default address!", Toast.LENGTH_LONG).show()
                    }
                }
                Status.LOADING -> {
                }
                else -> {
                }
            }
        }
    }

    fun stopShowingLoading() {
        if (this::progressDialog.isInitialized)
            progressDialog.dismiss()
    }

    private fun getHomePageData() {
        val filter = ProductCategoryFilter()
        filter.setPer_page(100)
        viewModel.homePageData("").observe(viewLifecycleOwner) { response ->
            when (response!!.status()) {
                Status.LOADING -> {
                    showLoading("Please wait", "Fetching deals and offers")
                }

                Status.SUCCESS -> {
                    stopShowingLoading()
                    val homePageResponse = response.data()

                    val adapterItems = mutableListOf<AdapterItem<*>>()
                    adapterItems.add(CategoryAdapterItems(response.data().city))

                    if (homePageResponse.slider.isNotEmpty()) {
                        adapterItems.add(CarouselAdapterItem(homePageResponse.slider))
                    }
                    if (homePageResponse.product_deal.isNotEmpty()) {
                        adapterItems.add(SectionAdapterItem("Deals"))
                        adapterItems.add(ProductsAdapterItem(context!!, homePageResponse.product_deal, viewModel, viewLifecycleOwner, this))
                    }
                    if (homePageResponse.combo.isNotEmpty()) {
                        adapterItems.add(SectionAdapterItem("Combos"))
                        adapterItems.add(ProductsAdapterItem(context!!, homePageResponse.combo, viewModel, viewLifecycleOwner, this))
                    }
                    if (homePageResponse.best_seller.isNotEmpty()) {
                        adapterItems.add(SectionAdapterItem("Best Sellers"))
                        adapterItems.add(ProductsAdapterItem(context!!, homePageResponse.best_seller, viewModel, viewLifecycleOwner, this))
                    }
                    if (homePageResponse.featured.isNotEmpty()) {
                        adapterItems.add(SectionAdapterItem("Feature Products"))
                        adapterItems.add(ProductsAdapterItem(context!!, homePageResponse.featured, viewModel, viewLifecycleOwner, this))
                    }
                    itemsAdapter.replaceItems(adapterItems, true)
                }

                Status.ERROR -> {
                    stopShowingLoading()
                }

                Status.EMPTY -> {
                    stopShowingLoading()
                }
            }

        }
    }

    fun cart(cityId: String, zipCode:String) {

        Log.e("cart", AppUtils(context).user.id)
        //Toast.makeText(context, AppUtils(context).user.id, Toast.LENGTH_LONG).show()

        viewModel.getCart(AppUtils(context).user.id, cityId, zipCode)
            .observe(viewLifecycleOwner) { response ->
                when (response!!.status()) {
                    Status.LOADING -> {
                        progressBar.visibility = VISIBLE
                    }

                    Status.SUCCESS -> {
                        var tempTotalItem: Int = 0
                        for (cartItem in response.data().result) {
                            tempTotalItem += cartItem.quantity
                        }
                        (activity as BaseActivity).cartCounter = tempTotalItem.toString()
                        (activity as BaseActivity).invalidateOptionsMenu()
                        progressBar.visibility = GONE
                        (activity as HomeActivity).invalidateOptionsMenu()
                    }

                    Status.ERROR -> {
                        progressBar.visibility = GONE
                    }

                    Status.EMPTY -> {
                        progressBar.visibility = GONE
                    }
                }
            }
    }

    override fun onSaved() {
        refreshAddress()
    }


    private fun refreshAddress() {
        val address = AppUtils(context).defaultAddress
        if (address != null) {
            selected_address.text = "${address.address}, ${address.city!!.name}, ${address.pincode.orEmpty()}"
            cart(address.city!!._id, address.pincode!!)
        }
    }

}
