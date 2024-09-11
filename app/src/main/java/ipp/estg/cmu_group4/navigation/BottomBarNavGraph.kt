package ipp.estg.cmu_group4.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import ipp.estg.cmu_group4.ui.screens.drawerScreens.FavouritesScreen
import ipp.estg.cmu_group4.ui.screens.drawerScreens.SettingsScreen

@Composable
fun BottomBarNavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "profile_menu") {
        profileNavGraph(navController)

        composable(route = "favourites_screen") {
            FavouritesScreen()
        }
        composable(route = "settings_screen") {
            SettingsScreen()
        }
    }
}

