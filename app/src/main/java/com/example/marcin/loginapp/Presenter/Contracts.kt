package com.example.marcin.loginapp.Presenter

interface Contracts {

    interface MainLayout {
        fun lockSubmitButton()
        fun unlockSubmitButton()
        fun showToast(message: String)
        fun showProgressBar()
        fun hideProgressBar()
    }

    interface LoginPresenter {
        fun onViewCreated()
        fun onLoginChanged(input: String)
        fun onPasswordChanged(input: String)
        fun onSubmitButtonClick(login: String, password: String)
    }
}