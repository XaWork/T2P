package me.taste2plate.app.data.api


import retrofit2.Call
import me.taste2plate.app.models.SettingGroup
import me.taste2plate.app.models.SettingOption
import retrofit2.http.*

interface SettingsAPI {

    @GET("settings")
    fun settings(): Call<List<SettingGroup>>

    @GET("settings/{group_id}/{id}")
    fun option(@Path("group_id") group_id: String, @Path("id") option_id: String): Call<SettingOption>

    @GET("settings/{id}")
    fun options(@Path("id") group_id: String): Call<List<SettingOption>>

    @Headers("Content-Type: application/json")
    @PUT("settings/{group_id}/{id}")
    fun update(
        @Path("group_id") group_id: String,
        @Path("id") option_id: String,
        @Body body: SettingOption
    ): Call<SettingOption>
}