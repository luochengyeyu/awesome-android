package com.lcyy.android.feature.jetpack

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.lcyy.android.R
import com.lcyy.android.databinding.FragmentSharedViewModelBinding
import com.lcyy.android.utils.log

class SharedViewModelFragment : Fragment() {

    private var _binding: FragmentSharedViewModelBinding? = null

    private val binding get() = _binding!!

    private val sharedViewModel: SharedViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSharedViewModelBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.run {
            btnViewModel.setOnClickListener {
                findNavController().navigate(R.id.action_page_shared_view_model_to_page_viewmodel)
            }
            btnLivedata.setOnClickListener {
                findNavController().navigate(R.id.action_page_shared_view_model_to_page_livedata)
            }

        }
        log("SharedViewModelFragment $sharedViewModel")
        sharedViewModel.count.observe(viewLifecycleOwner) { count ->
            log(count.toString())
            binding.tvView.text = getString(R.string.view, count)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}