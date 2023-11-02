package com.lcyy.foundation.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.lcyy.foundation.R
import com.lcyy.foundation.databinding.FragmentHomeBinding
import com.dylanc.viewbinding.binding

class HomeFragment : Fragment(R.layout.fragment_home) {


    private val binding :FragmentHomeBinding by binding()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.run {
            btnLaunchMode.setOnClickListener {
                findNavController().navigate(R.id.action_HomeFragment_to_LaunchModeFragment)
            }
            btnActivityResult.setOnClickListener {
                findNavController().navigate(R.id.action_HomeFragment_to_ActivityResultFragment)
            }

        }
    }
}