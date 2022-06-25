package com.example.jetpackviews

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.jetpackviews.motion.MotionLayoutScreen
import com.example.jetpackviews.notification.AnimateBell
import com.example.jetpackviews.shopping.view.ProductDesign
import com.example.jetpackviews.speedometer.SpeedScreen
import com.example.jetpackviews.swing.SwingEffectScreen
import com.example.jetpackviews.toggle.ToggleScreen
import com.example.jetpackviews.ui.theme.JetpackViewsTheme
import com.example.jetpackviews.wheelpick.MyWheelPickerScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackViewsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    AnimateBell()
                    //MyWheelPickerScreen()
                    //ToggleScreen()
                    //SpeedScreen()
                   // SwingEffectScreen()
                   // ProductDesign()
                }
            }
        }
    }
}
