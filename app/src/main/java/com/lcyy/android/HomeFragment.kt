package com.lcyy.android

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.lcyy.android.databinding.FragmentHomeBinding
import com.dylanc.viewbinding.binding

class HomeFragment : Fragment(R.layout.fragment_home) {

    private val binding: FragmentHomeBinding by binding()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.run {
            btnSharedViewModel.setOnClickListener {
                findNavController().navigate(R.id.action_navigation_home_to_page_shared_view_model)
            }
            btnRetrofit.setOnClickListener {
                findNavController().navigate(R.id.action_navigation_home_to_page_retrofit)
            }
            btnMvi.setOnClickListener {
                findNavController().navigate(R.id.action_navigation_home_to_page_mvi)
            }
        }
    }
}