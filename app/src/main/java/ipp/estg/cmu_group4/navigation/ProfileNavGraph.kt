package ipp.estg.cmu_group4.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import ipp.estg.cmu_group4.ui.screens.drawerScreens.ProfileMenuScreen
import ipp.estg.cmu_group4.ui.screens.drawerScreens.profileScreens.ProfileScreen
import ipp.estg.cmu_group4.ui.screens.drawerScreens.profileScreens.PlacesHistoryScreen
import ipp.estg.cmu_group4.ui.screens.drawerScreens.profileScreens.StatisticsScreen
import ipp.estg.cmu_group4.ui.screens.drawerScreens.profileScreens.VehiclesScreen


fun NavGraphBuilder.profileNavGraph(navController: NavHostController) {
    navigation(startDestination = "profile_menu_root", route = "profile_menu") {
        composable(route = "vehicles_screen") {
            VehiclesScreen()
        }
        composable(route = "places_history_screen") {
            PlacesHistoryScreen()
        }
        composable(route = "profile_menu_root") {
            ProfileMenuScreen(navigate = { navController.navigate(it) })
        }
        composable(route = "statistics_screen") {
            StatisticsScreen()
        }
        composable(route = "profile_screen") {
            ProfileScreen()
        }
    }
}
