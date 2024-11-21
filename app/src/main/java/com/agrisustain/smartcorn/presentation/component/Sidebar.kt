package com.agrisustain.smartcorn.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ModalDrawer
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import kotlinx.coroutines.launch

@Composable
fun SideBarButton (
    onClick: () -> Unit,
) {
    Box(
        modifier = Modifier
            .size(40.dp) // Ukuran ikon
            .shadow(
                elevation = 4.dp,
                shape = RoundedCornerShape(8.dp),
                clip = false
            )
            .background(color = Color.White) // Warna latar belakang sidebar
            .padding(8.dp) // Padding di dalam background
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Garis-garis di sidebar
            IconButton(
                onClick = onClick
            ) {
                Icon(
                    imageVector = Icons.Default.Menu,
                    contentDescription = "Menu",
                )
            }
        }
    }
}

//@Composable
//fun ModalDrawerSample() {
//    val drawerState = rememberDrawerState(DrawerValue.Closed)
//    val scope = rememberCoroutineScope()
//    ModalDrawer(
//        drawerState = drawerState,
//        drawerContent = {
//            Button(
//                modifier = Modifier.align(Alignment.CenterHorizontally).padding(top = 16.dp),
//                onClick = { scope.launch { drawerState.close() } },
//                content = { Text("Close Drawer") }
//            )
//        },
//        content = {
//            Column(
//                modifier = Modifier.fillMaxSize().padding(16.dp),
//                horizontalAlignment = Alignment.CenterHorizontally
//            ) {
//                Text(text = if (drawerState.isClosed) ">>> Swipe >>>" else "<<< Swipe <<<")
//                Spacer(Modifier.height(20.dp))
//                Button(onClick = { scope.launch { drawerState.open() } }) { Text("Click to open") }
//            }
//        }
//    )
//}

@Preview(showBackground = true)
@Composable
fun PreviewSideBarIcon () {
    SideBarButton(onClick = { /* Action */ })
}