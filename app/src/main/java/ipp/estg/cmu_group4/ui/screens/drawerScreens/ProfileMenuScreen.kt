package ipp.estg.cmu_group4.ui.screens.drawerScreens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight.Companion.W400
import androidx.compose.ui.text.font.FontWeight.Companion.W500
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import ipp.estg.cmu_group4.R
import ipp.estg.cmu_group4.components.ProfileCard

@Composable
fun ProfileMenuScreen(navigate:(destination: String)->Unit) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Spacer(modifier = Modifier.height(30.dp))

        Image(
            modifier = Modifier
                .size(90.dp)
                .clip(shape = CircleShape)
                .clickable {},
            painter = painterResource(id = R.drawable.profile_image),
            contentDescription = "Profile Image"
        )

        Spacer(modifier = Modifier.height(10.dp))

        Text(text = "Web Devs", fontSize = 20.sp, fontWeight = W500)
        Text(text = "webdevs@estg.ipp.pt", fontSize = 17.sp, fontWeight = W400)

        Spacer(modifier = Modifier.height(30.dp))

        Column(
            modifier = Modifier.fillMaxHeight(),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Column() {
                ProfileCard(
                    text = "My Vehicles",
                    painterResource(id = R.drawable.car_icon),
                    navigate = {
                        navigate("vehicles_screen")
                    }
                )

                ProfileCard(
                    text = "Places History",
                    painterResource(id = R.drawable.places_icon),
                    navigate = {
                        navigate("places_history_screen")
                    }
                )

                ProfileCard(
                    text = "Statistics",
                    painterResource(id = R.drawable.statistics_icon),
                    navigate = {
                        navigate("statistics_screen")
                    }
                )

                ProfileCard(
                    text = "My Profile",
                    painterResource(id = R.drawable.profile_icon),
                    navigate = {
                        navigate("profile_screen")
                    }
                )
            }

            Column(Modifier.padding(bottom = 10.dp)) {
                Button(
                    onClick = {},
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp)
                        .padding(start = 10.dp, end = 10.dp),
                    colors = ButtonDefaults.buttonColors(backgroundColor = Red),
                ) {
                    Text(text = "Logout", fontWeight = W500, color = White)
                }
            }

        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreviewProfileMenuScreen() {
    val profileNavController = rememberNavController()
    ProfileMenuScreen(navigate = {profileNavController.navigate(it)})
}