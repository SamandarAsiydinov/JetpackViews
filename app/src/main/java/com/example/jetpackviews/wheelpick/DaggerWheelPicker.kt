package com.example.jetpackviews.wheelpick

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.scrollBy
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import dev.chrisbanes.snapper.ExperimentalSnapperApi
import dev.chrisbanes.snapper.LazyListSnapperLayoutInfo
import dev.chrisbanes.snapper.rememberLazyListSnapperLayoutInfo
import dev.chrisbanes.snapper.rememberSnapperFlingBehavior
import kotlin.math.abs

@Composable
fun MyWheelPickerScreen() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        DaggerWheelPicker()
    }
}

@Composable
fun DaggerWheelPicker() {
    val lists = arrayListOf<Int>().apply {
        repeat(50) {
            add(it)
        }
    }
    WheelPicker(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Green.copy(alpha = 0.5f))
            .padding(20.dp),
        pickerMaxHeight = 350.dp,
        defaultTextStyle = MaterialTheme.typography.body1,
        centerTextStyle = MaterialTheme.typography.h6,
        lists = lists
    )
}

@OptIn(ExperimentalSnapperApi::class)
@Composable
fun WheelPicker(
    modifier: Modifier,
    pickerMaxHeight: Dp = 250.dp,
    initIndex: Int? = null,
    lists: ArrayList<Int>,
    defaultTextStyle: TextStyle = MaterialTheme.typography.body1,
    centerTextStyle: TextStyle = MaterialTheme.typography.h6,
    defaultTextColor: Color = Color.Black.copy(alpha = 0.4f),
    centerTextColor: Color = Color.Black,
    selectedBackColor: Color = Color.Black.copy(alpha = 0.3f)
) {
    val lazyListState = rememberLazyListState(
        initialFirstVisibleItemIndex = (Int.MAX_VALUE / 2.0).toInt() - 25
    )
    val layoutInfo: LazyListSnapperLayoutInfo =
        rememberLazyListSnapperLayoutInfo(lazyListState = lazyListState)
    var currentIndex: Int?

    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .height(pickerMaxHeight),
            state = lazyListState,
            flingBehavior = rememberSnapperFlingBehavior(lazyListState = lazyListState),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            items(
                count = Int.MAX_VALUE,
                key = { it }
            ) {
                val index = it % lists.size
                currentIndex = layoutInfo.currentItem?.index?.minus(Int.MAX_VALUE / 2)?.plus(23)
                    ?.rem(lists.size)

                if (currentIndex != null && currentIndex!! < 0) {
                    currentIndex = currentIndex!! + lists.size
                }

                val curTextIsCenter = currentIndex == lists[index]
                val curTextIsCenterDiffer = currentIndex == abs(lists[index] - 1) ||
                        currentIndex == abs(lists[index] + 1)

                Text(
                    text = if (lists[index] == 0) "Index 0" else "Index ${lists[index]}",
                    style = if (curTextIsCenter) centerTextStyle else defaultTextStyle,
                    color = if (curTextIsCenter) centerTextColor else defaultTextColor,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(pickerMaxHeight * 0.215f)
                        .padding(vertical = 14.dp)
                        .align(Alignment.Center)
                        .scale(
                            scaleX = if (curTextIsCenter) 1.2f else if (curTextIsCenterDiffer) 1.0f else 0.8f,
                            scaleY = if (curTextIsCenter) 1.2f else if (curTextIsCenterDiffer) 1.0f else 0.8f
                        )
                )
            }
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(pickerMaxHeight * 0.215f)
                .background(selectedBackColor)
        )
        LaunchedEffect(Unit) {
            initIndex?.let {
                lazyListState.scrollToItem(
                    index = (Int.MAX_VALUE / 2.0).toInt() - 25 + it,
                    scrollOffset = lazyListState.layoutInfo.visibleItemsInfo[0].size / 5
                )
            } ?: kotlin.run {
                lazyListState.scrollBy(
                    value = lazyListState.layoutInfo.visibleItemsInfo[0].size.toFloat() / 5
                )
            }
        }
    }
}