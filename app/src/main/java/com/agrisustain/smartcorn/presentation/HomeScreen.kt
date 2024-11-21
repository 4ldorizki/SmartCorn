package com.agrisustain.smartcorn.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.agrisustain.smartcorn.presentation.component.HomeItem
import com.agrisustain.smartcorn.presentation.component.SideBarButton

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    navController: NavController
) {
    // Kondisi jika belum login redirect ke login page
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
        // Konten HomeScreen
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

            Spacer(modifier = Modifier.height(16.dp))

            // Grid fitur
            HomeItem(navController = rememberNavController())
        }
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewHomeScreen () {
    HomeScreen(navController = rememberNavController())
}