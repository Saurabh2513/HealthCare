package com.example.tabbarui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.tabbarui.R
import com.example.tabbarui.databinding.FragmentChatBinding

class ChatFragment : Fragment() {
 lateinit var binding : FragmentChatBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_chat,container,false)
        return binding.root
    }

    companion object {
        fun onNewInstance():ChatFragment{
           val fragment = ChatFragment()
           return fragment
        }
    }
}