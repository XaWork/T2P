package me.taste2plate.app.repo.product

import me.taste2plate.app.data.api.ShippingClassAPI
import me.taste2plate.app.models.ShippingClass
import me.taste2plate.app.models.filters.ShippingClassesFilter
import me.taste2plate.app.repo.WooRepository
import retrofit2.Call

class ShippingClassRepository(baseUrl: String, consumerKey: String, consumerSecret: String) :
    WooRepository(baseUrl, consumerKey, consumerSecret) {

    private val apiService: ShippingClassAPI

    init {
        apiService = retrofit.create(ShippingClassAPI::class.java)
    }

    fun create(shippingClass: ShippingClass): Call<ShippingClass> {
        return apiService.create(shippingClass)
    }


    fun shippingClass(id: Int): Call<ShippingClass> {
        return apiService.view(id)
    }

    fun shippingClasses(): Call<List<ShippingClass>> {
        return apiService.list()
    }

    fun shippingClasses(shippingClassesFilter: ShippingClassesFilter): Call<List<ShippingClass>> {
        return apiService.filter(shippingClassesFilter.filters)
    }

    fun update(id: Int, shippingClass: ShippingClass): Call<ShippingClass> {
        return apiService.update(id, shippingClass)
    }

    fun delete(id: Int): Call<ShippingClass> {
        return apiService.delete(id)
    }

    fun delete(id: Int, force: Boolean): Call<ShippingClass> {
        return apiService.delete(id, force)
    }


}
