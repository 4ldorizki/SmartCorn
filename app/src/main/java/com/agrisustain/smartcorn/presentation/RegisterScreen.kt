package com.agrisustain.smartcorn.presentation

import com.agrisustain.smartcorn.presentation.component.BackButton
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.agrisustain.smartcorn.R
import com.agrisustain.smartcorn.navigation.Screen
import com.agrisustain.smartcorn.utils.AuthViewModel
import com.agrisustain.smartcorn.data.api.RegisterRequest

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegisterScreen(
    navController: NavController,
    authViewModel: AuthViewModel = viewModel(),
) {
    val context = LocalContext.current

    // State untuk input
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var firstName by remember { mutableStateOf("") }
    var lastName by remember { mutableStateOf("") }
    var city by remember { mutableStateOf("") }
    var province by remember { mutableStateOf("") }
    var country by remember { mutableStateOf("") }
    var age by remember { mutableStateOf("") }
    var isLoading by remember { mutableStateOf(false) }

    // Observasi state dari ViewModel
    val registerState by authViewModel.registerState.collectAsState()

    // Efek yang diluncurkan saat state register berubah
    LaunchedEffect(registerState) {
        registerState?.let { state ->
            isLoading = false
            if (state.success) {
                Toast.makeText(context, "Pendaftaran berhasil!", Toast.LENGTH_SHORT).show()
                navController.navigate(Screen.Home.route) // Navigasi ke layar Home
            } else {
                Toast.makeText(context, state.message, Toast.LENGTH_SHORT).show()
            }
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Pendaftaran") },
                navigationIcon = {
                    BackButton(
                        onClick = { navController.navigateUp() }
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Color(0xFFE6F4EA))
            )
        },
        content = { paddingValues ->
            Column(
                modifier = Modifier
                    .padding(paddingValues)
                    .fillMaxSize()
                    .background(Color(0xFFE6F4EA))
            ) {
                Text(
                    text = "Masukkan Data Diri",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .padding(top = 16.dp)
                )

                Spacer(modifier = Modifier.height(16.dp))

                Column(
                    verticalArrangement = Arrangement.spacedBy(16.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.White, shape = RoundedCornerShape(topEnd = 16.dp, topStart = 16.dp))
                        .padding(16.dp)
                ) {
                    // Input Data
                    OutlinedTextField(
                        value = firstName,
                        onValueChange = { firstName = it },
                        label = { Text("Nama Depan*") },
                        modifier = Modifier.fillMaxWidth()
                    )
                    OutlinedTextField(
                        value = lastName,
                        onValueChange = { lastName = it },
                        label = { Text("Nama Belakang*") },
                        modifier = Modifier.fillMaxWidth()
                    )
                    OutlinedTextField(
                        value = country,
                        onValueChange = { country = it },
                        label = { Text("Negara*") },
                        modifier = Modifier.fillMaxWidth()
                    )
                    OutlinedTextField(
                        value = province,
                        onValueChange = { province = it },
                        label = { Text("Provinsi*") },
                        modifier = Modifier.fillMaxWidth()
                    )
                    OutlinedTextField(
                        value = city,
                        onValueChange = { city = it },
                        label = { Text("Kota*") },
                        modifier = Modifier.fillMaxWidth()
                    )
                    OutlinedTextField(
                        value = age,
                        onValueChange = { age = it },
                        label = { Text("Umur*") },
                        modifier = Modifier.fillMaxWidth(),
                        singleLine = true,
                        isError = age.toIntOrNull()?.let { it <= 0 } == true // Validasi umur
                    )
                    OutlinedTextField(
                        value = email,
                        onValueChange = { email = it },
                        label = { Text("Email*") },
                        modifier = Modifier.fillMaxWidth(),
                        isError = !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches() && email.isNotEmpty() // Validasi email
                    )
                    OutlinedTextField(
                        value = password,
                        onValueChange = { password = it },
                        label = { Text("Kata Sandi*") },
                        visualTransformation = PasswordVisualTransformation(),
                        modifier = Modifier.fillMaxWidth()
                    )

                    // Tombol Daftar
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Button(
                            onClick = { navController.navigateUp() },
                            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFF6C6C)),
                            modifier = Modifier.weight(1f)
                        ) {
                            Text("Batalkan")
                        }
                        Spacer(modifier = Modifier.width(8.dp))
                        Button(
                            onClick = {
                                if (firstName.isNotEmpty() && lastName.isNotEmpty() && email.isNotEmpty() && password.isNotEmpty() && city.isNotEmpty() && province.isNotEmpty() && country.isNotEmpty() && age.toIntOrNull() != null) {
                                    isLoading = true
                                    val request = RegisterRequest(
                                        firstName = firstName,
                                        lastName = lastName,
                                        email = email,
                                        password = password,
                                        city = city,
                                        province = province,
                                        country = country,
                                        age = age.toInt()
                                    )
                                    authViewModel.register(request)
                                } else {
                                    Toast.makeText(context, "Mohon lengkapi semua data wajib!", Toast.LENGTH_SHORT).show()
                                }
                            },
                            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF47AF64)),
                            modifier = Modifier.weight(1f),
                            enabled = !isLoading
                        ) {
                            if (isLoading) {
                                CircularProgressIndicator(color = Color.White, modifier = Modifier.size(20.dp))
                            } else {
                                Text("Daftar")
                            }
                        }
                    }
                }
            }
        }
    )
}



//@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun RegisterScreen(
//    navController: NavController,
//    authViewModel: AuthViewModel = viewModel(),
//) {
//    var email = remember { mutableStateOf("") }
//    var password = remember { mutableStateOf("") }
//    var namaDepan = remember { mutableStateOf("") }
//    var namaBelakang = remember { mutableStateOf("") }
//    var kota = remember { mutableStateOf("") }
//    var provinsi = remember { mutableStateOf("") }
//    var negara = remember { mutableStateOf("") }
//    var umur = remember { mutableStateOf("") }
//
//    val authState = authViewModel.authState.observeAsState()
//    val context = LocalContext.current
//
//    LaunchedEffect(authState.value) {
//        when(authState.value) {
//            is AuthState.Authenticated -> navController.navigate(Screen.Home.route)
//            is AuthState.Error -> Toast.makeText(context,
//                (authState.value as AuthState.Error).message,Toast.LENGTH_SHORT).show()
//            else -> Unit
//        }
//    }
//
//    Scaffold(
//        topBar = {
//            TopAppBar(
//                title = {
//
//                },
//                navigationIcon = {
//                    BackButton(
//                        onClick = { navController.navigateUp() }
//                    )
//                },
//                colors = TopAppBarDefaults.topAppBarColors(containerColor = Color(0xFFE6F4EA)),
//
//            )
//        },
//        content = { paddingValues ->
//            Column(
//                verticalArrangement = Arrangement.Bottom,
//                modifier = Modifier
//                    .padding(paddingValues)
//                    .fillMaxSize()
//                    .background(Color(0xFFE6F4EA)) // Background color
//            ) {
//
//                // Title
//                Text(
//                    text = "Masukkan Data Diri",
//                    fontSize = 24.sp,
//                    fontWeight = FontWeight.Bold,
//                    modifier = Modifier
//                        .align(Alignment.CenterHorizontally)
//                )
//                Spacer(modifier = Modifier.height(55.dp))
//
//                Column(
//                    verticalArrangement = Arrangement.Bottom,
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .background(Color.White, shape = RoundedCornerShape(topEnd = 16.dp, topStart = 16.dp))
//                        .padding(16.dp)
//                ) {
//                    // Input Nama lengkap dengan latar belakang putih
//                    OutlinedTextField(
//                        value = namaDepan.value,
//                        onValueChange = { namaDepan.value = it },
//                        label = { Text("Nama Depan*") },
//                        placeholder = { Text("Masukan nama depan anda") },
//                        modifier = Modifier
//                            .background(Color.White)
//                            .fillMaxWidth(),
//                        singleLine = true,
//                    )
//
//                    // Input Nama belakang dengan latar belakang putih
//                    OutlinedTextField(
//                        value = namaBelakang.value,
//                        onValueChange = { namaBelakang.value = it },
//                        label = { Text("Nama Belakang*") },
//                        placeholder = { Text("Masukan nama belakang anda") },
//                        modifier = Modifier
//                            .background(Color.White)
//                            .fillMaxWidth(),
//                        singleLine = true,
//                    )
//
//                    // Input negara
//                    OutlinedTextField(
//                        value = negara.value,
//                        onValueChange = { negara.value = it },
//                        label = { Text("Negara*") },
//                        placeholder = { Text("Masukan negara anda") },
//                        modifier = Modifier
//                            .background(Color.White)
//                            .fillMaxWidth(),
//                        singleLine = true,
//                    )
//
//                    // Input provinsi
//                    OutlinedTextField(
//                        value = provinsi.value,
//                        onValueChange = { provinsi.value = it },
//                        label = { Text("Provinsi*") },
//                        placeholder = { Text("Masukan provinsi anda") },
//                        modifier = Modifier
//                            .background(Color.White)
//                            .fillMaxWidth(),
//                        singleLine = true,
//                    )
//
//                    // Input kota
//                    OutlinedTextField(
//                        value = kota.value,
//                        onValueChange = { kota.value = it },
//                        label = { Text("Kota*") },
//                        placeholder = { Text("Masukan provinsi anda") },
//                        modifier = Modifier
//                            .background(Color.White)
//                            .fillMaxWidth(),
//                        singleLine = true,
//                    )
//
//                    // Input umur
//                    OutlinedTextField(
//                        value = umur.value,
//                        onValueChange = { umur.value = it },
//                        label = { Text("Umur*") },
//                        placeholder = { Text("Masukan umur anda") },
//                        modifier = Modifier
//                            .background(Color.White)
//                            .fillMaxWidth(),
//                        singleLine = true,
//                    )
//
//                    // Input Email dengan latar belakang putih
//                    OutlinedTextField(
//                        value = email.value,
//                        onValueChange = { email.value = it },
//                        label = { Text("Email*") },
//                        placeholder = { Text("Masukan email") },
//                        modifier = Modifier
//                            .background(Color.White)
//                            .fillMaxWidth(),
//                        singleLine = true,
//                        )
//
//                    // Input Kata Sandi dengan latar belakang putih
//                    OutlinedTextField(
//                        value = password.value,
//                        onValueChange = { password.value = it },
//                        label = { Text("Kata Sandi") },
//                        placeholder = { Text("Masukan kata sandi") },
//                        visualTransformation = PasswordVisualTransformation(),
//                        modifier = Modifier
//                            .background(Color.White)
//                            .fillMaxWidth(),
//                        singleLine = true,
//
//                        )
//                    FormInputField(label = "Umur*", placeholder = "Umur")
//                    FormInputField(label = "Negara*", placeholder = "Negara")
//                    FormInputField(label = "Provinsi*", placeholder = "Provinsi")
//                    FormInputField(label = "Kota*", placeholder = "Kota")
//
//                    // Terms and conditions
//                    Text(
//                        text = "Dengan membuat akun atau mendaftar, Anda setuju dengan Syarat & Ketentuan dan Pernyataan Privasi kami",
//                        fontSize = 12.sp,
//                        color = Color.Gray,
//                        textAlign = TextAlign.Center,
//                        modifier = Modifier.padding(vertical = 16.dp)
//                    )
//
//                    // Buttons
//                    Row(
//                        modifier = Modifier.fillMaxWidth(),
//                        horizontalArrangement = Arrangement.SpaceBetween
//                    ) {
//                        Button(
//                            onClick = { /* Handle cancel action */ },
//                            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFF6C6C)),
//                            modifier = Modifier.weight(1f)
//                        ) {
//                            Text("Batalkan")
//                        }
//                        Spacer(modifier = Modifier.width(8.dp))
//                        Button(
//                            onClick = {
//                                authViewModel.register(email.value, password.value, firstName.value)
//                            },
//                            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF47AF64)),
//                            modifier = Modifier.weight(1f)
//                        ) {
//                            Text("Daftar")
//                        }
//                    }
//                }
//            }
//        }
//    )
//}


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
    RegisterScreen(navController = mockNavController, authViewModel = viewModel())
}
