package me.taste2plate.app.models.home

import androidx.annotation.Keep
import me.taste2plate.app.models.Category
import me.taste2plate.app.models.CityBrand
import me.taste2plate.app.models.address.cityzip.CityOption

@Keep
data class HomePageResponse(
    val best_seller: ArrayList<ProductDeal>,
    val category: List<Category.Result>,
    val message: String,
    val product_deal: ArrayList<ProductDeal>,
    val combo: ArrayList<ProductDeal>,
    val featured: ArrayList<ProductDeal>,
    val slider: ArrayList<Slider>,
    val cuisine: ArrayList<CityBrand.Result>,
    val city: ArrayList<CityOption>,
    val status: String
)