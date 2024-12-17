package com.agrisustain.smartcorn.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Cameraswitch
import androidx.compose.material.icons.filled.FlashOn
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Photo
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun KameraScreen(
    navController: NavController
) {
    Scaffold { contentPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black)
                .padding(contentPadding)
        ) {

            IconButton(
                onClick = {  },
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .padding(16.dp)
            ) {
                Icon(
                    imageVector = Icons.Filled.FlashOn,
                    contentDescription = "Flash",
                    tint = Color.White,
                    modifier = Modifier.size(48.dp)
                )
            }


            IconButton(
                onClick = {  },
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .padding(16.dp)
            ) {
                Icon(
                    imageVector = Icons.Filled.Cameraswitch,
                    contentDescription = "Switch Camera",
                    tint = Color.White,
                    modifier = Modifier.size(48.dp)
                )
            }


            IconButton(
                onClick = {  },
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .padding(16.dp)
            ) {
                Icon(
                    imageVector = Icons.Filled.Photo,
                    contentDescription = "Gallery",
                    tint = Color.White,
                    modifier = Modifier.size(48.dp) // Ikon diperbesar
                )
            }


            Box(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(bottom = 32.dp)
                    .size(80.dp)
                    .background(Color.White, shape = CircleShape)
            )


            IconButton(
                onClick = {  },
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(16.dp)
            ) {
                Icon(
                    imageVector = Icons.Filled.Info,
                    contentDescription = "Help",
                    tint = Color.White,
                    modifier = Modifier.size(48.dp)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewKameraScreen() {
    KameraScreen(navController = rememberNavController())
}
