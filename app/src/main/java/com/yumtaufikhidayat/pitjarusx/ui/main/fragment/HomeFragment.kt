package com.yumtaufikhidayat.pitjarusx.ui.main.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.yumtaufikhidayat.pitjarusx.databinding.FragmentHomeBinding
import com.yumtaufikhidayat.pitjarusx.ui.main.adapter.MenuAdapter
import com.yumtaufikhidayat.pitjarusx.ui.main.viewmodel.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private val homeViewModel: HomeViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        showMenu()
    }

    private fun showMenu() {
        val menuAdapter = MenuAdapter {
            when (it) {
                0 -> Toast.makeText(requireContext(), "tes posisi $it", Toast.LENGTH_SHORT).show()
            }
        }

        binding.rvMenu.apply {
            layoutManager = GridLayoutManager(requireContext(), 4)
            adapter = menuAdapter
        }

        homeViewModel.apply {
            insertMenu(requireContext())
            getMenu().observe(viewLifecycleOwner) {
                menuAdapter.submitList(it)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}