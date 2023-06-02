package com.c1ph3rj.c1ph3rcart

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.c1ph3rj.c1ph3rcart.navigation.BottomNavData
import com.c1ph3rj.c1ph3rcart.navigation.Navigation
import com.c1ph3rj.c1ph3rcart.network.RequestManager
import com.c1ph3rj.c1ph3rcart.ui.theme.C1ph3rCartTheme
import com.c1ph3rj.c1ph3rcart.ui.theme.appColor1

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            C1ph3rCartTheme {
                val navController = rememberNavController()
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.White
                ) {
                    MainScreen(navController = navController)
                }
            }
        }
    }
}

@Composable
fun MainScreen(navController: NavHostController) {
    Scaffold(
        backgroundColor = Color.White,
        bottomBar = { BottomNavMenu(navController = navController) }
    ) {
        Navigation(navController = navController)
    }
}

@Composable
fun BottomNavMenu(navController: NavController) {
    val listOfBottomMenuItems = listOf(
        BottomNavData.AllProducts,
        BottomNavData.Categories,
        BottomNavData.SearchProducts
    )
    BottomNavigation(
        contentColor = Color.White,
        backgroundColor = Color.White
    ) {
        listOfBottomMenuItems.forEach { menuItem ->
            val navBackStackEntry by navController.currentBackStackEntryAsState()
            val currentRoute = navBackStackEntry?.destination?.route
            val isSelected = currentRoute == menuItem.route
            BottomNavigationItem(
                selectedContentColor = appColor1,
                unselectedContentColor = Color.LightGray,
                selected = isSelected,
                icon = { Icon(imageVector = menuItem.icon, contentDescription = menuItem.title) },
                onClick = {
                    navController.navigate(menuItem.route) {
                        navController.graph.startDestinationRoute?.let { route ->
                            popUpTo(route) {
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                })
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    C1ph3rCartTheme {
        MainScreen(navController = rememberNavController())
    }
}