package com.agrisustain.smartcorn.presentation

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.agrisustain.smartcorn.data.SmartcornData
import com.agrisustain.smartcorn.model.Edukasi
import com.agrisustain.smartcorn.navigation.Screen
import com.agrisustain.smartcorn.presentation.component.EdukasiItem
import com.agrisustain.smartcorn.presentation.component.SideBarButton
import com.agrisustain.smartcorn.viewmodel.AuthState
import com.agrisustain.smartcorn.viewmodel.AuthViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EdukasiScreen(
    navController: NavController,
    modifier: Modifier = Modifier,
    edukasi: List<Edukasi> = SmartcornData.edukasi,
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        "SmartCorn",
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Medium,
                        color = Color.White,
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
        // Konten utama layar edukasi
        Column(modifier = Modifier.padding(contentPadding)) {
            // Search bar
            OutlinedTextField(
                value = "",
                onValueChange = { /* Handle search */ },
                placeholder = { Text("Cari kategori") },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = "Search"
                    )
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .background(Color(0xFFF1F8E9), shape = RoundedCornerShape(8.dp))
            )

            // Judul "Tips Budidaya"
            Text(
                text = "Tips Budidaya",
                fontSize = 16.sp,
                color = Color.Black,
                modifier = Modifier.padding(16.dp),
                fontWeight = FontWeight.Bold
            )

            // Daftar edukasi
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(8.dp),
                modifier = modifier.padding(horizontal = 8.dp)
            ) {
                items(edukasi, key = { it.id }) {
                    EdukasiItem(edukasi = it) { edukasiId ->
                        navController.navigate(Screen.DetailEdukasi.route + "/$edukasiId")
                    }
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewEdukasiScreen () {
    EdukasiScreen(navController = rememberNavController())
}