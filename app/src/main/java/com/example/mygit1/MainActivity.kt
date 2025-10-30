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
                        stringResource(R.string.header),
                        stringResource(R.string.subparagraph_f),
                        stringResource(R.string.subparagraph_s)
                    )
                }
            }
        }
    }
}

@Composable
fun GreetingText(header: String, subparagraph_f: String, subparagraph_s: String, modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start,
        modifier = modifier.background(Color.White)
    ) {
        Text(
            text = header,
            fontSize = 24.sp,
            textAlign = TextAlign.Left,
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        )
        Text(
            text = subparagraph_f,
            textAlign = TextAlign.Justify,
            modifier = Modifier
                .padding(start = 16.dp, end = 16.dp)
                .fillMaxWidth()
        )
        Text(
            text = subparagraph_s,
            textAlign = TextAlign.Justify,
            modifier = Modifier
                .padding(16.dp)
        )
    }
}

@Composable
fun GreetingImage(header: String, subparagraph_f: String, subparagraph_s: String, modifier: Modifier = Modifier) {
    Column(modifier = Modifier.fillMaxSize().fillMaxWidth()) {
        Image(
            painter = painterResource(id = R.drawable.bg_compose_background),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .weight(1f)
        )
        GreetingText(
            header = header,
            subparagraph_f = subparagraph_f,
            subparagraph_s = subparagraph_s,
            modifier = Modifier
                .weight(3f)
        )
    }
}

@Preview(showBackground = false)
@Composable
private fun BirthdayCardPreview() {
    MyGit1Theme {
        GreetingImage(
            stringResource(R.string.header),
            stringResource(R.string.subparagraph_f),
            subparagraph_s = stringResource(R.string.subparagraph_s)
        )
    }
}