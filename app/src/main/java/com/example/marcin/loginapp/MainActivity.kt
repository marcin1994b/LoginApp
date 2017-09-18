package com.example.marcin.loginapp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.example.marcin.loginapp.Presenter.Contracts
import com.example.marcin.loginapp.Presenter.LoginPresenter
import com.example.marcin.loginapp.model.TextWatcherAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), Contracts.MainLayout {

    private val loginPresenter : Contracts.LoginPresenter = LoginPresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loginPresenter.onViewCreated()

        initEditTexts()
    }

    override fun unlockSubmitButton() {
        submitButton.isEnabled = true
    }

    override fun lockSubmitButton() {
        submitButton.isEnabled = false
    }

    override fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun showProgressBar() {

    }

    override fun hideProgressBar() {

    }

    private fun initEditTexts(){
        initLoginEditText()
        initPasswordEditText()
        initSubmitButton()
    }

    private fun initSubmitButton(){
        submitButton.setOnClickListener {
            loginPresenter.onSubmitButtonClick(loginEditText.text.toString(),
                    passwordEditText.text.toString())
        }
    }

    private fun initLoginEditText(){
        loginEditText.addTextChangedListener(object: TextWatcherAdapter() {
            override fun onTextChanged(input: CharSequence?, p1: Int, p2: Int, p3: Int) {
                loginPresenter.onLoginChanged(input.toString())
            }
        })
    }

    private fun initPasswordEditText(){
        passwordEditText.addTextChangedListener(object: TextWatcherAdapter() {
            override fun onTextChanged(input: CharSequence?, p1: Int, p2: Int, p3: Int) {
                loginPresenter.onPasswordChanged(input.toString())
            }
        })
    }

}


