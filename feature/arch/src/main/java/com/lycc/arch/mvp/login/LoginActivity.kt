package com.lycc.arch.mvp.login

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.dylanc.viewbinding.binding
import com.lycc.arch.R
import com.lycc.arch.databinding.ActivityLoginBinding
import com.lycc.arch.toast

class LoginActivity : AppCompatActivity(R.layout.activity_login), LoginContract.View {

    private val binding: ActivityLoginBinding by binding()
    private lateinit var presenter: LoginContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter = LoginPresenter(this, LoginModel())
        binding.btnLogin.setOnClickListener {
            val username = binding.etUsername.text.toString()
            val password = binding.etPassword.text.toString()
            presenter.login(username, password)
        }
    }

    override fun onDestroy() {
        presenter.onDestroy()
        super.onDestroy()
    }

    override fun showLoading() {
        binding.run {
            btnLogin.visibility = View.INVISIBLE
            progressbar.visibility = View.VISIBLE
        }
    }

    override fun hideLoading() {
        binding.run {
            btnLogin.visibility = View.VISIBLE
            progressbar.visibility = View.INVISIBLE
        }
    }

    override fun onLoginSuccess(result: String) {
        toast(result)
    }

    override fun onLoginFailed(result: String) {
        toast(result)
    }

    override fun setPresenter(presenter: LoginContract.Presenter) {
        this.presenter = presenter
    }
}