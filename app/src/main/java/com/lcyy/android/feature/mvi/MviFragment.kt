package com.lcyy.android.feature.mvi

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.dylanc.viewbinding.binding
import com.lcyy.android.R
import com.lcyy.android.databinding.FragmentMviBinding

class MviFragment : Fragment(R.layout.fragment_mvi) {

    private val binding by binding<FragmentMviBinding>()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

}