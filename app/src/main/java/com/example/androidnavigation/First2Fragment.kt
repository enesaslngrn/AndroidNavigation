package com.example.androidnavigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.androidnavigation.databinding.FragmentFirst2Binding


class First2Fragment : Fragment() {
    private lateinit var binding: FragmentFirst2Binding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFirst2Binding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.btnFirst2ToFirst3.setOnClickListener {
            findNavController().navigate(R.id.action_first2Fragment_to_first3Fragment)
        }
    }

}