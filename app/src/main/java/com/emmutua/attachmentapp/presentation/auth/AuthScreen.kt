package com.emmutua.attachmentapp.presentation.auth

sealed class AuthScreen(val route: String) {
    object Login : AuthScreen(route = "login")
    object Register : AuthScreen(route = "register")
    object StudentHome : AuthScreen(route = "student")
}
