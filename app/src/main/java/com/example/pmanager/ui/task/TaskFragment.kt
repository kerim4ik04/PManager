package com.example.pmanager.ui.task

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.setFragmentResult
import androidx.navigation.fragment.findNavController
import com.example.pmanager.App
import com.example.pmanager.R
import com.example.pmanager.databinding.FragmentTaskBinding
import com.example.pmanager.model.Task
import com.example.pmanager.ui.home.HomeFragment

class TaskFragment : Fragment() {

    private lateinit var binding: FragmentTaskBinding
    private var task: Task? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentTaskBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        task = arguments?.getSerializable(HomeFragment.TASK_FOR_EDIT) as Task?
        task?.let {
            binding.btnSave.text = getString(R.string.update)
            binding.etTitle.setText(it.title)
            binding.etDesc.setText(it.description)
        }
        binding.btnSave.setOnClickListener {
            if (task != null) {
                update()
            } else save()
        }
    }

    private fun update() {
        val data = Task(id = task?.id,
            title = binding.etTitle.text.toString(),
            description = binding.etDesc.text.toString())
        App.db.taskDao().update(data)
        findNavController().navigateUp()
    }

    private fun save() {
        val data = Task(title = binding.etTitle.text.toString(),
            description = binding.etDesc.text.toString())
        App.db.taskDao().insert(data)
        findNavController().navigateUp()
    }
}