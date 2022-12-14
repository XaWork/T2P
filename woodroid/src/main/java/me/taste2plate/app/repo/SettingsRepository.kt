package me.taste2plate.app.repo

import android.util.Log
import retrofit2.Call
import me.taste2plate.app.data.api.SettingsAPI
import me.taste2plate.app.models.SettingGroup
import me.taste2plate.app.models.SettingOption

class SettingsRepository(baseUrl: String, consumerKey: String, consumerSecret: String) :
    WooRepository(baseUrl, consumerKey, consumerSecret) {

    private val apiService: SettingsAPI

    init {
        Log.e("TAG", "base url is : $baseUrl: ", )
        apiService = retrofit.create(SettingsAPI::class.java)
    }

    fun settings(): Call<List<SettingGroup>> {
        return apiService.settings()
    }

    fun option(group_id: String, option_id: String): Call<SettingOption> {
        return apiService.option(group_id, option_id)
    }

    fun options(group_id: String): Call<List<SettingOption>> {
        return apiService.options(group_id)
    }

    fun updateOption(group_id: String, option_id: String, option: SettingOption): Call<SettingOption> {
        return apiService.update(group_id, option_id, option)
    }

}
