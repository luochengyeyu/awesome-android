package com.lycc.arch

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.dylanc.viewbinding.binding
import com.lycc.arch.databinding.ActivityMainBinding
import com.lycc.arch.mvp.login.LoginActivity

class MainActivity : AppCompatActivity(R.layout.activity_main) {
    private val binding: ActivityMainBinding by binding()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.run {
            btnMvp.setOnClickListener {
                startActivity(Intent(this@MainActivity, LoginActivity::class.java))
            }
            btnMvvm.setOnClickListener {
                toast("MVVM")
            }
        }
    }
}