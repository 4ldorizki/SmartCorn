package com.agrisustain.smartcorn.presentation.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.agrisustain.smartcorn.R
import com.agrisustain.smartcorn.model.Fitur
import com.agrisustain.smartcorn.navigation.Screen

@Composable
fun EdukasiPertanian (
    onClick: () -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .shadow(
                elevation = 8.dp,
                shape = RoundedCornerShape(16.dp),
                clip = false)
            .size(150.dp)
            .background(Color(color = 0xFF47AF64), shape = RoundedCornerShape(12.dp))
            .padding(8.dp)
            .clickable { onClick() }
    ) {
        Image(
            painter = painterResource(R.drawable.ic_agriculture_education),
            contentDescription = "Edukasi Pertanian",
            modifier = Modifier
                .clip(RoundedCornerShape(8.dp))
                .size(100.dp)
                .align(alignment = Alignment.CenterHorizontally)
        )
        Spacer(modifier = Modifier.width(16.dp))
        Text(
            text = "Edukasi Pertanian",
            style = MaterialTheme.typography.titleMedium,
            color = Color.White,
            overflow = TextOverflow.Ellipsis,
            textAlign = TextAlign.Start,
        )
    }
}

@Composable
fun DeteksiPenyakit (
    onClick: () -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .shadow(
                elevation = 8.dp,
                shape = RoundedCornerShape(16.dp),
                clip = false)
            .size(150.dp)
            .background(Color(color = 0xFF47AF64), shape = RoundedCornerShape(12.dp))
            .padding(8.dp)
            .clickable { onClick() }
    ) {
        Image(
            painter = painterResource(R.drawable.ic_plant_detection),
            contentDescription = "Deteksi Penyakit",
            modifier = Modifier
                .clip(RoundedCornerShape(8.dp))
                .size(100.dp)
                .align(alignment = Alignment.CenterHorizontally)
        )
        Spacer(modifier = Modifier.width(16.dp))
        Text(
            text = "Deteksi Penyakit",
            style = MaterialTheme.typography.titleMedium,
            color = Color.White,
            overflow = TextOverflow.Ellipsis,
            textAlign = TextAlign.Start,
        )
    }
}

@Composable
fun ForumKomunitas (
    onClick: () -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .shadow(
                elevation = 8.dp,
                shape = RoundedCornerShape(16.dp),
                clip = false)
            .size(150.dp)
            .background(Color(color = 0xFF47AF64), shape = RoundedCornerShape(12.dp))
            .padding(8.dp)
            .clickable { onClick() }
    ) {
        Image(
            painter = painterResource(R.drawable.ic_community_forum),
            contentDescription = "Forum Komunitas",
            modifier = Modifier
                .clip(RoundedCornerShape(8.dp))
                .size(100.dp)
                .align(alignment = Alignment.CenterHorizontally)
        )
        Spacer(modifier = Modifier.width(16.dp))
        Text(
            text = "Forum Komunitas",
            style = MaterialTheme.typography.titleMedium,
            color = Color.White,
            overflow = TextOverflow.Ellipsis,
            textAlign = TextAlign.Start,
        )
    }
}

@Composable
fun ProfilPengguna (
//    onClick: () -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .shadow(
                elevation = 8.dp,
                shape = RoundedCornerShape(16.dp),
                clip = false)
            .size(150.dp)
            .background(Color(color = 0xFF47AF64), shape = RoundedCornerShape(12.dp))
            .padding(8.dp)
//            .clickable { onClick() }
    ) {
        Image(
            painter = painterResource(R.drawable.ic_user_profile),
            contentDescription = "Profil Pengguna",
            modifier = Modifier
                .clip(RoundedCornerShape(8.dp))
                .size(100.dp)
                .align(alignment = Alignment.CenterHorizontally)
        )
        Spacer(modifier = Modifier.width(16.dp))
        Text(
            text = "Profil Pengguna",
            style = MaterialTheme.typography.titleMedium,
            color = Color.White,
            overflow = TextOverflow.Ellipsis,
            textAlign = TextAlign.Start,
        )
    }
}

@Composable
fun HomeItem (navController: NavController) {
    LazyVerticalGrid(
        columns = GridCells.Adaptive(minSize = 120.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = Modifier.padding(16.dp)
    ) {
        // Item Edukasi Pertanian
        item {
            EdukasiPertanian(
                onClick = {
                    navController.navigate(Screen.Edukasi.route)
                }
            )
        }

        // Item Deteksi Penyakit
        item {
            DeteksiPenyakit(
                onClick = {
                    navController.navigate(Screen.Scan.route)
                }
            )
        }

        // Item Forum Komunitas
        item {
            ForumKomunitas(
                onClick = {
                    navController.navigate(Screen.Forum.route)
                }
            )
        }

        // Item Profil Pengguna
        item {
            ProfilPengguna()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewHomeItem() {
    HomeItem(navController = rememberNavController())
}

