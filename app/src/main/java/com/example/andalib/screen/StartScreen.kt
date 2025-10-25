package com.example.andalib.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.andalib.R
import com.example.andalib.ui.theme.AndalibTheme
import com.example.andalib.ui.theme.AndalibWhite
import kotlinx.coroutines.delay

@Composable
fun StartScreen(
    onNavigateToLogin: () -> Unit = {}
) {
    // Auto navigate setelah 2 detik
    LaunchedEffect(Unit) {
        delay(2000)
        onNavigateToLogin()
    }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = AndalibWhite
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            // Placeholder untuk logo - ganti dengan logo asli
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                // Icon buku dengan tulisan ANDALIB
                // Karena tidak ada resource logo, kita buat placeholder
                androidx.compose.material3.Text(
                    text = "📖",
                    style = MaterialTheme.typography.displayLarge
                )
                Spacer(modifier = Modifier.height(8.dp))
                androidx.compose.material3.Text(
                    text = "ANDALIB",
                    style = MaterialTheme.typography.headlineMedium,
                    color = com.example.andalib.ui.theme.AndalibDarkBlue
                )
            }
        }
    }
}

@Preview(showBackground = true, device = "id:pixel_6")
@Composable
fun StartScreenPreview() {
    AndalibTheme {
        StartScreen()
    }
}