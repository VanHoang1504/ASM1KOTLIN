package com.example.asmkotlinph42448

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
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

data class Danhsach(val text1: String, val text2: String)

class Profile : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LOProfile()
        }
    }
}

@Preview
@Composable
fun LOProfile() {
    val context = LocalContext.current
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        TopBar(
            title = "Profile",
            icon = R.drawable.search,
            icon2 = R.drawable.logo,
            onClickButtontTrai = {})
        val danhsach = listOf(
            Danhsach("My orders", "Already have 10 orders"),
            Danhsach("Shipping Addresses", "03 Addresses"),
            Danhsach("Payment Method", "You have 2 cards"),
            Danhsach("My reviews", "Reviews for 5 items"),
            Danhsach("Settings", "Notification, Password, FAQ, Contact"),
        )
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 10.dp)
        ) {
            item {Cuc1()
                Spacer(modifier = Modifier.height(20.dp))
            }
            items(danhsach) { ds ->
                ItemCuc2(
                    text1 = ds.text1,
                    text2 = ds.text2,
                    modifier = Modifier
                        .padding(vertical = 8.dp)
                        .shadow(4.dp, RoundedCornerShape(4.dp), spotColor = Color(0xDFC7C7C7)),
                    onClickItem = {
                        if (ds.text1 === "Settings") {
                            context.startActivity(Intent(context, danhsach::class.java))
                        }
                        if(ds.text1==="My reviews"){
                            context.startActivity(Intent(context, DangNhap::class.java))
                        }
                    }
                )
            }
        }
    }
}

@Composable
fun TopBar(
    title: String,
    icon: Int,
    modifier: Modifier = Modifier,
    icon2: Int?,
    onClickButtontTrai: () -> Unit
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .heightIn(60.dp)
            .padding(horizontal = 20.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        androidx.compose.material3.IconButton(onClick = { onClickButtontTrai() }) {
            Icon(
                painter = painterResource(id = icon),
                contentDescription = "Tìm kiếm",
                tint = Color.Black,
                modifier = Modifier
                    .size(30.dp)
            )
        }
        Text(
            text = title,
            fontSize = 24.sp,
            fontWeight = FontWeight.W700,
            color = Color.Black,
            textAlign = TextAlign.Center,

        )
        icon2?.let {
            androidx.compose.material3.IconButton(onClick = { /* mở màn hình giỏ hàng */ }) {
                Icon(
                    painter = painterResource(id = it),
                    contentDescription = "Giỏ hàng",
                    tint = Color.Black,
                    modifier = Modifier
                        .size(25.dp)
                )
            }
        }
    }
}


@Composable
private fun Cuc1() {
    Row(
        modifier = Modifier
            .padding(vertical = 10.dp, horizontal = 5.dp)
            .fillMaxWidth() // Đảm bảo Row chiếm toàn bộ chiều rộng màn hình
    ) {
        Box(
            modifier = Modifier
                .size(80.dp) // Kích thước của hình ảnh
                .clip(CircleShape) // Làm tròn hình ảnh
                .shadow(elevation = 5.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.bed), // Thay thế bằng hình ảnh của bạn
                contentDescription = null,
                contentScale = ContentScale.Crop, // Đảm bảo ảnh được cắt đúng tỉ lệ
                modifier = Modifier.fillMaxSize() // Để hình ảnh lấp đầy Box
            )
        }
        Column(
            modifier = Modifier
                .align(Alignment.CenterVertically)
                .padding(start = 20.dp)
        ) {
            Text(
                text = "Cao văn Hoàng",

                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                lineHeight = 27.8.sp,
                color = Color.Black
            )
            Text(
                text = "hoangcvph42448@fpt.edu.vn",

                fontWeight = FontWeight.W400,
                fontSize = 14.sp,
                lineHeight = 27.8.sp,
                color = Color.Gray
            )
        }
    }
}

@Composable
private fun ItemCuc2(
    text1: String,
    text2: String,
    modifier: Modifier = Modifier,
    onClickItem: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClickItem)
    ) {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .background(Color.White)
                .heightIn(80.dp)
                .padding(20.dp)
            ,
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text(
                    text = text1,

                    fontWeight = FontWeight.W700,
                    fontSize = 20.sp,
                    lineHeight = 27.8.sp,
                    color = Color.Black
                )
                Text(
                    text = text2,

                    fontWeight = FontWeight.W400,
                    fontSize = 14.sp,
                    lineHeight = 27.8.sp,
                    color = Color.Gray
                )
            }
            Icon(
                painter = painterResource(id = R.drawable.sp1),
                contentDescription = null,
                modifier = Modifier.size(20.dp), tint = Color.Black

            )
        }
    }
}