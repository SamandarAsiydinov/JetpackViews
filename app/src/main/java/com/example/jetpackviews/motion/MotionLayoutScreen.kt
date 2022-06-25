package com.example.jetpackviews.motion

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.ExperimentalMotionApi
import androidx.constraintlayout.compose.MotionLayout
import androidx.constraintlayout.compose.MotionLayoutDebugFlags
import com.example.jetpackviews.utils.MotionObject
import java.util.*

@Composable
fun MotionLayoutScreen() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "MotionLayout Visibility",
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center
                    )
                }
            )
        }
    ) {
        MyMotionLayout()
    }
}


@OptIn(ExperimentalMotionApi::class)
@Composable
fun MyMotionLayout() {
    var animatedToEnd by remember { mutableStateOf(false) }
    val progress by animateFloatAsState(
        targetValue = if (animatedToEnd) 1f else 0f,
        animationSpec = tween(6000)
    )
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        MotionLayout(
            progress = progress,
            modifier = Modifier
                .fillMaxWidth()
                .height(400.dp)
                .background(Color.White),
            start = ConstraintSet(
                MotionObject.set1
            ),
            end = ConstraintSet(
                MotionObject.set2
            ),
            debug = EnumSet.of(MotionLayoutDebugFlags.SHOW_ALL)
        )
        {
            Box(
                modifier = Modifier
                    .layoutId("b")
                    .background(Color.Green)
            )
        }
        Button(onClick = { animatedToEnd = !animatedToEnd }) {
            Text(text = "Go")
        }
    }
}

// Ps: Thank you Make It Easy :]