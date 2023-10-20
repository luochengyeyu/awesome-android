package com.lcyy.android.feature.jetpack

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.lcyy.android.R
import com.lcyy.android.utils.log

class ViewModelFragment : Fragment() {

    private val sharedViewModel: SharedViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        sharedViewModel.view()
        log("ViewModelFragment $sharedViewModel")
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_view_model, container, false)
    }

}