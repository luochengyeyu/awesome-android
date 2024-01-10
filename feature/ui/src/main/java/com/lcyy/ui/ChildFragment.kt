package com.lcyy.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment

class ChildFragment : Fragment(R.layout.fragment_child) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("FragmentManager","ChildFragment.parentFragmentManager: $parentFragmentManager")
    }
}