package com.example.mygit1

import android.graphics.Paint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle.Companion.auto
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mygit1.ui.theme.MyGit1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyGit1Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    GreetingImage(
                        stringResource(R.string.tasks_completed),
                        stringResource(R.string.nice)
                    )
                }
            }
        }
    }
}

@Composable
fun GreetingText(header_1: String, header_2: String, modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        Text(
            text = header_1,
            fontSize = 24.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(start = 24.dp, end = 8.dp)
                .fillMaxWidth()
        )
        Text(
            text = header_2,
            fontSize = 16.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
        )
    }
}

@Composable
fun GreetingImage(header_1: String, header_2: String, modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_task_completed),
            contentDescription = null,
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.CenterHorizontally)
        )
        GreetingText(
            header_1 = header_1,
            header_2 = header_2,
            modifier = Modifier
                .fillMaxWidth()
        )
    }
}

@Preview(showBackground = false)
@Composable
private fun TaskCompletedPreview() {
    MyGit1Theme {
        GreetingImage(
            stringResource(R.string.tasks_completed),
            stringResource(R.string.nice)
        )
    }
}