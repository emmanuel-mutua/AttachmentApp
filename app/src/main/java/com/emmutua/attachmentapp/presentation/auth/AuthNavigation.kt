package com.emmutua.attachmentapp.presentation.auth

import android.app.Activity
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.emmutua.attachmentapp.presentation.student.home.StudentHomeScreen
import com.stevdzasan.messagebar.rememberMessageBarState

@Composable
fun AuthNavGraph(
    startDestination: String,
    navController: NavHostController,
    authViewModel: AuthViewModel,
    registerState: AuthStateData,
    activity: Activity,
) {
    NavHost(navController = navController, startDestination = startDestination) {
        loginScreen(
            registerState = registerState,
            viewModel = authViewModel,
            navigateToRegister = {
                navController.navigateWithPop(AuthScreen.Register.route)
            },
            navigateToHome = {
                navController.navigate(AuthScreen.StudentHome.route) {
                    navController.popBackStack()
                }
            },
        )
        registerScreen(viewModel = authViewModel, navigateToLogin = {
            navController.navigateWithPop(AuthScreen.Login.route)
        })
        studentHomeScreen(
            navigateToLogin = {
                activity.finish()

//                navController.popBackStack()
//                navController.navigate(AuthScreen.Login.route)
            },
        )
    }
}

fun NavGraphBuilder.loginScreen(
    registerState: AuthStateData,
    viewModel: AuthViewModel,
    navigateToRegister: () -> Unit,
    navigateToHome: () -> Unit,
) {
    composable(AuthScreen.Login.route) {
        LoginScreen(
            registerState = registerState,
            viewModel = viewModel,
            navigateToRegister = navigateToRegister,
            navigateToHome = navigateToHome,
        )
    }
}

fun NavGraphBuilder.registerScreen(
    viewModel: AuthViewModel,
    navigateToLogin: () -> Unit,
) {
    composable(AuthScreen.Register.route) {
        val messageBarState = rememberMessageBarState()
        RegisterScreen(
            viewModel = viewModel,
            messageBarState = messageBarState,
            onSuccessRegistration = {
                viewModel.sendEmailVerification()
                navigateToLogin()
            },
            onGotoLoginClicked = {
                navigateToLogin()
            },
        )
    }
}



fun NavGraphBuilder.studentHomeScreen(navigateToLogin: () -> Unit) {
    composable(AuthScreen.StudentHome.route) {
        StudentHomeScreen(
            navigateToLogin = navigateToLogin,
        )
    }
}


fun NavController.navigateWithPop(route: String) {
    navigate(route) {
        // Pop up to the start destination of the graph to
        // avoid building up a large stack of destinations
        // on the back stack as users select items
        popUpTo(graph.findStartDestination().id) {
            saveState = true
        }
        launchSingleTop = true
        restoreState = true
    }
}
