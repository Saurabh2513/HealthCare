package com.example.onboarding.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.onboarding.viewholder.SendMoneyHolder
import com.example.phonepe.databinding.SenMoneyItemBinding

class SendMoneyAdapter(private val arrayContact: List<SendMoneyHolder>) :
    RecyclerView.Adapter<SendMoneyAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =   SenMoneyItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return arrayContact.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder) {
            with(arrayContact[position]) {
                binding.txtName.text = this.name
                binding.text.text = this.text
                binding.time.text = this.time.toString()
            }

        }
    }

    class ViewHolder(val binding: SenMoneyItemBinding) : RecyclerView.ViewHolder(binding.root) {


    }
}
