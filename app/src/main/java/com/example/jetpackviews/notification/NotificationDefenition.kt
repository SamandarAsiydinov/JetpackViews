package com.example.jetpackviews.notification

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.keyframes

object NotificationDefinition {
    enum class NotificationState {
        Move, Idle
    }
    val swayAnimation = keyframes<Float> {
        durationMillis = 1000
        -10f at 0 with LinearEasing
        10f at 250 with LinearEasing
        -10f at 500 with LinearEasing
        5f at 750 with LinearEasing
        0f at 1000 with LinearEasing
    }

    val swayReverse = keyframes<Float> {
        durationMillis = 1000
        5f at 0 with LinearEasing
        -5f at 250 with LinearEasing
        5f at 500 with LinearEasing
        -5f at 750 with LinearEasing
        0f at 1000 with LinearEasing
    }
}

fun isMoveMode(needsAnimate: NotificationDefinition.NotificationState) =
    needsAnimate == NotificationDefinition.NotificationState.Move