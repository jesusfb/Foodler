package com.example.foodler.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.example.foodler.R
import com.example.foodler.databinding.BottomSheetLayoutBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class BottomSheetFragment : BottomSheetDialogFragment() {

    private var _binding: BottomSheetLayoutBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = BottomSheetLayoutBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val args = arguments
        val title = args?.getString(ARG_TITLE)
        val options = args?.getStringArray(ARG_OPTIONS)

        binding.titleTextView.text = title

        val adapter = options?.let {
            ArrayAdapter(requireContext(), R.layout.bottom_sheet_items, R.id.text1, it)
        }
        binding.optionsListView.adapter = adapter

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        private const val ARG_TITLE = "arg_title"
        private const val ARG_OPTIONS = "arg_options"

        fun newInstance(title: String, options: Array<String>): BottomSheetFragment {
            val fragment = BottomSheetFragment()
            val args = Bundle()
            args.putString(ARG_TITLE, title)
            args.putStringArray(ARG_OPTIONS, options)
            fragment.arguments = args
            return fragment
        }
    }
}
