package com.example.asmkotlinph42448

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.toColorInt



class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MainTheme {
                WelcomeScreen()
            }
        }
    }
}

@Composable
fun MainTheme(content: @Composable () -> Unit) {
    Surface(color = MaterialTheme.colorScheme.background) {
        content()
    }
}


// ----- Welcome -------
@Composable
fun WelcomeScreen() {
    val context = LocalContext.current
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.welcome),
            contentDescription = "Welcome Image",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        Column(
            modifier = Modifier
                .align(Alignment.Center)
                .padding(20.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text(
                text = "MAKE YOUR",
                color = Color.Gray,
                fontWeight = FontWeight.Normal,
                fontSize = 30.sp,
                fontFamily = FontFamily.Serif,
                modifier = Modifier.offset(x = 0.dp, y = -70.dp)
            )
            Text(
                text = "HOME BEAUTIFUL",
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                fontSize = 35.sp,
                fontFamily = FontFamily.Serif,
                modifier = Modifier.offset(x = 0.dp, y = -70.dp)
            )
            Text(
                text = "The best simple place where you \ndiscover most wonderful furnitures \nand make your home beautiful",
                color = Color.Gray,
                fontWeight = FontWeight.Normal,
                fontSize = 20.sp,
                modifier = Modifier.offset(x = 20.dp, y = -70.dp)
            )

            Button(
                modifier = Modifier
                    .fillMaxWidth(0.5f)
                    .height(48.dp)
                    .offset(x = 90.dp, y = 130.dp),
                shape = RoundedCornerShape(0.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color("#242424".toColorInt())),
                onClick = {
                    val intent = Intent(context, DangNhap::class.java)
                    context.startActivity(intent)
                }
            ) {
                Text(
                    text = "Get Started",
                    color = Color.White
                )
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MainTheme {
        WelcomeScreen(

        )
    }
}