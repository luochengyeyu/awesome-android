package com.lcyy.foundation.ui.activity

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.lcyy.foundation.R
import com.dylanc.viewbinding.binding
import com.lcyy.foundation.databinding.ActivitySingleTopBinding
import com.lycc.core.ext.startActivity
import com.orhanobut.logger.Logger

class SingleTopActivity : AppCompatActivity(R.layout.activity_single_top) {
    private val binding: ActivitySingleTopBinding by binding()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Logger.d("SingleTopActivity.onCreate()")
        binding.run {
            buttonStandTop.setOnClickListener {
                startActivity<StandardActivity>()
            }
            buttonSingleTop.setOnClickListener {
                startActivity<SingleTopActivity>()
            }
            buttonSingleTask.setOnClickListener {
                startActivity<SingleTaskActivity>()
            }
            buttonSingleInstance.setOnClickListener {
                startActivity<SingleInstanceActivity>()
            }
        }
    }

    @SuppressLint("MissingSuperCall")
    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        Logger.d("SingleTopActivity.onNewIntent()")
    }
}