package com.example.mygit1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mygit1.ui.theme.MyGit1Theme

val AndroidGreen = Color(0xFF3DDC84)
val DarkGray = Color(0xFF434343)
val LightSurface = Color(0xFFF0FFF5)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MyGit1Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = LightSurface
                ) {
                    BusinessCardScreen()
                }
            }
        }
    }
}

@Composable
fun BusinessCardScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TopSection(
            fullName = "Александра Петрова",
            title = "Android Developer"
        )

        Spacer(Modifier.weight(1f))

        BottomSection(
            phoneNumber = "+1 (234) 567 890",
            socialHandle = "@android_dev_ru",
            email = "alexandra.petrova@android.com"
        )
    }
}

@Composable
fun TopSection(
    fullName: String,
    title: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 150.dp, bottom = 100.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_foreground),
            contentDescription = "Аватар разработчика",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(100.dp)
                .background(AndroidGreen)
        )
        Text(
            text = fullName,
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            color = DarkGray,
            modifier = Modifier.padding(top = 8.dp)
        )
        Text(
            text = title,
            fontSize = 18.sp,
            color = AndroidGreen,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun BottomSection(
    phoneNumber: String,
    socialHandle: String,
    email: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(bottom = 32.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ContactRow(icon = Icons.Default.Phone, content = phoneNumber, iconDescription = "Телефон")
        ContactRow(icon = Icons.Default.Share, content = socialHandle, iconDescription = "Социальная сеть")
        ContactRow(icon = Icons.Default.Email, content = email, iconDescription = "Электронная почта")
    }
}

@Composable
fun ContactRow(icon: ImageVector, content: String, iconDescription: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp, horizontal = 40.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Icon(
            imageVector = icon,
            contentDescription = iconDescription,
            tint = AndroidGreen,
            modifier = Modifier.size(24.dp)
        )
        Spacer(modifier = Modifier.width(16.dp))

        Text(
            text = content,
            color = DarkGray,
            fontSize = 16.sp
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun BusinessCardPreview() {
    MyGit1Theme {
        BusinessCardScreen()
    }
}