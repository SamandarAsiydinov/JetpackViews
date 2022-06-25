package com.example.jetpackviews.notification

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun AnimateBell() {
    var needsAnimate by remember {
        mutableStateOf(NotificationDefinition.NotificationState.Idle)
    }
    val swayAnim by animateFloatAsState(
        targetValue = if (isMoveMode(needsAnimate)) 1f else 0f,
        animationSpec = NotificationDefinition.swayAnimation
    )
    val swayAnimReverse by animateFloatAsState(
        targetValue = if (isMoveMode(needsAnimate)) 1f else 0f,
        animationSpec = NotificationDefinition.swayReverse
    )
    LaunchedEffect(true) {
        needsAnimate =
            if (isMoveMode(needsAnimate)) NotificationDefinition.NotificationState.Idle else NotificationDefinition.NotificationState.Move
    }
    val containerHeight = 120.dp
    val height = 100.dp
    val clapperHeight = containerHeight.times(0.9f)
    val notificationHeight = containerHeight.times(0.1f)

    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Button(
            onClick = {
                if (isMoveMode(needsAnimate)) NotificationDefinition.NotificationState.Idle else NotificationDefinition.NotificationState.Move
            }
        ) {
            Text(
                text = "Repeat Animation!"
            )
        }
        Box(
            modifier = Modifier
                .padding(top = 15.dp)
                .size(containerHeight)
                .align(Alignment.CenterHorizontally)
                .clickable {
                    needsAnimate =
                        if (isMoveMode(needsAnimate)) NotificationDefinition.NotificationState.Idle else NotificationDefinition.NotificationState.Move
                }
        ) {
            Svg(
                swayAnim = swayAnim,
                height = height,
                modifier = Modifier.align(Alignment.Center)
            )
            Clapper(
                swayAnimReverse = swayAnimReverse,
                clapperHeight = clapperHeight,
                height = notificationHeight,
                swayAnim = swayAnim,
                modifier = Modifier.align(
                    Alignment.Center
                )
            )
        }
    }
}

