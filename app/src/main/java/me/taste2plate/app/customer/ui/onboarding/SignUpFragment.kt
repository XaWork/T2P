package me.taste2plate.app.customer.ui.onboarding

import android.content.Intent
import android.os.Bundle
import android.text.Html
import android.text.TextUtils
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.clickzin.tracking.ClickzinTracker
import com.clickzin.tracking.utils.ClickzinUtils
import com.facebook.FacebookSdk.getApplicationContext
import com.facebook.appevents.AppEventsConstants
import com.facebook.appevents.AppEventsLogger
import com.trackier.sdk.TrackierEvent
import com.trackier.sdk.TrackierSDK
import kotlinx.android.synthetic.main.fragment_sign_up.*
import me.taste2plate.app.customer.R
import me.taste2plate.app.customer.common.Status
import me.taste2plate.app.customer.common.TermsActivity
import me.taste2plate.app.customer.tracker.TrackerApi
import me.taste2plate.app.customer.tracker.TrackerModel
import me.taste2plate.app.customer.tracker.TrackerService
import me.taste2plate.app.customer.ui.home.HomeActivity
import me.taste2plate.app.customer.ui.state.ProgressDialogFragment
import me.taste2plate.app.customer.utils.AppUtils
import me.taste2plate.app.customer.viewmodels.UserViewModel
import me.taste2plate.app.data.api.RegistrationData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.regex.Matcher
import java.util.regex.Pattern

class SignUpFragment : Fragment() {


    private lateinit var mobileNumber: String
    lateinit var viewModel: UserViewModel
    val TAG = "SignUpFragment"

    private lateinit var progressDialog: ProgressDialogFragment
    private val pattern = Pattern.compile(EMAIL_PATTERN)
    private var matcher: Matcher? = null
    private var phoneNumber: String? = ""
    private var detailId: String? = ""
    private var data:RegistrationData? = null

    fun newInstance(): SignUpFragment? {
        return SignUpFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(
            R.layout.fragment_sign_up,
            container,
            false
        )
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        viewModel = (activity as OnBoardActivity).getViewModel(UserViewModel::class.java)
        detailId = ""
        etOtp.isEnabled = false
        bNext.text = getString(R.string.get_otp)
        bNext.setOnClickListener {
            if(tc.isChecked) {
                if (detailId?.isEmpty()!!) {
                    signUp()
                } else {
                    validateOtp()
                }
            }else{
                Toast.makeText(context, "Please accept the Terms and Conditions!", Toast.LENGTH_LONG).show()
            }
        }
        val text = "By signing up, you agree to our <span style=\"color:#de2228\">Terms</span> and <span style=\"color:#de2228\">Conditions</span>"
        terms.text = Html.fromHtml(text.trim())

        terms.setOnClickListener {
            startActivity(Intent(context, TermsActivity::class.java))
        }
    }

    private fun signUp() {
        val email = etEmail.text.toString()
        phoneNumber = etPhoneNumber.text.toString()
        val referredBy = referral.text.toString()
        if (validates()) {
            viewModel.signup(email, phoneNumber, AppUtils(activity).token, referredBy).observe(viewLifecycleOwner, Observer { response ->
                when (response!!.status()) {
                    Status.LOADING -> {
                        (activity as OnBoardActivity).showLoading()
                    }

                    Status.SUCCESS -> {
                        (activity as OnBoardActivity).stopShowingLoading()
                        if (response.isSuccessful && response.data().status.orEmpty().contentEquals("success")) {
                            Log.e("Data", response.data().toString())
                            etOtp.isEnabled = true
                            detailId = response.data().message
                            bNext.text = "Verify OTP"
                            Toast.makeText(
                                activity,
                                response.data().message,
                                Toast.LENGTH_LONG
                            ).show()
                        } else {
                            Log.e("TAG", "signUp: $response", )
                            Toast.makeText(
                                activity,
                                response.data().message,
                                Toast.LENGTH_SHORT
                            )
                                .show()
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

        val email = etEmail.text.toString()
        val mobile = etPhoneNumber.text.toString()


        if (!validateEmail(email)) {
            Toast.makeText(context,"Invalid Email!", Toast.LENGTH_LONG).show()
            validation = false
        }else if (mobile.isEmpty()) {
            Toast.makeText(context,getString(R.string.please_enter_mobile_number), Toast.LENGTH_LONG).show()
            validation = false
        }

        return validation
    }

    private fun validateEmail(email: String): Boolean {
        matcher = pattern.matcher(email)
        return matcher!!.matches()
    }

    companion object {
        private const val EMAIL_PATTERN =
            "^[a-zA-Z0-9#_~!$&'()*+,;=:.\"(),:;<>@\\[\\]\\\\]+@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*$"
    }

    private fun validateOtp() {
        if (validates() && !TextUtils.isEmpty(etOtp.text)) {
            val phoneNumber = etPhoneNumber.text.toString()
            val otp = etOtp.text.toString()
            val deviceToken = AppUtils(context).token

            viewModel.verifyOtp(phoneNumber, otp, deviceToken)
                .observe(viewLifecycleOwner, Observer { response ->
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
                                data = otpResponse.data
                                AppUtils(activity).saveUser(data)

                                addAppEvent()
                                ClickzinTracker.getInstance().startTracking("Registration")

                                startTrackingWithTrackier()

                                moveToDashBoard()
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
                                "Please check email/id password.",
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

    private fun startTrackingWithTrackier() {

        val event = TrackierEvent("Register")
        TrackierSDK.trackEvent(event)

        //Log.e("trackier", "start login tracker event: ${TrackierSDK.isEnabled()}", )
    }

    private fun addAppEvent(){
        val logger = AppEventsLogger.newLogger(context!!)
        logger.logEvent(AppEventsConstants.EVENT_NAME_COMPLETED_REGISTRATION);
    }

    private fun trackerRegistrationPostback() {
        val call = TrackerService().getBaseUrl().create(TrackerApi::class.java)

        call.registration("2").enqueue(object : Callback<TrackerModel> {
            override fun onResponse(
                call: Call<TrackerModel>,
                response: Response<TrackerModel>
            ) {
                Log.e("TAG", "onSuccess: ${response.body()}")
            }

            override fun onFailure(call: Call<TrackerModel>, t: Throwable) {
                Log.e("TAG", "onFailure: $t")
            }
        })
    }

    private fun moveToDashBoard() {
        ClickzinTracker.getInstance().trackEvents(context, "register", HashMap())
        startActivity(
            Intent(
                activity,
                HomeActivity::class.java
            ).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        )
    }

}
