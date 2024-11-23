package com.agrisustain.smartcorn.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.agrisustain.smartcorn.data.SmartcornData
import com.agrisustain.smartcorn.model.Edukasi

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailEdukasiScreen (
    navController: NavController,
    modifier: Modifier = Modifier,
    edukasiId :Int?,
) {
    val newEdukasi = SmartcornData.edukasi.filter { edukasi ->
        edukasi.id == edukasiId
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Edukasi Pertanian Jagung",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Medium,
                        color = Color.White,
                        modifier = Modifier.offset(x = 16.dp)
                    )
                },
                navigationIcon = {
                    Box(
                        modifier = Modifier
                            .size(40.dp)
                            .shadow(
                                elevation = 4.dp,
                                shape = RoundedCornerShape(12.dp),
                                clip = true
                            )
                            .background(Color.White),
                        contentAlignment = Alignment.Center
                    ) {
                        IconButton(onClick = { navController.navigateUp() }) {
                            Icon(
                                imageVector = Icons.Default.ArrowBack,
                                contentDescription = "Back",
                                tint = Color.Black,
                                modifier = Modifier.size(24.dp)
                            )
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
        // Konten utama layar detail edukasi
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(contentPadding).fillMaxSize()) {
            DetailEdukasiContent(newEdukasi = newEdukasi)
        }
    }
}

@Composable
fun DetailEdukasiContent (
    newEdukasi: List<Edukasi>,
    modifier: Modifier = Modifier
) {
    if (newEdukasi.isNotEmpty()) {
        val edukasi = newEdukasi[0]

        Column (
            horizontalAlignment = Alignment.Start,
            modifier = Modifier.padding(top = 8.dp)
        ) {
            Text(
                modifier = Modifier.offset(x = 8.dp),
                text = newEdukasi[0].judul,
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(16.dp))
            Image(
                painter = painterResource(id = edukasi.image),
                contentDescription = edukasi.judul, modifier = Modifier
                    .clip(RoundedCornerShape(8.dp))
                    .fillMaxWidth(0.8f)
                    .align(Alignment.CenterHorizontally)
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
                horizontalAlignment = Alignment.Start
            ) {
                Text(
                    text = newEdukasi[0].deskripsi,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(16.dp))
                newEdukasi[0].penjelasan?.let {
                    Text(
                        text = it,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Light
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewDetailEdukasiScreen () {
//    DetailEdukasiContent(newEdukasi = SmartcornData.edukasi)
    // Buat NavController dummy untuk preview
    val navController = rememberNavController()

    // Buat data dummy untuk edukasiId
    val dummyEdukasiId = 1 // Ganti dengan ID yang sesuai dengan data dummy Anda

    // Panggil fungsi DetailEdukasiScreen dengan data dummy
    DetailEdukasiScreen(
        navController = navController,
        edukasiId = dummyEdukasiId
    )
}