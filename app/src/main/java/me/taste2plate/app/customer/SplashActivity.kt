package me.taste2plate.app.customer

import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationManager
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.text.TextUtils
import android.util.Log
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AlertDialog
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import com.clickzin.tracking.ClickzinTracker
import com.google.android.gms.tasks.Task
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.firebase.iid.FirebaseInstanceId
import com.google.firebase.messaging.FirebaseMessaging
import com.trackier.sdk.TrackierEvent
import com.trackier.sdk.TrackierSDK
import me.taste2plate.app.customer.common.Status
import me.taste2plate.app.customer.ui.WooDroidActivity
import me.taste2plate.app.customer.ui.home.HomeActivity
import me.taste2plate.app.customer.ui.onboarding.OnBoardActivity
import me.taste2plate.app.customer.utils.AppUtils
import me.taste2plate.app.customer.viewmodels.UserViewModel
import me.taste2plate.app.data.api.RegistrationData
import java.io.IOException
import kotlin.math.min
import kotlin.system.exitProcess


class SplashActivity : WooDroidActivity<UserViewModel>() {

    private var customer: RegistrationData? = null
    override lateinit var viewModel: UserViewModel
    private var isVersionCheckComplete: Boolean = false
    var gps_enabled = false
    val REQUEST_CODE_FOREGROUND = 0
    private var permissionDoNotAllowed = false

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = getViewModel(UserViewModel::class.java)
        customer = AppUtils(this).user
        isVersionCheckComplete = false

        Log.e("Token", "onCreate: ${FirebaseInstanceId.getInstance().getToken()}")

    }

    private fun startTrackingWithTrackier() {

        val event = TrackierEvent(TrackierEvent.START_TRIAL)
        TrackierSDK.trackEvent(event)

    }

    private fun startTracking() {
        val appKey = "kalpssoft"
        ClickzinTracker.getInstance().init(applicationContext, appKey, null)
        ClickzinTracker.getInstance().setCustomerId("pradeep")
        ClickzinTracker.getInstance().startTracking("Install")

        /*    val call = TrackerService().getBaseUrl().create(TrackerApi::class.java)

            call.install("1").enqueue(object : Callback<TrackerModel> {
                override fun onResponse(
                    call: Call<TrackerModel>,
                    response: Response<TrackerModel>
                ) {
                    Log.e("TAG", "onSuccess: ${response.body()}")
                }

                override fun onFailure(call: Call<TrackerModel>, t: Throwable) {
                    Log.e("TAG", "onFailure: $t")
                }
            })*/
    }

    private fun pushNotification() {
        try {

            FirebaseMessaging.getInstance().subscribeToTopic("install")

            FirebaseMessaging.getInstance().token.addOnSuccessListener { token: String ->
                if (!TextUtils.isEmpty(token)) {
                    Log.e(
                        "Token",
                        "retrieve token successful : $token"
                    )
                } else {
                    Log.e(
                        "Token",
                        "token should not be null..."
                    )
                }
            }.addOnFailureListener { }.addOnCanceledListener {}
                .addOnCompleteListener { task: Task<String> ->
                    try {
                        Log.e(
                            "Token",
                            "This is the token : " + task.result
                        )
                    }catch(exception: Exception){

                    }
                }
        } catch (exception: IOException) {
            Log.e("firebase", exception.toString())
        }

    }

    private fun getAppData() {
        viewModel.fetchAppData().observe(this, Observer { response ->
            when (response!!.status()) {
                Status.LOADING -> {
                    showLoading()
                }

                Status.SUCCESS -> {
                    AppUtils(this).saveAppData(response.data())
                    stopShowingLoading()
                    val minLength = min(
                        BuildConfig.VERSION_NAME.length,
                        response.data().result.customerAndroidVersion.length
                    )

                    val replace1 =
                        BuildConfig.VERSION_NAME.take(minLength).replace(".", "").toFloat()
                    val replace2 = response.data().result.customerAndroidVersion.take(minLength)
                        .replace(".", "").toFloat()

                    Log.e(
                        "TAG",
                        "minLength: $minLength\n replace1 : $replace1\n replace2: $replace2"
                    )

                    if (BuildConfig.VERSION_NAME.take(minLength).replace(".", "")
                            .toFloat() < response.data().result.customerAndroidVersion.take(
                            minLength
                        ).replace(".", "").toFloat()
                    ) {
                        showVersionAlert()
                    } else {
                        moveToNext()
                    }
                }

                Status.ERROR -> {
                    stopShowingLoading()
                    MaterialAlertDialogBuilder(this@SplashActivity)
                        .setTitle("No Internet")
                        .setCancelable(false)
                        .setMessage("No Internet Connection!")
                        .setPositiveButton("Exit") { _, _ ->
                            exitProcess(0)
                        }
                        .show()
                }

                Status.EMPTY -> {
                    stopShowingLoading()
                }
            }
        })
    }

    private fun moveToNext() {
        Handler(Looper.getMainLooper()).postDelayed({
            if (customer != null) {
                startActivity(Intent(baseContext, HomeActivity::class.java))
            } else {
                startActivity(Intent(baseContext, OnBoardActivity::class.java))
            }
            finish()
        }, 2000)
    }

    private fun showVersionAlert() {
        AlertDialog.Builder(this).setCancelable(false)
            .setMessage(getString(R.string.imp_update_msg))
            .setTitle("Alert")
            .setCancelable(false)
            .setPositiveButton(getString(R.string.alert_ok)) { _, _ ->
                val appPackageName = packageName // getPackageName() from Context or Activity object
                try {
                    startActivity(
                        Intent(
                            Intent.ACTION_VIEW,
                            Uri.parse("market://details?id=$appPackageName")
                        )
                    )
                } catch (anfe: android.content.ActivityNotFoundException) {
                    startActivity(
                        Intent(
                            Intent.ACTION_VIEW,
                            Uri.parse("https://play.google.com/store/apps/details?id=$appPackageName")
                        )
                    )
                }
            }.setNegativeButton(getString(R.string.alert_cancel)) { _, _ -> exitProcess(0) }
            .create().show()
    }

    private fun checkLocationPermission(): Boolean {
        val permissionLocation1 =
            ContextCompat.checkSelfPermission(
                this,
                android.Manifest.permission.ACCESS_COARSE_LOCATION
            )

        val permissionLocation2 =
            ContextCompat.checkSelfPermission(
                this,
                android.Manifest.permission.ACCESS_FINE_LOCATION
            )

        val listPermissionsNeeded: ArrayList<String> = ArrayList()

        if (permissionLocation2 != PackageManager.PERMISSION_GRANTED) {
            listPermissionsNeeded.add(android.Manifest.permission.ACCESS_COARSE_LOCATION);
        }

        if (permissionLocation1 != PackageManager.PERMISSION_GRANTED) {
            listPermissionsNeeded.add(android.Manifest.permission.ACCESS_FINE_LOCATION);
        }

        if (listPermissionsNeeded.isNotEmpty()) {
            PermissionUtils.requestPermission(
                this@SplashActivity, listPermissionsNeeded,
                1
            )
            return false;
        }
        return true;
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        val permissionReturn: Int = ContextCompat.checkSelfPermission(
            this@SplashActivity,
            android.Manifest.permission.ACCESS_FINE_LOCATION
        )

        when (requestCode) {
            1 -> {
                if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    Log.e("location", "onRequestPermissionsResult: $permissionReturn")

                    if (ContextCompat.checkSelfPermission(
                            this@SplashActivity,
                            android.Manifest.permission.ACCESS_FINE_LOCATION
                        ) == PackageManager.PERMISSION_GRANTED
                    ) {
                        getAppData()

                        startTracking()

                        startTrackingWithTrackier()

                        pushNotification()

                        Toast.makeText(this, "Permission Granted", Toast.LENGTH_SHORT).show()
                    }
                } else {
                    if(!permissionDoNotAllowed){
                        if (ActivityCompat.shouldShowRequestPermissionRationale(
                                this@SplashActivity,
                                android.Manifest.permission.ACCESS_FINE_LOCATION
                            )
                        ) {
                            checkLocationPermission()
                            /*Toast.makeText(
                                this,
                                "Please allow location permission then you can able to access app",
                                Toast.LENGTH_SHORT
                            ).show()*/
                        } else {
                            permissionDoNotAllowed = true
                            MaterialAlertDialogBuilder(this@SplashActivity)
                                .setTitle("Location Disabled")
                                .setCancelable(false)
                                .setMessage("Location services are disabled")
                                .setPositiveButton("Start") { _, _ ->
                                    startActivity(Intent(android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS))
                                    //check
                                    //checkLocationPermission()
                                }
                                //startActivity(Intent(this@SplashActivity, SplashActivity::class.java))
                                .setNegativeButton(getString(R.string.alert_cancel)) { _, _ ->
                                    exitProcess(
                                        0
                                    )
                                }
                                .show()
                        }
                    }

                }
            }
        }
    }

    override fun onResume() {
        super.onResume()
        if(checkLocationPermission())
        {
            getAppData()

            startTracking()

            startTrackingWithTrackier()

            pushNotification()
        }
    }
}
