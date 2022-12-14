package me.taste2plate.app.customer.ui.items

import android.content.Context
import android.content.Intent
import android.text.Html
import android.text.TextUtils
import android.view.View
import android.widget.Toast
import androidx.lifecycle.LifecycleOwner
import com.facebook.drawee.drawable.ScalingUtils
import com.fueled.reclaim.AdapterItem
import com.fueled.reclaim.BaseViewHolder
import me.taste2plate.app.customer.R
import me.taste2plate.app.customer.common.BaseActivity
import me.taste2plate.app.customer.common.BindListItem
import me.taste2plate.app.customer.common.Status
import me.taste2plate.app.customer.databinding.SingleHomeProductItemBinding
import me.taste2plate.app.customer.ui.home.HomeFragment
import me.taste2plate.app.customer.ui.product.ProductActivity
import me.taste2plate.app.customer.utils.AppUtils
import me.taste2plate.app.customer.viewmodels.ProductViewModel
import me.taste2plate.app.models.home.ProductDeal

class ProductAdapterItem(
    private val context: Context,
    private val product: ProductDeal,
    private val productViewModel: ProductViewModel,
    private val lifecycleOwnerr: LifecycleOwner,
    private val homeFragment: HomeFragment
) : AdapterItem<ProductViewHolder>() {
    override val layoutId: Int = R.layout.single_home_product_item

    override fun onCreateViewHolder(view: View): ProductViewHolder = ProductViewHolder(view)

    override fun isTheSame(newItem: AdapterItem<*>): Boolean {
        return newItem is ProductAdapterItem
    }

    override fun isContentsTheSame(newItem: AdapterItem<*>): Boolean {
        return isTheSame(newItem) && (newItem as ProductAdapterItem).product == product
    }

    override fun updateItemViews(viewHolder: ProductViewHolder) {
        viewHolder.itemBinding.run {
            tvTitle.text = product.name
            tvDescription.text = Html.fromHtml(product.desc)
            val finalStrUrl = product.file?.get(0)?.location.orEmpty()
            ivImage.setImageURI(finalStrUrl);
            ivImage.hierarchy.actualImageScaleType = ScalingUtils.ScaleType.CENTER_CROP;
            val regularPrice =
                if (TextUtils.isEmpty(product.price)) "0" else product.price
            val salePrice = product.selling_price
            if (!TextUtils.isEmpty(salePrice)) {
                tvCallToAction.text =
                    root.context.getString(R.string.Rs_double, salePrice.toFloat())
                tvOnSale.visibility = View.VISIBLE
            } else {
                tvCallToAction.text =
                    root.context.getString(R.string.Rs_double, regularPrice.toFloat())
                tvOnSale.visibility = View.GONE
            }

            if (product.desc.isEmpty()) {
                tvDescription.visibility = View.GONE
            } else {
                tvDescription.visibility = View.VISIBLE
            }

            root.setOnClickListener {
                val intent = Intent(root.context, ProductActivity::class.java)
                intent.putExtra("productId", product._id)
                root.context.startActivity(intent)

                /*if(AppUtils(root.context).defaultAddress!=null) {
                    val intent = Intent(root.context, ProductActivity::class.java)
                    intent.putExtra("productId", product._id)
                    root.context.startActivity(intent)
                }else{
                    EventBus.getDefault().post(ShowError())
                }*/
            }

            //add to wishlist
            addToWishlist.setOnClickListener {
                productViewModel.addToWishlist(AppUtils(context).user.id, product._id)
                    .observe(lifecycleOwnerr) { response ->
                        when (response.status()) {
                            Status.LOADING -> {
                                progressBar.visibility = View.VISIBLE
                            }
                            Status.SUCCESS -> {
                                progressBar.visibility = View.GONE
                                addToWishlist.setImageResource(R.drawable.product_in_wishlist)
                                Toast.makeText(context, response.data().message, Toast.LENGTH_SHORT)
                                    .show()
                               // BaseActivity().wishlistCounter+=1
                                homeFragment.getWishlist()
                            }
                            Status.ERROR -> {
                                progressBar.visibility = View.GONE
                            }
                            Status.EMPTY -> {
                                progressBar.visibility = View.GONE
                            }
                        }
                    }
            }
        }
    }

}

class ProductViewHolder(view: View) : BaseViewHolder(view) {
    val itemBinding: SingleHomeProductItemBinding by BindListItem(view)
}