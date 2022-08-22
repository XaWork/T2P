package me.taste2plate.app.customer.adapter.viewholder

import android.content.Context
import android.content.Intent
import android.text.Html
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.facebook.drawee.view.SimpleDraweeView
import com.squareup.picasso.Picasso
import me.taste2plate.app.customer.R
import me.taste2plate.app.customer.ui.DetailsActivity
import me.taste2plate.app.customer.ui.product.ShopActivity
import me.taste2plate.app.models.CityBrand


class CityBrandViewHolder(
    val context: Context,
    itemView: View,
    private val type: String
) :
    androidx.recyclerview.widget.RecyclerView.ViewHolder(itemView) {

    fun renderView(cityBrand: CityBrand.Result) {
        val ivImage = itemView.findViewById<ImageView>(R.id.ivImage)
        val tvTitle = itemView.findViewById<TextView>(R.id.tvTitle)
        val viewDetails = itemView.findViewById<TextView>(R.id.viewDetails)

        tvTitle.text = cityBrand.name
        if (type.contentEquals("City")) {
            if (cityBrand.file.isNotEmpty()) {
                val finalStrUrl = cityBrand.file
                Picasso
                    .get()
                    .load(finalStrUrl)
                    .placeholder(R.drawable.image_border)
                    .resize(100, 100)
                    .into(ivImage)

            } else {
                when {
                    cityBrand.name?.contentEquals("Hyderabad")!! -> {
                        ivImage.setImageResource(R.drawable.hydrabad_city);
                    }
                    cityBrand.name?.contentEquals("IMPHAL")!! -> {
                        ivImage.setImageResource(R.drawable.imphal_city);
                    }
                    cityBrand.name!!.contentEquals("Jaipur") -> {
                        ivImage.setImageResource(R.drawable.jaipur_city);
                    }
                    cityBrand.name!!.contentEquals("Kolkata") -> {
                        ivImage.setImageResource(R.drawable.kolkata_city);
                    }
                    cityBrand.name!!.contentEquals("Lucknow") -> {
                        ivImage.setImageResource(R.drawable.lakhnow);
                    }
                    else -> {
                        ivImage.setImageResource(R.drawable.slide_4);
                    }
                }
            }
        } else {
            if (cityBrand.file.isNotEmpty()) {
                val finalStrUrl = cityBrand.file
                Picasso
                    .get()
                    .load(finalStrUrl)
                    .placeholder(R.drawable.image_border)
                    .resize(100, 100)
                    .into(ivImage)
            } else {
                ivImage.setImageResource(R.drawable.slide_3);
            }
        }

        tvTitle.setOnClickListener {
            val intent = Intent(context, ShopActivity::class.java)
            intent.putExtra("id", cityBrand._id)
            intent.putExtra("name", cityBrand.name)
            intent.putExtra("type", type)
            context.startActivity(intent)
        }

        viewDetails.setOnClickListener {
            val intent = Intent(context, DetailsActivity::class.java)
            intent.putExtra("name", cityBrand.name)
            intent.putExtra("type", type)
            if(type.contentEquals("Brand")){
                intent.putExtra("desc", Html.fromHtml(cityBrand.desc.orEmpty()).toString())
            }else{
                intent.putExtra("desc", Html.fromHtml(cityBrand.description.orEmpty()).toString())
            }

            intent.putExtra("image", cityBrand.file)
            context.startActivity(intent)
        }

    }


}