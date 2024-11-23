package com.agrisustain.smartcorn.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
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
import com.agrisustain.smartcorn.presentation.component.SmartButton

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DeteksiPenyakitScreen (
    navController: NavController
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        "SmartCorn",
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Medium,
                        color = Color.White
                    )
                },
                actions = {
                    IconButton(onClick = { /* Profile action */ }) {
                        Box(
                            modifier = Modifier
                                .size(50.dp)
                                .background(Color.Gray, shape = CircleShape)
                        ) {
                            // Placeholder for profile icon
                        }
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Color(0xFF47AF64))
            )
        },
        bottomBar = {
            BottomBar(navController)
        },
        modifier = Modifier
    ) { contentPadding ->
        Column (
            modifier = Modifier
                .fillMaxSize()
                .padding(contentPadding),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.upload_img),
                contentDescription = "Upload Image",
                modifier = Modifier.size(200.dp)
            )
            Text(
                text = "Unggah foto tanaman Anda untuk mengidentifikasi penyakit dan segera menerima solusi yang disesuaikan.",
                textAlign = TextAlign.Left,
                fontSize = 18.sp,
                fontWeight = FontWeight.Medium,
                modifier = Modifier
                    .padding(horizontal = 16.dp)
            )

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .shadow(
                        elevation = 8.dp, // Ukuran bayangan
                        shape = RoundedCornerShape(16.dp), // Bentuk bayangan
                        clip = false // Jika true, bayangan akan mengikuti bentuk klip
                    )
                    .clip(RoundedCornerShape(16.dp))
                    .background(color = Color(0xFFE4FFEC))
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.scan_icon),
                        contentDescription = "Scan",
                        modifier = Modifier.size(64.dp)
                    )
                    Icon(
                        imageVector = Icons.Default.ArrowForward,
                        contentDescription = null,
                        tint = Color.Black
                    )

                    Image(
                        painter = painterResource(id = R.drawable.hasil_icon),
                        contentDescription = "Hasil",
                        modifier = Modifier.size(64.dp)
                    )
                    Icon(
                        imageVector = Icons.Default.ArrowForward,
                        contentDescription = null,
                        tint = Color.Black
                    )

                    Image(
                        painter = painterResource(id = R.drawable.solusi_icon),
                        contentDescription = "Solusi",
                        modifier = Modifier.size(64.dp)
                    )
                }
                Spacer(modifier = Modifier.height(16.dp))
                Row(
                    modifier = Modifier.fillMaxWidth().padding(horizontal = 6.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(text = "Scan", fontSize = 18.sp, fontWeight = FontWeight.Medium)
                    Text(text = "Hasil", fontSize = 18.sp, fontWeight = FontWeight.Medium)
                    Text(text = "Solusi", fontSize = 18.sp, fontWeight = FontWeight.Medium)
                }
                Spacer(modifier = Modifier.height(16.dp))

                SmartButton(
                    text = "Unggah Gambar",
                    onClick = { }
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            Column (
                modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp),
                horizontalAlignment = Alignment.Start
            ) {
                Text(
                    text = "Riwayat Deteksi Penyakit", fontSize = 16.sp, fontWeight = FontWeight.SemiBold
                )
                Column (
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.fillMaxSize()
                ){
                    Text("Riwayat Kosong")
                }
            }
        }
    }
}

@Preview
@Composable
fun PreviewDeteksiPenyakitScreen () {
    DeteksiPenyakitScreen(navController = rememberNavController())
}