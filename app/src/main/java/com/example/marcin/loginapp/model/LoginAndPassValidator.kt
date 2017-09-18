package com.example.marcin.loginapp.model

class LoginAndPassValidator() {
    private var isLoginOK : Boolean = false
    private var isPasswordOK: Boolean = false

    fun validatePassword(text: String){
        if(text.length >= 6){
            if(text.containsAnyNumberAndUpperLetter()){
                isPasswordOK = true
            }
        }
    }

    fun validateLogin(text: String){
        if(text.length >= 3){
            if(text.noContainsWhiteSpacesOrDigits()){
                isLoginOK = true
            }
        }
    }

    fun isPasswordAndLoginOk() : Boolean = isLoginOK && isPasswordOK

    private fun String.containsAnyNumberAndUpperLetter(): Boolean{
        return any({
            it.isDigit() or(it.isUpperCase())
        })
    }

    private fun String.noContainsWhiteSpacesOrDigits(): Boolean {
        return none {
            it.isWhitespace() or(it.isDigit())
        }
    }
}