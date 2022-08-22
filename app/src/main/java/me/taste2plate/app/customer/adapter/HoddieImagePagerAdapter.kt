package me.taste2plate.app.customer.adapter


import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.facebook.drawee.view.SimpleDraweeView
import com.squareup.picasso.Picasso
import me.taste2plate.app.customer.R
import me.taste2plate.app.customer.common.ScaleImageView
import me.taste2plate.app.customer.ui.product.ProductActivity
import me.taste2plate.app.customer.ui.product.ShopActivity
import me.taste2plate.app.customer.utils.AppUtils
import me.taste2plate.app.models.Product
import me.taste2plate.app.models.home.Slider
import me.taste2plate.app.models.newproducts.ShowError
import org.greenrobot.eventbus.EventBus


class HoddieImagePagerAdapter(
    val context: Context,
    private val images: List<Slider>
) :
    androidx.viewpager.widget.PagerAdapter() {


    override fun instantiateItem(collection: ViewGroup, position: Int): View {
        val inflater = LayoutInflater.from(context)

        val layout = inflater.inflate(
            R.layout.single_slider_image,
            collection,
            false
        )
        val ivImage =
            layout.findViewById<ImageView>(R.id.ivImage)

        //ivImage.setActualImageResource(mResources[position])

        val image = images[position]
        val finalStrUrl=image.file
        Picasso.get().load(finalStrUrl).into(ivImage)

       /* ivImage.setOnClickListener {
            val intent = Intent(context, ShopActivity::class.java)
            intent.putExtra("id", images[position].city._id)
            intent.putExtra("name", images[position].city.name)
            intent.putExtra("type", "City")
            context.startActivity(intent)

           *//* if(AppUtils(context).defaultAddress!=null) {
                val intent = Intent(context, ShopActivity::class.java)
                intent.putExtra("id", images[position].city._id)
                intent.putExtra("name", images[position].city.name)
                intent.putExtra("type", "City")
                context.startActivity(intent)
            }else{
                EventBus.getDefault().post(ShowError())
            }*//*
        }*/

        collection.addView(layout)
        return layout
    }

    override fun destroyItem(container: ViewGroup, position: Int, view: Any) {
        container.removeView(view as View)
    }

    override fun getCount(): Int {
        return this.images.size
    }

    override fun isViewFromObject(view: View, obj: Any): Boolean {
        return view == obj
    }

}