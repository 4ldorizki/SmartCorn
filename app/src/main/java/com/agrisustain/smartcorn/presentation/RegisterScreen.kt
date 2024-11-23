package com.agrisustain.smartcorn.presentation

import com.agrisustain.smartcorn.presentation.component.BackButton
import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.agrisustain.smartcorn.viewmodel.AuthViewModel


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegisterScreen(
    navController: NavController,
    authViewModel: AuthViewModel,
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {

                },
                navigationIcon = {
                    BackButton(
                        onClick = { navController.navigateUp() }
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Color(0xFFE6F4EA)),

            )
        },
        content = { paddingValues ->
            Column(
                verticalArrangement = Arrangement.Bottom,
                modifier = Modifier
                    .padding(paddingValues)
                    .fillMaxSize()
                    .background(Color(0xFFE6F4EA)) // Background color
            ) {

                // Title
                Text(
                    text = "Masukkan Data Diri",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                )
                Spacer(modifier = Modifier.height(55.dp))

                Column(
                    verticalArrangement = Arrangement.Bottom,
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.White, shape = RoundedCornerShape(topEnd = 16.dp, topStart = 16.dp))
                        .padding(16.dp)
                ) {
                    // Input fields
                    FormInputField(label = "Nama Pengguna*", placeholder = "Nama Pengguna")

                    // Input Email dengan latar belakang putih
                    val emailState = remember { mutableStateOf(TextFieldValue("")) }
                    OutlinedTextField(
                        value = emailState.value,
                        onValueChange = { emailState.value = it },
                        label = { Text("Email*") },
                        placeholder = { Text("Masukan email") },
                        modifier = Modifier
                            .background(Color.White)
                            .fillMaxWidth(),
                        singleLine = true,
                        )

                    // Input Kata Sandi dengan latar belakang putih
                    val passwordState = remember { mutableStateOf(TextFieldValue("")) }
                    OutlinedTextField(
                        value = passwordState.value,
                        onValueChange = { passwordState.value = it },
                        label = { Text("Kata Sandi") },
                        placeholder = { Text("Masukan kata sandi") },
                        visualTransformation = PasswordVisualTransformation(),
                        modifier = Modifier
                            .background(Color.White)
                            .fillMaxWidth(),
                        singleLine = true,

                        )
                    FormInputField(label = "Umur*", placeholder = "Umur")
                    FormInputField(label = "Negara*", placeholder = "Negara")
                    FormInputField(label = "Provinsi*", placeholder = "Provinsi")
                    FormInputField(label = "Kota*", placeholder = "Kota")

                    // Terms and conditions
                    Text(
                        text = "Dengan membuat akun atau mendaftar, Anda setuju dengan Syarat & Ketentuan dan Pernyataan Privasi kami",
                        fontSize = 12.sp,
                        color = Color.Gray,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(vertical = 16.dp)
                    )

                    // Buttons
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Button(
                            onClick = { /* Handle cancel action */ },
                            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFF6C6C)),
                            modifier = Modifier.weight(1f)
                        ) {
                            Text("Batalkan")
                        }
                        Spacer(modifier = Modifier.width(8.dp))
                        Button(
                            onClick = { navController.navigate("verifikasi_screen") },
                            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF47AF64)),
                            modifier = Modifier.weight(1f)
                        ) {
                            Text("Selanjutnya")
                        }
                    }
                }
            }
        }
    )
}


@Composable
fun FormInputField(label: String, placeholder: String) {
    val textState = remember { mutableStateOf(TextFieldValue("")) }
    OutlinedTextField(
        value = textState.value,
        onValueChange = { textState.value = it },
        label = { Text(label) },
        placeholder = { Text(placeholder) },
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
    )
}

@Preview(showBackground = true)
@Composable
private fun PreviewRegisterScreen() {
    val mockNavController = rememberNavController()
    RegisterScreen(navController = mockNavController, authViewModel = AuthViewModel())
}
