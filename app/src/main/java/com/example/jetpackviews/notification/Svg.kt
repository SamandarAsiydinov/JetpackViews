package com.example.jetpackviews.notification

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.TransformOrigin
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import com.example.jetpackviews.R

@Composable
fun Svg(
    swayAnim: Float,
    height: Dp,
    modifier: Modifier
) {
    Icon(
        painter = painterResource(id = R.drawable.ic_baseline_notifications_none_24),
        contentDescription = "",
        tint = if (isSystemInDarkTheme()) Color.White else Color(0xFF0B0B31),
        modifier = modifier
            .size(height)
            .graphicsLayer(
                transformOrigin = TransformOrigin(0.5f, 0f),
                rotationZ = swayAnim
            )
    )
}