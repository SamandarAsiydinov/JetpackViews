package com.example.jetpackviews.shopping.view

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import com.example.jetpackviews.shopping.model.Product
import com.example.jetpackviews.utils.SampleData
import com.example.jetpackviews.utils.myProduct
import com.example.jetpackviews.ui.theme.*

@Composable
fun ProductDesign() {
    Scaffold(
        topBar = {
            TopAppBar(
                elevation = 0.dp,
                title = {
                    Text(
                        text = "Shop",
                        color = Color.White,
                        fontWeight = FontWeight.Bold
                    )
                },
                navigationIcon = {
                    IconButton(onClick = {}) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = "Back",
                            modifier = Modifier
                                .size(25.dp),
                            tint = Color.White
                        )
                    }
                },
                actions = {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            imageVector = Icons.Filled.Search,
                            contentDescription = "Search",
                            modifier = Modifier.size(25.dp),
                            tint = Color.White
                        )
                    }
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            imageVector = Icons.Default.ShoppingCart,
                            contentDescription = "",
                            modifier = Modifier.size(25.dp),
                            tint = Color.White
                        )
                    }
                },
                backgroundColor = PrimaryColor
            )
        }
    ) {
        HomeContent()
    }
}

@Composable
fun HomeContent() {
    val product: Product = myProduct

    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .background(PrimaryColor),
        constraintSet = ConstraintSet(
            SampleData.set1
        )
    ) {
        Card(
            shape = RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp),
            elevation = 0.dp,
            modifier = Modifier
                .layoutId("bgCard")
                .height(444.dp)
                .fillMaxWidth()
        ) {
            ConstraintLayout(
                constraintSet = ConstraintSet(
                    SampleData.set2
                ),
                modifier = Modifier
                    .padding(start = 10.dp, end = 10.dp)
            ) {
                CardContent(product)
            }
        }

        Text(
            text = "Sneakers",
            fontSize = 20.sp,
            color = Color.White,
            modifier = Modifier
                .layoutId("productCategory")
                .padding(top = 16.dp, start = 16.dp, end = 16.dp, bottom = 8.dp)
        )

        Text(
            text = product.title,
            fontSize = 30.sp,
            color = Color.White,
            modifier = Modifier
                .layoutId("productTitle")
                .padding(start = 16.dp)
        )

        Image(
            painter = painterResource(id = product.image),
            contentDescription = "Product Image",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .layoutId("productImage")
                .padding(start = 200.dp)
                .width(257.dp)
                .height(265.dp)
                .padding(end = 32.dp, bottom = 62.dp)
        )

        Text(
            text = "Price",
            fontSize = 20.sp,
            color = Color.White,
            modifier = Modifier
                .layoutId("productPriceLabel")
                .padding(start = 16.dp)
        )

        Text(
            text = product.price,
            fontSize = 30.sp,
            color = Color.White,
            modifier = Modifier
                .layoutId("productPrice")
                .padding(start = 16.dp, bottom = 8.dp, top = 8.dp)
        )
    }
}

@Composable
fun CardContent(product: Product) {
    val count = remember { mutableStateOf(0) }
    Text(
        text = "Color",
        color = Color.Gray,
        modifier = Modifier
            .layoutId("txtColor")
            .padding(top = 64.dp)
    )

    Button(
        onClick = { /*TODO*/ },
        shape = RoundedCornerShape(10.dp),
        modifier = Modifier
            .layoutId("color1")
            .padding(top = 8.dp)
            .width(15.dp)
            .height(15.dp),
        colors = ButtonDefaults.buttonColors(PrimaryColor),
        elevation = ButtonDefaults.elevation(
            defaultElevation = 0.dp,
            pressedElevation = 0.dp,
            disabledElevation = 0.dp
        )
    ) {

    }

    Button(
        onClick = { /*TODO*/ },
        shape = RoundedCornerShape(10.dp),
        modifier = Modifier
            .layoutId("color2")
            .padding(top = 8.dp, start = 20.dp)
            .width(15.dp)
            .height(15.dp),
        colors = ButtonDefaults.buttonColors(ProductOptionColor2),
        elevation = ButtonDefaults.elevation(
            defaultElevation = 0.dp,
            pressedElevation = 0.dp,
            disabledElevation = 0.dp
        )
    ) {

    }

    Button(
        onClick = { /*TODO*/ },
        shape = RoundedCornerShape(10.dp),
        modifier = Modifier
            .layoutId("color3")
            .padding(top = 8.dp, start = 40.dp)
            .width(15.dp)
            .height(15.dp),
        colors = ButtonDefaults.buttonColors(ProductOptionColor3),
        elevation = ButtonDefaults.elevation(
            defaultElevation = 0.dp,
            pressedElevation = 0.dp,
            disabledElevation = 0.dp
        )
    ) {

    }

    Text(
        text = "Size",
        modifier = Modifier
            .layoutId("txtSize")
            .padding(top = 64.dp, start = 90.dp),
        color = Color.Gray
    )

    Text(
        text = product.size,
        modifier = Modifier
            .layoutId("txtSizeValue")
            .padding(start = 90.dp, top = 8.dp, bottom = 16.dp),
        color = Color.DarkGray
    )

    Text(
        text = product.desc,
        modifier = Modifier
            .layoutId("txtDescription"),
        color = Color.Gray
    )

    OutlinedButton(
        onClick = {
            if (count.value > 0) {
                count.value--
            }
        },
        shape = RoundedCornerShape(16.dp),
        modifier = Modifier
            .layoutId("btnMinus")
            .padding(top = 32.dp, end = 16.dp)
    ) {
        Text(
            text = "-",
            fontSize = 23.sp,
            color = Color.Black
        )
    }

    Text(
        text = count.value.toString(),
        fontSize = 25.sp,
        color = Color.Black,
        modifier = Modifier
            .layoutId("txtQtd")
            .padding(top = 32.dp, start = 80.dp)
    )

    OutlinedButton(
        onClick = {
            count.value++
        },
        shape = RoundedCornerShape(16.dp),
        modifier = Modifier
            .layoutId("btnPlus")
            .padding(top = 32.dp, start = 120.dp)
    ) {
        Text(
            text = "+",
            fontSize = 23.sp,
            color = Color.Black
        )
    }

    OutlinedButton(
        onClick = { /*TODO*/ },
        border = BorderStroke(
            width = 1.dp,
            color = Color.Blue
        ),
        shape = RoundedCornerShape(16.dp),
        modifier = Modifier
            .layoutId("btnAddtoCart")
            .padding(top = 32.dp)
    ) {
        Image(
            imageVector = Icons.Filled.Add,
            contentDescription = "Add Cart",
            modifier = Modifier.size(25.dp)
        )
    }

    Button(
        onClick = { /*TODO*/ },
        shape = RoundedCornerShape(16.dp),
        modifier = Modifier
            .layoutId("btnBuy")
            .padding(top = 32.dp, start = 90.dp)
            .width(215.dp),
        colors = ButtonDefaults.buttonColors(PrimaryColor),
        elevation = ButtonDefaults.elevation(
            defaultElevation = 0.dp,
            pressedElevation = 0.dp,
            disabledElevation = 0.dp
        )
    ) {
        Text(
            text = "BUY NOW",
            fontSize = 23.sp,
            color = Color.White
        )
    }
}

@Preview
@Composable
fun ProductDesignPreview() {
    ProductDesign()
}