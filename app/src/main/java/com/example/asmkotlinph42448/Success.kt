package com.example.asmkotlinph42448

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview


class Success : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            SuccessScreen()

        }
    }
}


@Composable
fun SuccessScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "SUCCESS!",
            fontSize = 40.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(16.dp))


        Box(
            modifier = Modifier
                .size(320.dp)
                .background(Color.White.copy(alpha = 0.2f))


        ){
            Image(
                painter = painterResource(id = R.drawable.bed),
                contentDescription = "",
                modifier = Modifier
                    .height(300.dp)
                    .width(250.dp)
                    .align(Alignment.Center)
            )

        }
        Image(
            painter = painterResource(id = R.drawable.bell),
            contentDescription = "",
            modifier = Modifier
                .height(50.dp)
                .width(50.dp)

        )
        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Your order will be delivered soon.\nThank you for choosing our app!",
            fontSize = 16.sp,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = { /* TODO: Navigate to orders screen */ },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp)
                .height(60.dp)
                .shadow(8.dp, RoundedCornerShape(10.dp))
                .width(180.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color.Black)


        ) {
            Text(text = "Track your orders")
        }

        OutlinedButton(
            onClick = { /* TODO: Navigate back to home screen */ },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp)
                .height(60.dp)
                .width(180.dp)

        ) {
            Text(text = "BACK TO HOME")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SuccessScreenPreview() {

    SuccessScreen()

}
