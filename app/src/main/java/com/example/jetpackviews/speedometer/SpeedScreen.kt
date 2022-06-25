package com.example.jetpackviews.speedometer

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Slider
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@Composable
fun SpeedScreen() {
    var targetValue by remember { mutableStateOf(0f) }
    val progress = remember(targetValue) { Animatable(initialValue = 0f) }
    val scope = rememberCoroutineScope()

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Slider(value = targetValue, onValueChange = { targetValue = it })

        val intValue = targetValue * 55
        Text(
            text = "${intValue.toInt()}"
        )

        Button(
            onClick = {
                scope.launch {
                    progress.animateTo(
                        targetValue = intValue,
                        animationSpec = tween(
                            durationMillis = 1000,
                            easing = FastOutLinearInEasing
                        )
                    )
                }
            }
        ) {
            Text(text = "Go")
        }
        Spacer(modifier = Modifier.height(20.dp))
        SpeedMeter(progress = progress.value.toInt())
    }
}