package com.agrisustain.smartcorn.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.agrisustain.smartcorn.R
import com.agrisustain.smartcorn.navigation.Screen
import com.agrisustain.smartcorn.presentation.component.SmartButton
import com.agrisustain.smartcorn.utils.AuthState
import com.agrisustain.smartcorn.utils.AuthViewModel

@Composable
fun GetStartedPage(navController: NavController, authViewModel: AuthViewModel) {
    // Kondisi jika sudah login
    val authState = authViewModel.authState.observeAsState()

    LaunchedEffect(authState.value) {
        when(authState.value) {
//            is AuthState.Unauthenticated -> navController.navigate(Screen.GetStarted.route)
            is AuthState.Authenticated -> navController.navigate(Screen.Home.route)
            else -> Unit
        }
    }

    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFE6F1E8)),
        verticalArrangement = Arrangement.Center, // posisikan secara vertikal di tengah
        horizontalAlignment = Alignment.CenterHorizontally // posisikan secara horizontal di tengah
    ) {
        Column (
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            // Menambahkan gambar
            Image(
                painter = painterResource(id = R.drawable.petani), // ganti dengan nama gambar Anda
                contentDescription = "Logo SmartCorn",
                modifier = Modifier
                    .size(300.dp) // atur ukuran gambar sesuai kebutuhan
                    .padding(bottom = 16.dp)
            )
            Text(
                text = "Selamat Datang Di",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(bottom = 10.dp)
            )
            Text(
                text = "SmartCorn",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF3E6508),
                modifier = Modifier
                    .padding(bottom = 10.dp)
            )
            Text(
                text = "\"Tingkatkan Hasil Panenmu Dengan Informasi Dari Kami\"\n",
                fontSize = 17.sp,
                textAlign = TextAlign.Center
            )
        }
        SmartButton(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 50.dp)
                .align(Alignment.CenterHorizontally),
            text = "Mulai Sekarang",
            onClick = { navController.navigate(Screen.Start.route) }
        )
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewGetStartedPage() {
    val mockNavController = rememberNavController()
    GetStartedPage(navController = mockNavController, authViewModel = AuthViewModel())
}