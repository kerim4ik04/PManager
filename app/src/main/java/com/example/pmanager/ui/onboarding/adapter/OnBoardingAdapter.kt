package com.example.pmanager.ui.onboarding.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.pmanager.R
import com.example.pmanager.databinding.ItemOnboardingBinding
import com.example.pmanager.loadImage
import com.example.pmanager.model.OnBoarding

class OnBoardingAdapter(private val onClick: () -> Unit) :
    Adapter<OnBoardingAdapter.OnBoardingViewHolder>() {

    private val list = arrayListOf(
        OnBoarding(title = "жирный текст",
            description = "длинный тонкий текст",
            image = R.raw.animone),
        OnBoarding(title = "масивный текст",
            description = "не толстый большой текст",
            image = R.raw.animone),
        OnBoarding(title = "толстый текст",
            description = "худой огромный текст",
            image = R.raw.animone)
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
            onBoarding.image?.let {
                binding.ivBoard.setAnimation(it)
                binding.ivBoard.playAnimation()
            }

            if (adapterPosition == list.lastIndex) {
                binding.btnStart.isVisible = true
            } else {
                binding.btnSkip.isVisible = true
            }


            binding.btnStart.setOnClickListener {
                onClick()
            }
            binding.btnSkip.setOnClickListener {
                onClick()
            }
        }
    }
}