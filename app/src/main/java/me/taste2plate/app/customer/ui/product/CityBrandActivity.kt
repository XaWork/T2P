package me.taste2plate.app.customer.ui.product

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import io.github.inflationx.viewpump.ViewPumpContextWrapper
import kotlinx.android.synthetic.main.content_subcategory.*
import kotlinx.android.synthetic.main.toolbar.*
import me.taste2plate.app.customer.R
import me.taste2plate.app.customer.adapter.CityBrandAdapter
import me.taste2plate.app.customer.common.BaseActivity
import me.taste2plate.app.customer.common.Status
import me.taste2plate.app.customer.ui.state.ProgressDialogFragment
import me.taste2plate.app.customer.utils.AppUtils
import me.taste2plate.app.customer.viewmodels.ProductViewModel
import me.taste2plate.app.models.CityBrand
import java.util.*


class CityBrandActivity : BaseActivity() {

    lateinit var adapter: CityBrandAdapter
    var mCityBrandList: ArrayList<CityBrand.Result> = ArrayList()

    val TAG = this::getLocalClassName

    private lateinit var viewModel: ProductViewModel

    override fun attachBaseContext(newBase: Context) {
        super.attachBaseContext(ViewPumpContextWrapper.wrap(newBase))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_subcategory)
        setSupportActionBar(toolbar)

        viewModel = getViewModel(ProductViewModel::class.java)

        val customAppData = AppUtils(this).appData
        if(customAppData !=null){

        }

        toolbar.setNavigationOnClickListener {
            finish()
        }
        title = intent.getStringExtra("type");

        if(intent.getStringExtra("type")!!.contentEquals("Flavours Of India")){
            getCuisine()
        }else {
            cityBrand()
        }
    }

    private fun getCuisine(){
        viewModel.homePageData(AppUtils(this).defaultAddress.city!!._id).observe(this, androidx.lifecycle.Observer { response ->
            when (response!!.status()) {
                Status.LOADING -> {
                    showLoading()
                }

                Status.SUCCESS -> {
                    stopShowingLoading()
                    val homePageResponse = response.data()
                    mCityBrandList.addAll(homePageResponse.cuisine)
                    setUpPage()
                }

                Status.ERROR, Status.EMPTY -> {
                    stopShowingLoading()
                    showError(getString(R.string.something_went_wrong))
                }
            }

        })
    }


    private fun setUpPage() {
        val layoutManager = LinearLayoutManager(baseContext)
        rvSubCategory.layoutManager = layoutManager
        rvSubCategory.isNestedScrollingEnabled = false

        adapter = CityBrandAdapter(mCityBrandList, intent.getStringExtra("type")!!)
        rvSubCategory.adapter = adapter
    }

    private fun cityBrand() {
        val data =
            if (intent.getStringExtra("type")!!.contentEquals("City")) viewModel.city else viewModel.brandList
        data.observe(this, androidx.lifecycle.Observer { response ->
            when (response!!.status()) {
                Status.LOADING -> {
                    showLoading()
                }

                Status.SUCCESS -> {
                    stopShowingLoading()
                    val cartResponse = response.data()
                    mCityBrandList.addAll(cartResponse.result!!)
                    setUpPage()
                }

                Status.ERROR, Status.EMPTY -> {
                    stopShowingLoading()
                    showError(getString(R.string.something_went_wrong))
                }
            }

        })
    }

    private lateinit var progressDialog: ProgressDialogFragment

    fun showLoading(title: String, message: String) {
        val manager = supportFragmentManager
        progressDialog = ProgressDialogFragment.newInstance(title, message)
        progressDialog.isCancelable = false
        progressDialog.show(manager, "progress")
    }

    fun showLoading() {
        showLoading(getString(R.string.loading_title), getString(R.string.loading))
    }

    fun stopShowingLoading() {
        if(this::progressDialog.isInitialized)
            progressDialog.dismiss()
    }

}
