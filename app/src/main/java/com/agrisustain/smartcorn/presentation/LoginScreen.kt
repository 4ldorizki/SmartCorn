package com.agrisustain.smartcorn.presentation

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.agrisustain.smartcorn.R
import com.agrisustain.smartcorn.navigation.Screen
import com.agrisustain.smartcorn.utils.AuthState
import com.agrisustain.smartcorn.utils.AuthViewModel

@Composable
fun LoginScreen(navController: NavController, authViewModel: AuthViewModel) {

    var email = remember { mutableStateOf("") }
    var password = remember { mutableStateOf("") }

    val authState = authViewModel.authState.observeAsState()
    val context = LocalContext.current

    LaunchedEffect(authState.value) {
        when(authState.value) {
            is AuthState.Authenticated -> navController.navigate(Screen.Home.route)
            is AuthState.Error -> Toast.makeText(context,
                (authState.value as AuthState.Error).message, Toast.LENGTH_SHORT).show()
            else -> Unit
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF47AF64))
    ) {
        Row (
            modifier = Modifier
                .padding(bottom = 16.dp)
        )
        {
            Image(
                painter = painterResource(id = R.drawable.login2), // Pastikan gambar ada di drawable
                contentDescription = "Login",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .clip(RoundedCornerShape(bottomStart = 150.dp)), // Rounded corner di sudut kiri bawah
                contentScale = ContentScale.Crop
            )
        }
        // Konten login
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
//                        .fillMaxHeight()
        ) {
            // Teks Selamat Datang
            Text(
                text = "Selamat Datang!",
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
            Text(
                text = "Silahkan masukan akun Anda",
                fontSize = 16.sp,
                color = Color.White
            )

            Spacer(modifier = Modifier.height(24.dp))

            // Input Email dengan latar belakang putih
            OutlinedTextField(
                value = email.value,
                onValueChange = { email.value = it },
                label = { Text("Email") },
                placeholder = { Text("Masukan email") },
                modifier = Modifier
                    .background(Color.White),
                singleLine = true,

            )

            Spacer(modifier = Modifier.height(8.dp))

            // Input Kata Sandi dengan latar belakang putih
            OutlinedTextField(
                value = password.value,
                onValueChange = { password.value = it },
                label = { Text("Kata Sandi") },
                placeholder = { Text("Masukan kata sandi") },
                visualTransformation = PasswordVisualTransformation(),
                modifier = Modifier
                    .background(Color.White, shape = RoundedCornerShape(8.dp)),
                singleLine = true,

            )

            Spacer(modifier = Modifier.height(8.dp))

            // Checkbox Remember me
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .align(alignment = Alignment.Start)
                    .padding(start = 46.dp)

            ) {
                val rememberMeState = remember { mutableStateOf(false) }
                Checkbox(
                    checked = rememberMeState.value,
                    onCheckedChange = { rememberMeState.value = it },
                    colors = CheckboxDefaults.colors(
                        checkedColor = Color.White,
                        uncheckedColor = Color.White
                    )
                )
                Text(text = "Remember me", color = Color.White)
            }

        }
        Spacer(modifier = Modifier.height(24.dp))

        Column (
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
        ){
            Spacer(modifier = Modifier.height(16.dp))

            // Tombol Masuk
            Button(
                onClick = {
                    authViewModel.login(email.value, password.value)
                },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFFC107)),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(40.dp)
                    .padding(horizontal = 50.dp)
                    .shadow(
                        elevation = 8.dp,
                        clip = false
                    ),
                shape = RoundedCornerShape(8.dp)
            ) {
                Text("Masuk", fontSize = 16.sp, fontWeight = FontWeight.Bold, color = Color.Black)
            }

            Spacer(modifier = Modifier.height(24.dp))

            Row {
                // Teks Register
                Text(
                    text = "Jika belum punya akun? ",
                    color = Color.White,
                    fontSize = 14.sp,
                )

                Text(
                    text = "Register",
                    color = Color.White,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .clickable { navController.navigate(Screen.Daftar.route) }
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewLoginScreen() {
    val mockNavController = rememberNavController()
    LoginScreen(navController = mockNavController, authViewModel = AuthViewModel())
}