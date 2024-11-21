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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.agrisustain.smartcorn.R
import com.agrisustain.smartcorn.navigation.Screen
import com.agrisustain.smartcorn.presentation.component.BackButton
import com.agrisustain.smartcorn.presentation.component.SmartButton

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ForumScreen(
    navController: NavController
) {
    Scaffold(
        topBar = {
            TopAppBar(
                modifier = Modifier
                    .background(color = Color(0xFFE6F4EA))
                    .padding(start = 16.dp),
                navigationIcon = {
                    BackButton ( onClick = { navController.navigateUp() } )
                },
                title = {},
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Color(0xFFE6F4EA))
            )
        },
        bottomBar = {
            BottomBar(navController)
        }
    ) { padding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .background(Color(0xFFE6F4EA))
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Selamat Datang di Forum Komunitas",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                    textAlign = TextAlign.Center
                )
                Spacer(modifier = Modifier.height(16.dp))

                Spacer(modifier = Modifier.height(8.dp))
                Image(
                    painter = painterResource(id = R.drawable.petani),
                    contentDescription = "Maskot",
                    modifier = Modifier.size(200.dp)
                )
                Spacer(modifier = Modifier.height(24.dp))
                SmartButton(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 50.dp)
                        .align(Alignment.CenterHorizontally),
                    text = "Lihat Komunitas",
                    onClick = { navController.navigate(Screen.Chat.route) }
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChatScreen(
    navController: NavController
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("Forum Komunitas", fontSize = 20.sp, fontWeight = FontWeight.Bold, color = Color.White, modifier = Modifier.padding(start = 16.dp)) },
                navigationIcon = {
                    BackButton ( onClick = { navController.navigateUp() } )
                },
                actions = {
                    IconButton(onClick = { /* Handle more options */ }) {
                        Icon(imageVector = Icons.Default.MoreVert, contentDescription = "More Options", tint = Color.White)
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Color(0xFF47AF64))
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .background(Color.White)
        ) {
            // Chat Bubble
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .background(Color(0xFFF1F8E9), shape = RoundedCornerShape(8.dp))
                        .padding(12.dp)
                ) {
                    Text(
                        text = "Anda",
                        color = Color.Gray,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "Halo, saya merupakan petani jagung pemula. Bagaimana cara kita dapat membedakan bibit yang unggul dalam penanaman?",
                        color = Color.Black,
                        fontSize = 14.sp
                    )
                    Text(
                        text = "20:00",
                        color = Color.Gray,
                        fontSize = 12.sp,
                        textAlign = TextAlign.End,
                        modifier = Modifier.fillMaxWidth()
                    )
                }
                Spacer(modifier = Modifier.width(8.dp))
                Image(
                    painter = painterResource(id = R.drawable.profil), // Replace with actual avatar resource
                    contentDescription = "User Avatar",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(40.dp)
                        .background(Color.Gray, shape = CircleShape)
                )
            }

            Spacer(modifier = Modifier.weight(1f))

            // Input Field
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.LightGray)
                    .padding(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(onClick = { /* Handle emoji */ }) {
                    Icon(
                        tint = Color(0xFF3E8F5C),
                        painter = painterResource(id = R.drawable.ic_emoji),
                        contentDescription = "Emoji",
                        modifier = Modifier
                            .size(30.dp)
                    )
                }
                OutlinedTextField(
                    value = "",
                    onValueChange = { /* Handle input change */ },
                    placeholder = { Text("Tulis pesan...") },
                    modifier = Modifier
                        .weight(1f)
                        .padding(horizontal = 8.dp),
//                    colors = TextFieldDefaults.outlinedTextFieldColors(
//                        containerColor = Color.White,
//                        focusedBorderColor = Color.Transparent,
//                        unfocusedBorderColor = Color.Transparent
//                    )
                )
                IconButton(onClick = { /* Handle send */ }) {
                    Icon(
                        tint = Color(0xFF3E8F5C),
                        painter = painterResource(id = R.drawable.ic_send),
                        contentDescription = "Send",
                        modifier = Modifier.size(30.dp)
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewForumScreen() {
//    val mockNavController = rememberNavController()
//    ForumScreen(navController = mockNavController)
    ChatScreen(navController = rememberNavController())
}
