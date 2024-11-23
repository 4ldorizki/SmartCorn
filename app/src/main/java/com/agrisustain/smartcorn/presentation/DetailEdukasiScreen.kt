package com.agrisustain.smartcorn.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.agrisustain.smartcorn.R
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
                        text = "Baca",
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
        Column(modifier = Modifier.padding(contentPadding).fillMaxSize()) {
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
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                text = newEdukasi[0].judul,
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.width(16.dp))
            Image(
                painter = painterResource(id = edukasi.image),
                contentDescription = edukasi.judul, modifier = Modifier
                    .clip(RoundedCornerShape(8.dp))
                    .size(150.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewDeetailEdukasiScreen () {
    DetailEdukasiContent(newEdukasi = SmartcornData.edukasi)
}