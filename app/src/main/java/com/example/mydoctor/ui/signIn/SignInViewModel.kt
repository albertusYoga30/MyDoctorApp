package com.example.mydoctor.ui.signIn

import android.content.SharedPreferences
import android.util.Patterns
import androidx.core.content.edit
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mydoctor.data.api.InterfaceAPI
import com.example.mydoctor.data.api.login.SignInRequest
import com.example.mydoctor.data.preference.Const
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SignInViewModel(
    private val sharedPreferences: SharedPreferences
) : ViewModel() {

    val isButtonEnable: MutableLiveData<Boolean> = MutableLiveData(false)
    val goToHomePage: MutableLiveData<Boolean> = MutableLiveData(false)
    val showErrorMessage: MutableLiveData<String> = MutableLiveData()

    private lateinit var interfaceAPI: InterfaceAPI
    private var email: String = ""
    private var password: String = ""

    fun onChangeEmail(email: String) {
        this.email = email
        validateInput()
    }

    fun onChangePassword(password: String) {
        this.password = password
        validateInput()
    }

    private fun validateInput() {
        isButtonEnable.value = email.isNotEmpty() && password.isNotEmpty()
    }

    fun doSignIn() {
        interfaceAPI = InterfaceAPI.getInstance().create(InterfaceAPI::class.java)

        CoroutineScope(Dispatchers.IO).launch {
            val request = SignInRequest(
                login = email,
                password = password
            )

            val response = interfaceAPI.postSignIn(request = request)

            withContext(Dispatchers.Main) {
                if (response.isSuccessful) {
                    val signInResponse = response.body()

                    sharedPreferences.edit {
                        this.putBoolean(Const.IS_LOGIN, true)
                        this.putString(Const.TOKEN, signInResponse?.token)
                        this.putString(Const.USER_ID, signInResponse?.id)
                        this.putString(Const.EMAIL, signInResponse?.email)
                        this.putString(Const.FULL_NAME, signInResponse?.name)
                        this.putString(Const.JOB, signInResponse?.job)
                        this.putString(Const.IMAGE, signInResponse?.image)

                        apply()
                    }
                    goToHomePage.value = true

                } else {
                    showErrorMessage.value = response.errorBody()?.string()
                }
            }
        }
    }
}