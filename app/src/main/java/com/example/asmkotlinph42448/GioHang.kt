package com.example.asmkotlinph42448

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class DanhsachCart(val img: Int, val text1: String, val gia: String)
class GioHang : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LayoutCart()
        }
    }
}

@Preview
@Composable
private fun LayoutCart() {
    val context = LocalContext.current
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            TopBar(
                title = "My cart",icon = R.drawable.person,
                icon2 = null,
                modifier = Modifier.width(260.dp),
                onClickButtontTrai = {
                    if (context is ComponentActivity) {
                        context.finish()
                    }
                }
            )
            val danhsachCart = listOf(
                DanhsachCart(R.drawable.lamp, "Coffee Table", "$ 20.00"),
                DanhsachCart(R.drawable.lamp, "Coffee Table", "$ 20.00"),
                DanhsachCart(R.drawable.lamp, "Coffee Table", "$ 20.00"),
                DanhsachCart(R.drawable.lamp, "Coffee Table", "$ 20.00"),
                DanhsachCart(R.drawable.lamp, "Coffee Table", "$ 20.00"),
            )
            LazyColumn(
                modifier = Modifier
                    .weight(1f)
                    .padding(bottom = 70.dp) // Padding to avoid the button
            ) {
                items(danhsachCart) { ds ->
                    ItemCart(
                        text = ds.text1,
                        img = ds.img,
                        gia = ds.gia,
                        modifier = Modifier.fillMaxWidth(),
                        onClickItem = {})
                    Divider(
                        color = Color.Gray,
                        thickness = 0.3.dp,
                        modifier = Modifier.padding(horizontal = 15.dp)
                    )
                }
            }
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter) // Aligns to the bottom center of the screen
        ) {
            ChonGiamGia()
        }
    }
}

@Composable
fun TopBar(title: String, icon: Int, icon2: Nothing?, modifier: Modifier, onClickButtontTrai: () -> Unit) {

}


@Composable
private fun ItemCart(
    text: String, img: Int, gia: String, modifier: Modifier = Modifier, onClickItem: () -> Unit
) {
    Row(
        modifier = modifier.clickable(onClick = onClickItem),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row {
            Image(
                painter = painterResource(id = img),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(120.dp)
                    .padding(10.dp)
                    .clip(shape = RoundedCornerShape(10.dp))
            )
            Column(modifier = Modifier.padding(top = 10.dp, start = 10.dp)) {
                Text(
                    text = text,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.W500,
                    color = Color.Gray,
                  
                )
                Text(
                    text = gia,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.W700,
                    color = Color.Black,
                
                )
                /////thanh cong tru
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.width(110.dp)
                ) {
                    androidx.compose.material3.IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            painter = painterResource(id = R.drawable.cart),
                            contentDescription = null,
                            modifier = Modifier
                                .size(25.dp)
                                .alpha(0.4F)
                        )
                    }
                    Text(
                        text = "50",
//                        fontFamily = FontFamily(Font(R.font.nunitosans_bold)),
                        fontWeight = FontWeight.W600,
                        fontSize = 18.sp,
                        color = Color.Black,
                        textAlign = TextAlign.Center,
                        letterSpacing = 5.sp
                    )
                    androidx.compose.material3.IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            painter = painterResource(id = R.drawable.cart),
                            contentDescription = null,
                            modifier = Modifier
                                .size(25.dp)
                                .alpha(0.4F)
                        )
                    }
                }
            }
        }
        // Spacer to add space between the second column and the third column
        Spacer(modifier = Modifier.width(16.dp))
        // Third Column

        androidx.compose.material3.IconButton(onClick = { /*TODO*/ }) {
            Icon(
                painter = painterResource(id = R.drawable.shopping),
                contentDescription = null,
                modifier = Modifier.size(25.dp)
            )
        }

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun ChonGiamGia() {
    val context= LocalContext.current
    var promoCode by remember { mutableStateOf("") }
    Column(modifier = Modifier
        .background(Color.White)) {
        Column(modifier = Modifier.padding(15.dp)) {
            Spacer(modifier = Modifier.height(16.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                TextField(
                    value = promoCode,
                    onValueChange = { promoCode = it },
                    label = { Text("Mã khuyến mãi") },

                    modifier = Modifier
                        .height(50.dp)
                        .border(
                            width = 0.2.dp,
                            color = Color.LightGray,
                            shape = RoundedCornerShape(8.dp)
                        ),
                    colors = TextFieldDefaults.textFieldColors(
                        containerColor = Color.White,
                        unfocusedIndicatorColor = Color.Transparent///xoa dau gach duoi
                        ,
                        focusedIndicatorColor = Color.Transparent,
                        focusedLabelColor = Color.Blue // Màu chữ khi focus
                        ,
                        unfocusedLabelColor = Color.Gray // Màu chữ khi không focus
                    )
                )
                androidx.compose.material3.IconButton(
                    onClick = { /*TODO*/ },
                    modifier = Modifier
                        .background(Color.Black, shape = RoundedCornerShape(10.dp))
                        .size(50.dp)

                ) {
                    Icon(
                        imageVector = Icons.Filled.KeyboardArrowRight,
                        contentDescription = "Next",
                        tint = Color.White,
                        modifier = Modifier.size(30.dp)
                    )
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    "Tổng cộng:",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.W700,
                   
                    color = Color(0xFF808080)
                )
                Text(
                    "$95.00",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.W700,
                    
                    color = Color.Black,
                    textAlign = TextAlign.Right
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            /////
            Button(
                onClick = {  },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp),
                colors = ButtonDefaults.buttonColors(Color(0xFF242424)),
                shape = RoundedCornerShape(10.dp),
            ) {
                Text(
                    text = "Check out",
                    fontSize = 22.sp,
                  
                    fontWeight = FontWeight.W600
                )
            }
            Spacer(modifier = Modifier.height(25.dp))
        }
    }
}