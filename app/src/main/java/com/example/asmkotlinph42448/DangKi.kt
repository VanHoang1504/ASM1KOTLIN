package com.example.asmkotlinph42448

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SmallTopAppBar
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.toColorInt
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.compose.rememberNavController

class DangKi : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent() {
            SignupScreen()
        }

    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "RememberReturnType")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignupScreen() {
    val context = LocalContext.current

    var nameValue by remember { mutableStateOf("") }
    var emailValue by remember { mutableStateOf("") }
    var passwordValue by remember { mutableStateOf("") }
    var repasswordValue by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }
    var repasswordVisible by remember { mutableStateOf(false) }

    Scaffold(
        topBar = @androidx.compose.runtime.Composable {
            SmallTopAppBar(
                title = { Text("Sign Up") },
                navigationIcon = {
                    IconButton(onClick = {}) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Back"
                        )
                    }
                },
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.surface,
                    titleContentColor = MaterialTheme.colorScheme.onSurface
                )
            )
        }
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White),
            contentAlignment = Alignment.Center
        ) {

            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "Your image description",
                modifier = Modifier
                    .fillMaxSize(0.2f)
                    .offset(x = 0.dp, y = -300.dp)
            )

            Text(
                text = "Welcome !",
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                fontSize = 30.sp,
                fontFamily = FontFamily.Serif,
                modifier = Modifier.offset(x = -90.dp, y = -190.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))

            TextField(
                value = nameValue,
                onValueChange = { emailValue = it },
                label = { Text("Name") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
                    .offset(x = 0.dp, y = -120.dp),

                )

            Spacer(modifier = Modifier.height(16.dp))

            TextField(
                value = emailValue,
                onValueChange = { emailValue = it },
                label = { Text("Email") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
                    .offset(x = 0.dp, y = -40.dp),

                )

            Spacer(modifier = Modifier.height(16.dp))

            TextField(
                value = passwordValue,
                onValueChange = { passwordValue = it },
                label = { Text("Password") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
                    .offset(x = 0.dp, y = 40.dp),
                visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                trailingIcon = {
                    IconButton(onClick = { passwordVisible = !passwordVisible }) {
                        Icon(
                            painter = painterResource(id = if (passwordVisible) R.drawable.eye1 else R.drawable.eye),
                            contentDescription = if (passwordVisible) "Hide password" else "Show password"
                        )
                    }
                }
            )

            Spacer(modifier = Modifier.height(16.dp))

            TextField(
                value = repasswordValue,
                onValueChange = { passwordValue = it },
                label = { Text("Confirm Password") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
                    .offset(x = 0.dp, y = 120.dp),
                visualTransformation = if (repasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                trailingIcon = {
                    IconButton(onClick = { repasswordVisible = !repasswordVisible }) {
                        Icon(
                            painter = painterResource(id = if (repasswordVisible) R.drawable.eye1 else R.drawable.eye),
                            contentDescription = if (repasswordVisible) "Hide password" else "Show password"
                        )
                    }
                }
            )

            Button(
                modifier = Modifier
                    .fillMaxWidth(0.9f)
                    .height(48.dp)
                    .offset(x = 1.5.dp, y = 200.dp),
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color("#242424".toColorInt())),
                onClick = {
                    val intent = Intent(context, DangNhap::class.java)
                    context.startActivity(intent)
                }
            ) {
                Text(
                    text = "SIGN UP",
                    color = Color.White,
                    fontWeight = FontWeight.SemiBold
                )
            }

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
                    .offset(x = 0.dp, y = 240.dp),
                contentAlignment = Alignment.Center
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "Already hava account ?",
                        modifier = Modifier.padding(end = 0.dp)
                    )
                    TextButton(
                        onClick = {
                            val intent = Intent(context, DangNhap::class.java)
                            context.startActivity(intent)
                        }
                    ) {
                        Text(
                            text = "SIGN IN",
                            color = Color.Black
                        )
                    }
                }
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun PreviewLayout1(){
    SignupScreen()
}