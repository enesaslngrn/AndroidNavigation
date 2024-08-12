package com.example.androidnavigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.androidnavigation.databinding.FragmentFirst1Binding


class First1Fragment : Fragment() {
    private lateinit var binding: FragmentFirst1Binding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFirst1Binding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnFirst1ToFirst2.setOnClickListener {
            findNavController().navigate(R.id.action_first1Fragment_to_first2Fragment)
        }

    }
}