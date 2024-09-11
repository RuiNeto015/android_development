package ipp.estg.cmu_group4.ui.screens.drawerScreens.profileScreens

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ipp.estg.cmu_group4.components.VehicleRow
import ipp.estg.cmu_group4.R

@Composable
fun VehiclesScreen() {

    Column(
        modifier = Modifier
            .padding(10.dp, 10.dp, 10.dp, 10.dp))
    {
        VehicleRow(
            brand = "BMW",
            subBrand = "Série 3",
            plate = "20-18-ZS",
            km = 120,
            vehicleImage = painterResource(id = R.drawable.bmw_image)
        )
        VehicleRow(
            brand = "Mercedes",
            subBrand = "Class CLA",
            plate = "UA-ZV-89",
            km = 30,
            vehicleImage = painterResource(id = R.drawable.mercedes_image)
        )
        VehicleRow(
            brand = "Tesla",
            subBrand = "Model S Plaid",
            plate = "AB-56-30",
            km = 0,
            vehicleImage = painterResource(id = R.drawable.tesla_image)
        )
    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreviewVehiclesScreen() {
    VehiclesScreen()
}