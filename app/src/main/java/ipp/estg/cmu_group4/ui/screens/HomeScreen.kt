package ipp.estg.cmu_group4.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import ipp.estg.cmu_group4.components.CircularIconButton
import ipp.estg.cmu_group4.components.DestinationResult
import ipp.estg.cmu_group4.components.SearchBar
import ipp.estg.cmu_group4.components.layout.BottomBar
import ipp.estg.cmu_group4.navigation.BottomBarNavGraph
import kotlinx.coroutines.*

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun HomeScreen() {
    val bottomBarNavController = rememberNavController()
    val scaffoldState = rememberScaffoldState(rememberDrawerState(DrawerValue.Closed))
    val coroutineScope = rememberCoroutineScope()
    val bottomSheetScaffoldState = rememberBottomSheetScaffoldState(
        bottomSheetState = rememberBottomSheetState(
            initialValue = BottomSheetValue.Collapsed
        )
    )
    val focusManager = LocalFocusManager.current

    Scaffold(scaffoldState = scaffoldState, bottomBar = {
        BottomBar(navController = bottomBarNavController,
            toggle = { toggleDrawer(coroutineScope, scaffoldState) })
    }, content = {
        BottomSheetScaffold(
            sheetShape = RoundedCornerShape(16.dp),
            scaffoldState = bottomSheetScaffoldState,
            sheetContent = {
                SheetContent(openBottomSheet = {
                    openBottomSheet(
                        coroutineScope, bottomSheetScaffoldState
                    )
                }, bottomSheetScaffoldState = bottomSheetScaffoldState)
            },
            sheetBackgroundColor = MaterialTheme.colors.background,
            sheetPeekHeight = 160.dp,
            sheetElevation = 20.dp,
        ) {

        }
    }, drawerContent = {
        BottomBarNavGraph(bottomBarNavController)
    })

    if (bottomSheetScaffoldState.bottomSheetState.isCollapsed) {
        focusManager.clearFocus()
    }
}


fun toggleDrawer(coroutineScope: CoroutineScope, scaffoldState: ScaffoldState) {
    coroutineScope.launch {
        if (scaffoldState.drawerState.isOpen) {
            scaffoldState.drawerState.close()
        } else {
            scaffoldState.drawerState.open()
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
fun openBottomSheet(
    coroutineScope: CoroutineScope, bottomSheetScaffoldState: BottomSheetScaffoldState
) {
    coroutineScope.launch {
        bottomSheetScaffoldState.bottomSheetState.expand()
    }
}

@SuppressLint("UnusedCrossfadeTargetStateParameter")
@OptIn(ExperimentalMaterialApi::class)
@Composable
fun SheetContent(openBottomSheet: () -> Unit, bottomSheetScaffoldState: BottomSheetScaffoldState) {
    var searchInput by remember { mutableStateOf(TextFieldValue("")) }
    val focusManager = LocalFocusManager.current
    val interactionSource = remember { MutableInteractionSource() }

    Column(
        modifier = Modifier
            .padding(vertical = 10.dp)
            .fillMaxWidth()
            .height(500.dp)
            .clickable(
                interactionSource = interactionSource, indication = null
            ) { focusManager.clearFocus() },
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Divider(
            thickness = 5.dp,
            modifier = Modifier
                .width(50.dp)
                .clip(RoundedCornerShape(2.dp))
                .padding(bottom = 20.dp)
        )
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                if (bottomSheetScaffoldState.bottomSheetState.isExpanded) {
                    CircularIconButton(
                        onClick = {},
                        modifier = Modifier.size(50.dp),
                        Color.Gray,
                        Icons.Filled.ArrowBack
                    )
                }
                SearchBar(placeholder = "Destination?",
                    input = searchInput,
                    onValueChange = { searchInput = it },
                    openBottomSheet = { openBottomSheet() })
            }

            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                DestinationResult("São Tomé", "Portugal", 890F, "m")
                DestinationResult("São Tomé", "Portugal", 5.0F, "km")
                DestinationResult("São Tomé", "Portugal", 5.0F, "km")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    HomeScreen()
}