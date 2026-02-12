package com.example.p4_ciudad_pabloalonsosergiorodriguez.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layout
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavBackStackEntry
import com.example.p4_ciudad_pabloalonsosergiorodriguez.MainViewModel
import com.example.p4_ciudad_pabloalonsosergiorodriguez.R

@Composable
fun FunVerticalThing(
    viewModel: MainViewModel,
    backStack: List<NavBackStackEntry>,
    modifier: Modifier = Modifier
) {
    Row(modifier) {
        backStack.forEach { entry ->
            // Cuando ya ha seleccionado categoría
            AnimatedVisibility (entry.destination.route == SelectionScreen.PlaceSelection.name) {
                val name = if (viewModel.isSearching.value) {
                    stringResource(R.string.fvt_buscar)
                } else {
                    viewModel.selectedCategory.value?.let {
                        stringResource(it.nombre)
                    } ?: "???"
                }
                Text(name, Modifier
                    .rotateVertically(false)
                    .padding(4.dp), style = TextStyle(fontSize = 20.sp))
            }
            // Cuando ya ha seleccionado sitio
            AnimatedVisibility (entry.destination.route == SelectionScreen.PlaceView.name) {
                val name = viewModel.selectedPlace.value?.let {
                    stringResource(it.name)
                }?: run {
                    "???"
                }

                Text(name, Modifier
                    .rotateVertically(false)
                    .padding(4.dp), style = TextStyle(fontSize = 25.sp, textAlign = TextAlign.End))
            }
        }
    }
}

@Preview
@Composable
fun ProtoVerticalText() {
    Row(Modifier
        .height(300.dp)
        .width(300.dp)) {
        Text("Holaa", Modifier
            .rotateVertically(false)
            .background(Color.Red), style = androidx.compose.ui.text.TextStyle(color = Color.White))
    }
}

// Source - https://stackoverflow.com/a/77115028
// Posted by BennyG
// Retrieved 2026-02-12, License - CC BY-SA 4.0

fun Modifier.rotateVertically(clockwise: Boolean = true): Modifier {
    val rotate = rotate(if (clockwise) 90f else -90f)

    val adjustBounds = layout { measurable, constraints ->
        val placeable = measurable.measure(constraints)
        layout(placeable.height, placeable.width) {
            placeable.place(
                x = -(placeable.width / 2 - placeable.height / 2),
                y = -(placeable.height / 2 - placeable.width / 2)
            )
        }
    }
    return rotate then adjustBounds
}
