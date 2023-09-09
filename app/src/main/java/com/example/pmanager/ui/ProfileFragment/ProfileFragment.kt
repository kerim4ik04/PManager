package com.example.pmanager.ui.ProfileFragment

import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.widget.addTextChangedListener
import com.bumptech.glide.Glide
import com.example.pmanager.data.local.Pref
import com.example.pmanager.databinding.FragmentProfileBinding

class ProfileFragment : Fragment() {

    private lateinit var binding: FragmentProfileBinding

    private val pref: Pref by lazy {
        Pref(requireContext())
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    private val getContent =
        registerForActivityResult(ActivityResultContracts.GetContent()) { uri: Uri? ->
            Glide.with(requireContext()).load(uri.toString()).into(binding.profileImage)
            pref.setAvatar(uri)
        }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.edName.setText(pref.getName())
        binding.edName.addTextChangedListener {
            pref.saveName(binding.edName.text.toString())
        }
        Glide.with(requireContext()).load(pref.getAvatar()).into(binding.profileImage)

        binding.profileImage.setOnClickListener {
            getContent.launch("image/*")
        }
    }
}