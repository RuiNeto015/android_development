package ipp.estg.cmu_group4.components

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusEvent
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun SearchBar(
    placeholder: String,
    input: TextFieldValue,
    onValueChange: (input: TextFieldValue) -> Unit,
    openBottomSheet: () -> Unit
) {
    TextField(
        modifier = Modifier.onFocusEvent { if (it.isFocused) openBottomSheet() },
        value = input,
        onValueChange = { onValueChange(it) },
        shape = RoundedCornerShape(50.dp),
        placeholder = { Text(placeholder) },
        trailingIcon = { Icon(Icons.Filled.Search, "") },
        singleLine = true,
        colors = TextFieldDefaults.textFieldColors(
            textColor = Color.Black,
            disabledTextColor = Color.Transparent,
            backgroundColor = Color.Gray,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent
        )
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreviewFavouritesScreen() {
    var searchInput by remember { mutableStateOf(TextFieldValue("")) }
    //SearchBar("Destination?", searchInput) { searchInput = it }
}