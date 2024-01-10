package com.lcyy.ui

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import com.dylanc.viewbinding.binding
import com.lcyy.ui.databinding.FragmentHomeBinding

class HomeFragment : Fragment(R.layout.fragment_home) {

    private val binding: FragmentHomeBinding by binding()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("FragmentManager","HomeFragment.parentFragmentManager: $parentFragmentManager")
        Log.d("FragmentManager","HomeFragment.childFragmentManager: $childFragmentManager")
    }
}