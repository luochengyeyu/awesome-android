package com.lcyy.foundation.ui.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.lcyy.foundation.R
import com.dylanc.viewbinding.binding
import com.lcyy.foundation.databinding.FragmentLaunchModeBinding

class LaunchModeFragment : Fragment(R.layout.fragment_launch_mode) {

    private val binding: FragmentLaunchModeBinding by binding()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.run {
            buttonStandard.setOnClickListener {
                findNavController().navigate(R.id.action_LaunchModeFragment_to_StandardActivity)
            }
            buttonSingleTop.setOnClickListener {
                findNavController().navigate(R.id.action_LaunchModeFragment_to_SingleTopActivity)
            }
            buttonSingleTask.setOnClickListener {
                findNavController().navigate(R.id.action_LaunchModeFragment_to_SingleTaskActivity)
            }
            buttonSingleInstance.setOnClickListener {
                findNavController().navigate(R.id.action_LaunchModeFragment_to_SingleInstanceActivity)
            }
        }
    }
}