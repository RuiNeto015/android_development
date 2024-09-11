package ipp.estg.cmu_group4.components.layout

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun BottomBar(
    navController: NavHostController, toggle: () -> Unit
) {
    BottomNavigation(elevation = 10.dp) {
        BottomNavigationItem(
            icon = {
                Icon(imageVector = Icons.Default.Person, "")
            },
            label = { },
            selected = false,
            onClick = {
                navController.navigate("profile_menu")
                toggle()
            }
        )
        BottomNavigationItem(
            icon = {
                Icon(imageVector = Icons.Default.Favorite, "")
            },
            label = { },
            selected = false,
            onClick = {
                navController.navigate("favourites_screen")
                toggle()
            }
        )
        BottomNavigationItem(
            icon = {
                Icon(imageVector = Icons.Default.Settings, "")
            },
            label = { },
            selected = false,
            onClick = {
                navController.navigate("settings_screen")
                toggle()
            }
        )
    }
}