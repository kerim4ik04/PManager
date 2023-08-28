package com.example.pmanager.ui.onboarding.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.pmanager.databinding.ItemOnboardingBinding
import com.example.pmanager.loadImage
import com.example.pmanager.model.OnBoarding

class OnBoardingAdapter(private val onClick: () -> Unit) :
    Adapter<OnBoardingAdapter.OnBoardingViewHolder>() {

    private val list = arrayListOf(
        OnBoarding(title = "жирный текст", description = "длинный тонкий текст", image = "https://s1.1zoom.me/big0/50/Cats_Glance_White_496590.jpg"),
        OnBoarding(title = "масивный текст", description = "не толстый большой текст", image = "https://s1.1zoom.ru/big0/367/Elephants_White_background_541965_1312x1024.jpg"),
        OnBoarding(title = "толстый текст", description = "худой огромный текст", image = "https://s1.1zoom.ru/b3851/171/Cats_White_background_Glance_525800_3840x2160.jpg")
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OnBoardingViewHolder {
        return OnBoardingViewHolder(
            ItemOnboardingBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: OnBoardingViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class OnBoardingViewHolder(private val binding: ItemOnboardingBinding) :
        ViewHolder(binding.root) {
        fun bind(onBoarding: OnBoarding) {
            binding.tvTitle.text = onBoarding.title
            binding.tvDesc.text = onBoarding.description
            binding.ivBoard.loadImage(onBoarding.image?: "")
             if (adapterPosition==list.lastIndex){
                binding.btnStart.isVisible=true
            }else{
                binding.btnSkip.isVisible=true
            }
            binding.btnStart.setOnClickListener {
                onClick()
            }
            binding.btnSkip.setOnClickListener{
                onClick()
            }
        }
    }
}