package me.taste2plate.app.customer.ui.onboarding

import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.text.TextUtils
import android.util.Base64
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import kotlinx.android.synthetic.main.fragment_sign_in.*
import kotlinx.android.synthetic.main.fragment_sign_in.bNext
import me.taste2plate.app.customer.BuildConfig
import me.taste2plate.app.customer.R
import me.taste2plate.app.customer.common.Status
import me.taste2plate.app.customer.ui.home.HomeActivity
import me.taste2plate.app.customer.ui.landing.DashboardActivity
import me.taste2plate.app.customer.ui.state.ProgressDialogFragment
import me.taste2plate.app.customer.utils.AppUtils
import me.taste2plate.app.customer.utils.MySMSBroadcastReceiver
import me.taste2plate.app.customer.viewmodels.UserViewModel
import me.taste2plate.app.models.filters.CustomerFilter
import java.util.regex.Matcher
import java.util.regex.Pattern
import kotlin.math.min
import kotlin.system.exitProcess


class SignInFragment : androidx.fragment.app.Fragment() {


    lateinit var viewModel: UserViewModel

    private lateinit var progressDialog: ProgressDialogFragment
    private val pattern = Pattern.compile(EMAIL_PATTERN)
    private var matcher: Matcher? = null
    private var detailId: String? = ""

    fun newInstance(counter: Int?): SignInFragment? {
        return SignInFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(
            R.layout.fragment_sign_in,
            container,
            false
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = (activity as OnBoardActivity).getViewModel(UserViewModel::class.java)
        detailId = ""
        etOtp.isEnabled = false
        bNext.text = "GET OTP"
        bNext.setOnClickListener {
            if (TextUtils.isEmpty(detailId)) {
                login()
            } else {
                validateOtp(detailId)
            }

        }
        getAppData()

    }


    private fun getAppData(){
        viewModel.fetchAppData().observe(viewLifecycleOwner, Observer {response->
            when (response!!.status()) {
                Status.LOADING -> {
                    //showLoading()
                }

                Status.SUCCESS -> {
                    AppUtils(context).saveAppData(response.data())
                }

                Status.ERROR -> {
                    //stopShowingLoading()
                    context?.let {
                        MaterialAlertDialogBuilder(it)
                            .setTitle("No Internet")
                            .setCancelable(false)
                            .setMessage("No Internet Connection!")
                            .setPositiveButton("Exit") { _, _ ->
                                exitProcess(0)
                            }
                            .show()
                    }
                }

                Status.EMPTY -> {
                    //stopShowingLoading()
                }
            }
        })
    }

    private fun login() {
        val mobile = etPhoneNumber.text.toString()
        if (mobile.isNotEmpty()) {

            viewModel.fetchOtp(mobile, AppUtils(activity).token).observe(this, Observer { response ->
                when (response!!.status()) {
                    Status.LOADING -> {
                        (activity as OnBoardActivity).showLoading(
                            "fetching Otp",
                            "This will only take a short while"
                        )
                    }

                    Status.SUCCESS -> {
                        (activity as OnBoardActivity).stopShowingLoading()
                        val loginResponse = response.data()
                        if (loginResponse.status == "success") {
                            etOtp.isEnabled = true
                            etPhoneNumber.isEnabled = false
                            bNext.text = "LOGIN"
                            detailId = loginResponse.message
                            (activity as OnBoardActivity).showError("Otp has been sent to registered mobile number")
                        } else {
                            (activity as OnBoardActivity).showError("Mobile number is not registered, Please check the number entered or Sign Up")
                        }
                    }
                    Status.ERROR -> {
                        (activity as OnBoardActivity).stopShowingLoading()
                        (activity as OnBoardActivity).showError(response.error().message.toString())

                    }
                    Status.EMPTY -> {
                        (activity as OnBoardActivity).showError("Please check email/id password")
                        (activity as OnBoardActivity).stopShowingLoading()
                    }
                }
            })
        } else {
            Toast.makeText(activity, "Please correct the information entered", Toast.LENGTH_SHORT)
                .show()
        }
    }

    private fun validateOtp(details: String?) {
        if (validates()) {
            val phoneNumber = etPhoneNumber.text.toString()
            val otp = etOtp.text.toString()
            val deviceToken = AppUtils(context).token

            Log.e("TAG", "device token: $deviceToken",)

            viewModel.verifyOtp(phoneNumber, otp, deviceToken).observe(this, Observer { response ->
                when (response!!.status()) {
                    Status.LOADING -> {
                        (activity as OnBoardActivity).showLoading(
                            "Validating otp",
                            "This will only take a short while"
                        )
                    }

                    Status.SUCCESS -> {
                        (activity as OnBoardActivity).stopShowingLoading()
                        val otpResponse = response.data()
                        if (otpResponse.status == "success") {
                            (activity as OnBoardActivity).showError("Verified")
                            AppUtils(activity).saveUser(otpResponse.data!!)

                            // check which data is saved
                            Log.e("TAG", "validateOtp: ${otpResponse.data}", )

                            moveToDashBoard()
                        } else {
                            (activity as OnBoardActivity).showError("Wrong otp, Please enter correct otp")
                        }
                    }

                    Status.ERROR -> {
                        (activity as OnBoardActivity).stopShowingLoading()
                        Toast.makeText(
                            activity,
                            response.error().message.toString(),
                            Toast.LENGTH_LONG
                        ).show()
                    }

                    Status.EMPTY -> {
                        Toast.makeText(
                            activity,
                            "Please check mobile number/otp.",
                            Toast.LENGTH_LONG
                        ).show()
                        (activity as OnBoardActivity).stopShowingLoading()
                    }

                }
            })
        } else {
            Toast.makeText(activity, "Please correct the information entered", Toast.LENGTH_SHORT)
                .show()
        }
    }

    private fun validates(): Boolean {
        var validation = true

        val phoneNumber = etPhoneNumber.text.toString()

        if (phoneNumber.isEmpty()) {
            Toast.makeText(context,"Mobile Number cannot be left blank!", Toast.LENGTH_LONG ).show()
            validation = false
        } else if (etOtp.text.toString().isEmpty()) {
            Toast.makeText(context,"Otp cannot be left blank!", Toast.LENGTH_LONG ).show()
            validation = false
        }

        return validation
    }

    companion object {
        private const val EMAIL_PATTERN =
            "^[a-zA-Z0-9#_~!$&'()*+,;=:.\"(),:;<>@\\[\\]\\\\]+@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*$"
    }

    private fun moveToDashBoard() {
        startActivity(
            Intent(
                activity,
                HomeActivity::class.java
            ).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        )
    }


}
