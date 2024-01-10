package com.lcyy.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.os.bundleOf
import androidx.fragment.app.add
import androidx.fragment.app.commit

class MainActivity : AppCompatActivity(R.layout.activity_main) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("FragmentManager","MainActivity.FragmentManager: $supportFragmentManager")
        if (savedInstanceState == null) {
            val bundle = bundleOf("id" to 0)
            // 若此处无法导入commit|add 方法，
            // 请检查module里是否导入了androidx.fragment:fragment-ktx依赖
            supportFragmentManager.commit {
                setReorderingAllowed(true)
                add<HomeFragment>(R.id.fragment_container_view, args = bundle)
            }
        }
    }
}

