package com.example.jetpackviews.speedometer

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.*
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun SpeedMeter(
    progress: Int
) {
    val arcDegrees = 275
    val startArcAngle = 135f
    val startStepAngle = -45
    val numberOfMarkers = 55
    val degreesMarkerStep = arcDegrees / numberOfMarkers

    Canvas(
        modifier = Modifier
            .fillMaxWidth()
            .aspectRatio(1f),
        onDraw = {
            drawIntoCanvas { canvas ->
                val w = drawContext.size.width
                val h = drawContext.size.height
                val centerOffset = Offset(w / 2f, h / 2f)
                val quarterOffset = Offset(w / 4f, h / 4f)

                val (mainColor, secondaryColor) = when {
                    progress < 20 -> Color(0xFFD32F2F) to Color(0xFFFFCDD2)
                    progress < 40 -> Color(0xFFF57C00) to Color(0xFFFFE0B2)
                    else -> Color(0xFF388E3C) to Color(0xFFC8E6C9)
                }
                val paint = Paint().apply {
                    color = mainColor
                }
                val centerArcSize = Size(w / 2f, h / 2f)
                val centerArcStroke = Stroke(20f, 0f, StrokeCap.Round)

                drawArc(
                    secondaryColor,
                    startArcAngle,
                    arcDegrees.toFloat(),
                    false,
                    topLeft = quarterOffset,
                    size = centerArcSize,
                    style = centerArcStroke
                )

                drawArc(
                    mainColor,
                    startArcAngle,
                    (degreesMarkerStep * progress).toFloat(),
                    false,
                    topLeft = quarterOffset,
                    size = centerArcSize,
                    style = centerArcStroke
                )

                drawCircle(mainColor, 50f, centerOffset)
                drawCircle(Color.White, 25f, centerOffset)
                drawCircle(Color.Black, 20f, centerOffset)

                for ((counter, degrees) in (startStepAngle..(startStepAngle + arcDegrees) step degreesMarkerStep).withIndex()) {
                    val lineEndX = 80f
                    paint.color = mainColor
                    val lineStartX = if (counter % 5 == 0) {
                        paint.strokeWidth = 3f
                        0f
                    } else {
                        paint.strokeWidth = 1f
                        lineEndX * .2f
                    }
                    canvas.save()
                    canvas.rotate(degrees.toFloat(), w / 2f, h / 2f)
                    canvas.drawLine(
                        Offset(lineStartX, h / 2f),
                        Offset(lineEndX, h / 2f),
                        paint
                    )

                    if (counter == progress) {
                        paint.color = Color.Black
                        canvas.drawPath(
                            Path().apply {
                                moveTo(w / 2, (h / 2) - 5)
                                lineTo(w / 2, (h / 2) + 5)
                                lineTo(w / 4f, h / 2)
                                lineTo(w / 2, (h / 2) - 5)
                                close()
                            },
                            paint
                        )
                    }
                    canvas.restore()
                }
            }
        }
    )
}

@Preview
@Composable
fun SpeedPreview() {
    SpeedMeter(progress = 50)
}