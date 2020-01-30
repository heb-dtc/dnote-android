package com.heb.dnote.login.signin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.heb.dnote.R
import com.heb.dnote.login.LoginViewModel

class SignInFragment : Fragment() {

    companion object {
        @JvmStatic
        fun newInstance() = SignInFragment()
    }

    private val viewModel: SignInViewModel by lazy {
        ViewModelProvider(this, SignInViewModelFactory())
            .get(SignInViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_sign_in, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val nextButton = view?.findViewById<Button>(R.id.login)
        nextButton?.setOnClickListener {
            activity?.let {
                val loginViewModel = ViewModelProviders.of(it).get(LoginViewModel::class.java)
                loginViewModel.userLogged.value = true
            }
        }
    }
}
