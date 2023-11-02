package com.lcyy.foundation.ui.fragment

import android.Manifest
import android.os.Bundle
import android.view.View
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import com.dylanc.viewbinding.binding
import com.lcyy.foundation.R
import com.lcyy.foundation.databinding.FragmentActivityResultBinding

class ActivityResultFragment : Fragment(R.layout.fragment_activity_result) {


    private val binding: FragmentActivityResultBinding by binding()

    private val requestPermission =
        registerForActivityResult(ActivityResultContracts.RequestMultiplePermissions()) { permissions ->
            binding.tvResult.text = ""
            permissions.entries.forEach {
                val permissionName = it.key
                val isGranted = it.value
                val item = "$permissionName -> $isGranted\n"
                binding.tvResult.text = "${binding.tvResult.text}$item"
            }
        }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.run {
            btnLocationPermission.setOnClickListener {
                requestPermission.launch(
                    arrayOf(
                        Manifest.permission.ACCESS_COARSE_LOCATION,
                        Manifest.permission.ACCESS_FINE_LOCATION
                    )
                )
            }
        }
    }
}