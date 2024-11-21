package com.agrisustain.smartcorn.presentation

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.agrisustain.smartcorn.R
import com.agrisustain.smartcorn.navigation.NavigationItem
import com.agrisustain.smartcorn.navigation.Screen

@Composable
fun SmartcornApp (
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()
) {
    val context = LocalContext.current

    NavHost(
        navController = navController,
        startDestination = Screen.GetStarted.route,
        modifier = modifier
    ) {
        composable(Screen.GetStarted.route) { GetStartedPage(navController) }
        composable(Screen.Start.route) { StartScreen(navController) }
        composable(Screen.Login.route) { LoginScreen(navController) }
        composable(Screen.Home.route) { HomeScreen(navController) }
        composable(Screen.Edukasi.route) { EdukasiScreen(navController) }
        composable(Screen.Scan.route) { DeteksiPenyakitScreen(navController) }
        composable(Screen.Forum.route) { ForumScreen(navController) }
        composable(Screen.Chat.route) { ChatScreen(navController) }
    }
}

@Composable
fun BottomBar (
    navController: NavController,
    modifier: Modifier = Modifier
) {
    NavigationBar (
        modifier = Modifier
            .clip(RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp)),
        containerColor = Color(0xFF47AF64)
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        val navigationItems = listOf(
            NavigationItem(
                title = stringResource(id = R.string.menu_home),
                icon = painterResource(id = R.drawable.baseline_home_24),
                screen = (Screen.Home)
            ),
            NavigationItem(
                title = stringResource(id = R.string.menu_edukasi),
                icon = painterResource(id = R.drawable.baseline_menu_book_24),
                screen = (Screen.Edukasi)
            ),
            NavigationItem(
                title = stringResource(id = R.string.menu_scan),
                icon = painterResource(id = R.drawable.baseline_photo_camera_24),
                screen = (Screen.Scan)
            ),
            NavigationItem(
                title = stringResource(id = R.string.menu_forum),
                icon = painterResource(id = R.drawable.baseline_forum_24),
                screen = (Screen.Forum)
            ),
        )
        navigationItems.map { item ->
            NavigationBarItem(
                selected = currentRoute == item.screen.route,
                onClick = {
                    navController.navigate(item.screen.route) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        restoreState = true
                        launchSingleTop = true
                    }
                },
                icon = {
                    Icon(
                        painter = item.icon,
                        contentDescription = item.title
                    )
                },
                label = { Text(text = item.title) }
            )
        }
    }
}

@Preview
@Composable
fun PreviewBottomBar () {
    SmartcornApp()
//    BottomBar(navController = rememberNavController())
}

