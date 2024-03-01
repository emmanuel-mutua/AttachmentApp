package com.emmutua.util.nav

sealed class AuthScreen(val route: String) {
    object Login : AuthScreen(route = "login")
    object Register : AuthScreen(route = "register")
    object StudentHome : AuthScreen(route = "student")
}
