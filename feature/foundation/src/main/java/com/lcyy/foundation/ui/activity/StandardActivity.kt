package com.lcyy.foundation.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.lcyy.foundation.R
import com.dylanc.viewbinding.binding
import com.lcyy.foundation.databinding.ActivityStandardBinding
import com.lycc.core.ext.startActivity
import com.orhanobut.logger.Logger

class StandardActivity : AppCompatActivity(R.layout.activity_standard) {

    private val binding: ActivityStandardBinding by binding()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Logger.d("StandardActivity.onCreate()")
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
}