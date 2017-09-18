package com.example.marcin.loginapp.model

class LoginManager() {

    private val Users = listOf<Pair<String, String>>("marcin" to "RazDwa3")

    fun login(login: String, password: String): String{
        if(login.equals(Users[0].first)){
            if(password.equals(Users[0].second)){
                return "Successful"

            }else{
                return "Failed"
            }
        }else{
            return "Failed"
        }
    }
}