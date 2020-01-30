package com.heb.dnote.login

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

import com.heb.dnote.R

class ServerFragment : Fragment() {

    companion object {
        fun newInstance() = ServerFragment()
    }

    private lateinit var viewModel: ServerViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_server, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(ServerViewModel::class.java)

        val nextButton = view?.findViewById<Button>(R.id.next_button)
        nextButton?.setOnClickListener {
            activity?.let {
                val loginViewModel =ViewModelProviders.of(it).get(LoginViewModel::class.java)
                loginViewModel.serverSetup.value = true
            }
        }
    }
}
