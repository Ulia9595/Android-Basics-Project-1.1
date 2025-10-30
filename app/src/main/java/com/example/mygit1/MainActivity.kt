package com.example.mygit1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mygit1.ui.theme.MyGit1Theme

val color1 = Color(0xFFEADDFF)
val color2 = Color(0xFFD0BCFF)
val color3 = Color(0xFFB69DF8)
val color4 = Color(0xFFF6EDFF)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyGit1Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    QuadrantsScreen()
                }
            }
        }
    }
}

@Composable
fun ComposableCard(
    header: String,
    body: String,
    backgroundColor: Color,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(backgroundColor)
            .padding(16.dp),

        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = header,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp),
            textAlign = TextAlign.Center
        )
        Text(
            text = body,
            modifier = Modifier,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun QuadrantsScreen() {
    Column(Modifier.fillMaxSize()) {

        Row(
            Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.5f)
        ) {
            ComposableCard(
                header = stringResource(R.string.header_1),
                body = stringResource(R.string.text_1),
                backgroundColor = color1,
                modifier = Modifier.fillMaxWidth(0.5f)
            )
            ComposableCard(
                header = stringResource(R.string.header_2),
                body = stringResource(R.string.text_2),
                backgroundColor = color2,
                modifier = Modifier.fillMaxWidth(1f)
            )
        }

        Row(
            Modifier
                .fillMaxWidth()
                .fillMaxHeight(1f)
        ) {
            ComposableCard(
                header = stringResource(R.string.header_3),
                body = stringResource(R.string.text_3),
                backgroundColor = color3,
                modifier = Modifier.fillMaxWidth(0.5f)
            )
            ComposableCard(
                header = stringResource(R.string.header_4),
                body = stringResource(R.string.text_4),
                backgroundColor = color4,
                modifier = Modifier.fillMaxWidth(1f)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun QuadrantsPreview() {
    MyGit1Theme {
        QuadrantsScreen()
    }
}
