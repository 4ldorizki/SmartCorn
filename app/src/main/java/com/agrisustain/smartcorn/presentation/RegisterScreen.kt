package com.agrisustain.smartcorn.presentation

import com.agrisustain.smartcorn.presentation.component.BackButton
import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.remember
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.agrisustain.smartcorn.navigation.Screen
import com.agrisustain.smartcorn.viewmodel.AuthState
import com.agrisustain.smartcorn.viewmodel.AuthViewModel


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegisterScreen(
    navController: NavController,
    authViewModel: AuthViewModel = viewModel(),
) {
    var email = remember { mutableStateOf("") }
    var password = remember { mutableStateOf("") }
    var namaLengkap = remember { mutableStateOf("") }

    val authState = authViewModel.authState.observeAsState()
    val context = LocalContext.current

    LaunchedEffect(authState.value) {
        when(authState.value) {
            is AuthState.Authenticated -> navController.navigate(Screen.Home.route)
            is AuthState.Error -> Toast.makeText(context,
                (authState.value as AuthState.Error).message,Toast.LENGTH_SHORT).show()
            else -> Unit
        }
    }

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
                    // Input Nama lengkap dengan latar belakang putih
                    OutlinedTextField(
                        value = namaLengkap.value,
                        onValueChange = { namaLengkap.value = it },
                        label = { Text("Nama Lengkap*") },
                        placeholder = { Text("Masukan nama lengkap anda") },
                        modifier = Modifier
                            .background(Color.White)
                            .fillMaxWidth(),
                        singleLine = true,
                    )

                    // Input Email dengan latar belakang putih
                    OutlinedTextField(
                        value = email.value,
                        onValueChange = { email.value = it },
                        label = { Text("Email*") },
                        placeholder = { Text("Masukan email") },
                        modifier = Modifier
                            .background(Color.White)
                            .fillMaxWidth(),
                        singleLine = true,
                        )

                    // Input Kata Sandi dengan latar belakang putih

                    OutlinedTextField(
                        value = password.value,
                        onValueChange = { password.value = it },
                        label = { Text("Kata Sandi") },
                        placeholder = { Text("Masukan kata sandi") },
                        visualTransformation = PasswordVisualTransformation(),
                        modifier = Modifier
                            .background(Color.White)
                            .fillMaxWidth(),
                        singleLine = true,

                        )
//                    FormInputField(label = "Umur*", placeholder = "Umur")
//                    FormInputField(label = "Negara*", placeholder = "Negara")
//                    FormInputField(label = "Provinsi*", placeholder = "Provinsi")
//                    FormInputField(label = "Kota*", placeholder = "Kota")

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
                            onClick = {
                                authViewModel.daftar(email.value, password.value, namaLengkap.value)
                            },
                            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF47AF64)),
                            modifier = Modifier.weight(1f)
                        ) {
                            Text("Daftar")
                        }
                    }
                }
            }
        }
    )
}


//@Composable
//fun FormInputField(label: String, placeholder: String) {
//    val textState = remember { mutableStateOf(TextFieldValue("")) }
//    OutlinedTextField(
//        value = textState.value,
//        onValueChange = { textState.value = it },
//        label = { Text(label) },
//        placeholder = { Text(placeholder) },
//        modifier = Modifier
//            .fillMaxWidth()
//            .padding(vertical = 4.dp)
//    )
//}

@Preview(showBackground = true)
@Composable
private fun PreviewRegisterScreen() {
    val mockNavController = rememberNavController()
    RegisterScreen(navController = mockNavController, authViewModel = AuthViewModel())
}
