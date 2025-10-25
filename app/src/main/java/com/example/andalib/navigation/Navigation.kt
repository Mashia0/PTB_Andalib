package com.example.andalib.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.andalib.screen.LoginScreen
import com.example.andalib.screen.SignUpScreen
import com.example.andalib.screen.StartScreen

/**
 * Sealed class untuk define semua routes dalam aplikasi
 */
sealed class Screen(val route: String) {
    object Start : Screen("start")
    object Login : Screen("login")
    object SignUp : Screen("signup")
    object Home : Screen("home")

}

/**
 * Navigation graph untuk Andalib app
 */
@Composable
fun AndalibNavigation(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.Start.route
    ) {
        // Start Screen (Splash)
        composable(route = Screen.Start.route) {
            StartScreen(
                onNavigateToLogin = {
                    navController.navigate(Screen.Login.route) {
                        // Clear back stack supaya user tidak bisa kembali ke splash screen
                        popUpTo(Screen.Start.route) { inclusive = true }
                    }
                }
            )
        }

        // Login Screen
        composable(route = Screen.Login.route) {
            LoginScreen(
                onLoginClicked = {
                    // TODO: Implement login logic
                    // Setelah login berhasil, navigate ke home
                    // navController.navigate(Screen.Home.route) {
                    //     popUpTo(Screen.Login.route) { inclusive = true }
                    // }
                },
                onSignUpClicked = {
                    navController.navigate(Screen.SignUp.route)
                },
                onBackClicked = {
                    // Back dari login akan keluar dari aplikasi
                    navController.popBackStack()
                }
            )
        }

        // Sign Up Screen
        composable(route = Screen.SignUp.route) {
            SignUpScreen(
                onSignUpClicked = {
                    // TODO: Implement signup logic
                    // Setelah signup berhasil, navigate ke home atau kembali ke login
                    // navController.navigate(Screen.Home.route) {
                    //     popUpTo(Screen.Login.route) { inclusive = true }
                    // }
                },
                onLoginClicked = {
                    // Kembali ke login screen
                    navController.popBackStack(Screen.Login.route, inclusive = false)
                },
                onBackClicked = {
                    navController.popBackStack()
                }
            )
        }

        // Tambahkan composable untuk screen lain di sini
        // composable(route = Screen.Home.route) { ... }
        // composable(route = Screen.Profile.route) { ... }
    }
}

/**
 * Extension functions untuk navigasi yang lebih mudah
 */
fun NavHostController.navigateToLogin() {
    this.navigate(Screen.Login.route) {
        popUpTo(Screen.Start.route) { inclusive = true }
    }
}

fun NavHostController.navigateToSignUp() {
    this.navigate(Screen.SignUp.route)
}

fun NavHostController.navigateToHome() {
    // TODO: Implement when home screen is ready
    // this.navigate(Screen.Home.route) {
    //     popUpTo(Screen.Login.route) { inclusive = true }
    // }
}