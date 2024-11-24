package io.github.atharvamahamuni.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import io.github.atharvamahamuni.lemonade.ui.theme.LemonadeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LemonadeTheme {
                LemonadeApp()
            }
        }
    }
}

@Composable
fun LemonadeImageAndText(
    modifier: Modifier = Modifier
        .fillMaxSize()
        .wrapContentSize(Alignment.Center)
) {
    var sequenceNumber by remember { mutableIntStateOf(1) }
    val resultImage = when (sequenceNumber) {
//        0 ->  R.drawable.lemon_tree
        1 ->  R.drawable.lemon_tree
        2 ->  R.drawable.lemon_squeeze
        3 ->  R.drawable.lemon_drink
        else ->  R.drawable.lemon_restart
    }

    val captionText = when (sequenceNumber) {
        1 ->  "Tap the lemon tree to select a lemon"
        2 ->  "Keep tapping the lemon to squeeze it"
        3 ->  "Tap the lemonade to drink it"
        else ->  "Tap the empty glass to start again"
    }

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = {
            sequenceNumber = (sequenceNumber + 1) % 4
        }) {
            Image(
                painter = painterResource(resultImage),
                contentDescription = sequenceNumber.toString(),
                modifier = Modifier.padding(16.dp)
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = captionText)
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun LemonadeApp() {
    LemonadeTheme {
        LemonadeImageAndText()
    }
}