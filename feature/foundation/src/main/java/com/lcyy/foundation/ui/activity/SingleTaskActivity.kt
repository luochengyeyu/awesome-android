package com.lcyy.foundation.ui.activity

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dylanc.viewbinding.binding
import com.lcyy.foundation.R
import com.lcyy.foundation.databinding.ActivitySingleTaskBinding
import com.lycc.core.ext.startActivity
import com.orhanobut.logger.Logger

class SingleTaskActivity : AppCompatActivity(R.layout.activity_single_task) {

    private val binding: ActivitySingleTaskBinding by binding()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Logger.d("SingleTaskActivity.onCreate()")
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
        Logger.d("SingleTaskActivity.onNewIntent()")
    }
}