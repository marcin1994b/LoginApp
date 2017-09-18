package com.example.marcin.loginapp.Presenter

import com.example.marcin.loginapp.model.LoginAndPassValidator
import com.example.marcin.loginapp.model.LoginManager


class LoginPresenter(val view: Contracts.MainLayout) : Contracts.LoginPresenter{

    private val loginProvider = LoginAndPassValidator()
    private val loginManager = LoginManager()

    override fun onViewCreated() {
        view.lockSubmitButton()
    }

    override fun onPasswordChanged(input: String) {
        view.lockSubmitButton()
        loginProvider.validatePassword(input.trim())
        if(loginProvider.isPasswordAndLoginOk()){
            view.unlockSubmitButton()
        }
    }

    override fun onLoginChanged(input: String) {
        view.lockSubmitButton()
        loginProvider.validateLogin(input.trim())
        if(loginProvider.isPasswordAndLoginOk()){
            view.unlockSubmitButton()
        }
    }

    override fun onSubmitButtonClick(login: String, password: String) {
        view.showToast(loginManager.login(login, password))
    }
}

