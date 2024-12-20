package com.example.resikel

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.resikel.auth.AuthViewModel
import com.example.resikel.chatbot.ChatViewModel

import com.example.resikel.navigation.resikelNavigation
import com.example.resikel.report.ReportScreen
import com.example.resikel.ui.theme.ResikelTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val authViewModel : AuthViewModel by viewModels()
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ResikelTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val chatViewModel: ChatViewModel = viewModel()
                    resikelNavigation(authViewModel = authViewModel,chatViewModel)
                }
            }
        }
    }
}

