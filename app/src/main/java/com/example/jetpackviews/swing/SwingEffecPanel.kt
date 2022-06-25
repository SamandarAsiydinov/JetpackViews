package com.example.jetpackviews.swing


import androidx.compose.animation.core.*
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.TransformOrigin
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SwingEffectScreen() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier.rotate(45f),
            contentAlignment = Alignment.TopStart
        ) {
            SwingEffectPanel()
            SwingEffectNail()
        }
    }
}

@Composable
fun SwingEffectPanel() {
    val angleOffset = 10f
    val infiniteTransition = rememberInfiniteTransition()
    val angle by infiniteTransition.animateFloat(
        initialValue = -angleOffset,
        targetValue = angleOffset,
        animationSpec = infiniteRepeatable(
            animation = tween(
                durationMillis = 3000,
                easing = FastOutSlowInEasing
            ),
            repeatMode = RepeatMode.Reverse
        )
    )
    Surface(
        modifier = Modifier
            .size(150.dp)
            .graphicsLayer(
                transformOrigin = TransformOrigin(
                    pivotFractionX = 0.2f,
                    pivotFractionY = 0.2f
                ),
                rotationZ = angle
            ),
        color = Color.Green,
        shape = RoundedCornerShape(8.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .rotate(-45f),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Jetpack Compose",
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                textAlign = TextAlign.Center
            )
        }
    }
}

@Composable
fun SwingEffectNail() {
    Surface(
        modifier = Modifier
            .padding(8.dp)
            .size(45.dp),
        color = Color.Blue,
        shape = CircleShape,
        border = BorderStroke(
            width = 10.dp,
            color = Color.White
        )
    ) {}
}