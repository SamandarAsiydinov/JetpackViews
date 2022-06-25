package com.example.jetpackviews.notification

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun Clapper(
    swayAnimReverse: Float,
    clapperHeight: Dp,
    height: Dp,
    swayAnim: Float,
    modifier: Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.graphicsLayer(
            rotationZ = swayAnimReverse
        )
    ) {
        Box(
            modifier = Modifier
                .width(16.dp)
                .height(clapperHeight)
                .background(Color.Transparent)
        )
        Box(
            modifier = Modifier
                .width(24.dp)
                .height(height)
                .graphicsLayer(rotationZ = swayAnim)
                .background(
                    Color.Green,
                    RoundedCornerShape(
                        topStart = 0.dp,
                        topEnd = 0.dp,
                        bottomStart = 15.dp,
                        bottomEnd = 15.dp
                    )
                )
        )
    }
}