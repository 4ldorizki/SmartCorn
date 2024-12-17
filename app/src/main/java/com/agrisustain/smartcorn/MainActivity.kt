package com.agrisustain.smartcorn

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.viewmodel.compose.viewModel
import com.agrisustain.smartcorn.presentation.SmartcornApp
import com.agrisustain.smartcorn.ui.theme.SmartCornTheme
import com.agrisustain.smartcorn.utils.AuthViewModel
import com.agrisustain.smartcorn.utils.BaseActivity

//ComponentActivity()
class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        setContent {
            SmartCornTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    SmartcornApp(authViewModel = viewModel())
                }
            }
        }
    }
}