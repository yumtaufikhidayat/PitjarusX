package com.yumtaufikhidayat.pitjarusx.ui.login

import android.os.Bundle
import android.text.Editable
import android.text.InputType
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.yumtaufikhidayat.pitjarusx.data.NetworkResult
import com.yumtaufikhidayat.pitjarusx.databinding.FragmentLoginBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    private val loginViewModel : LoginViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setLogin()
    }

    private fun setLogin() {
        binding.apply {
            btnLogin.setOnClickListener {
                val username = etUsername.text.toString().trim()
                val password = etPassword.text.toString().trim()

                loginViewModel.apply {
                    loginRemote(username, password).observe(viewLifecycleOwner) {
                        if (it != null) {
                            when (it) {
                                is NetworkResult.Loading -> showLoading(true)
                                is NetworkResult.Success -> {
                                    showLoading(false)
                                    // save data to local after successfully login
//                                    loginLocal(username, password)
                                    showToast(it.data.message)
                                }

                                is NetworkResult.Error -> {
                                    showLoading(false)
                                    showToast(it.error)
                                }

                                is NetworkResult.Unauthorized, is NetworkResult.ServerError -> showToast(
                                    it.toString()
                                )
                            }
                        }
                    }
                }
            }

            etUsername.addTextChangedListener(textWatcher())
            etPassword.addTextChangedListener(textWatcher())

            cbShowPassword.setOnCheckedChangeListener { _, isChecked ->
                etPassword.inputType = if (isChecked) {
                    InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD
                } else {
                    InputType.TYPE_TEXT_VARIATION_PASSWORD or InputType.TYPE_CLASS_TEXT
                }
            }
        }
    }

    private fun textWatcher(): TextWatcher = object : TextWatcher {
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            enabledButton()
        }

        override fun afterTextChanged(s: Editable?) {}
    }

    private fun enabledButton() {
        binding.apply {
            val username = etUsername.text.toString().trim()
            val password = etPassword.text.toString().trim()
            btnLogin.isEnabled = username.isNotEmpty() && password.isNotEmpty()
        }
    }

    private fun showLoading(isShow: Boolean) {
        binding.progressLogin.isVisible = isShow
    }

    private fun showToast(text: String) {
        Toast.makeText(requireContext(), text, Toast.LENGTH_LONG).show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}