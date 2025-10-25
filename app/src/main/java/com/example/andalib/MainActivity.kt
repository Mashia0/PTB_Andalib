package com.example.andalib

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.andalib.ui.theme.AndalibTheme
import com.example.andalib.ui.screens.LoginScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AndalibTheme {
                // Ganti Scaffold/Greeting dengan LoginScreen
                LoginScreen(
                    onLoginClicked = {
                        // Logika untuk handle klik login
                    },
                    onSignUpClicked = {
                        // Logika untuk pindah ke halaman sign up
                    },
                    onBackClicked = {
                        // Logika untuk tombol kembali
                    }
                )
            }
        }
    }
}