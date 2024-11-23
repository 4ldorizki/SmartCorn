package com.agrisustain.smartcorn.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.agrisustain.smartcorn.R
import com.agrisustain.smartcorn.navigation.Screen
import com.agrisustain.smartcorn.presentation.component.BackButton
import com.agrisustain.smartcorn.presentation.component.SmartButton

@Composable
fun StartScreen (navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFE6F1E8))
            .padding(16.dp)
    ) {
        BackButton (onClick = { navController.navigateUp() }
        )
        Column (
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 30.dp)
        ) {
            // Logo di bagian atas
            Image(
                painter = painterResource(id = R.drawable.logo_smartcorn), // Ganti dengan ID gambar logo Anda
                contentDescription = "Logo SmartCorn",
                modifier = Modifier
                    .size(500.dp)
            )
            SmartButton(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 50.dp)
                    .padding(bottom = 20.dp),
//                    .align(Alignment.CenterHorizontally),
                text = "Masuk",
                onClick = { navController.navigate(Screen.Login.route) }
            )
            SmartButton(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 50.dp),
//                    .align(Alignment.CenterHorizontally),
                text = "Registrasi",
                onClick = { navController.navigate(Screen.Daftar.route) }
            )
        }
    }
}

@Preview
@Composable
fun PreviewStartScreen () {
    val mockNavController = rememberNavController()
    StartScreen(navController = mockNavController)
}