package ipp.estg.cmu_group4.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun VehicleRow(brand:String, subBrand:String, plate:String, km: Int, vehicleImage: Painter){

    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .clip(shape = RoundedCornerShape(30.dp))
            .fillMaxWidth()
            .background(Color(0xFFd8dcda))
            .clickable {}
            .height(120.dp)
            .padding(10.dp, 10.dp, 10.dp, 10.dp)
    ) {
        Column(
            verticalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .padding(10.dp)
        ) {
            Text(
                text = subBrand,
                fontWeight = Bold,
                fontSize = 18.sp,
                modifier = Modifier
                    .align(alignment = Alignment.CenterHorizontally)
            )
            Text(
                text = brand,
                fontWeight = Bold,
                fontSize = 15.sp,
                modifier = Modifier
                    .align(alignment = Alignment.CenterHorizontally)
            )
            Text(
                text = plate, fontSize = 13.sp,
                modifier = Modifier
                    .align(alignment = Alignment.CenterHorizontally)
            )
            Text(
                text = "$km km this week", fontSize = 13.sp,
                modifier = Modifier
                    .align(alignment = Alignment.CenterHorizontally)
            )
        }

        Column(
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .padding(end = 10.dp)
        ) {
            Image(
                modifier = Modifier
                    .size(130.dp),
                painter = vehicleImage,
                contentDescription = "Car Image"
            )
        }
    }
    Spacer(modifier = Modifier.height(10.dp))
}

@Preview(showBackground = true)
@Composable
fun DefaultPreviewVehicleRow() {
    //VehicleRow()
}