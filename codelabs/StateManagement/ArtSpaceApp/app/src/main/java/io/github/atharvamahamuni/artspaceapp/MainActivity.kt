package io.github.atharvamahamuni.artspaceapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import io.github.atharvamahamuni.artspaceapp.ui.theme.ARTSpaceAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ARTSpaceAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ArtSpace (
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun ArtSpace(modifier: Modifier = Modifier) {

    var count by remember { mutableStateOf(1) }
    var image = painterResource(id = R.drawable.car)
    var quote = "This is the quote 1"
    var author = "Click 1"

    when (count) {
        1 -> {
            image = painterResource(id = R.drawable.car)
            quote = "Noice car"
            author = "Car"
        } 2 -> {
            image = painterResource(id = R.drawable.van)
            quote = "Noice van"
            author = "Van"
        } 3 -> {
            image = painterResource(id = R.drawable.home)
            quote = "Noice click"
            author = "Click"
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF7F7F7)) // Light background color
            .padding(16.dp)
    ) {

        Spacer(modifier = Modifier.height(2.dp)) // Space at the top

        Box(
            modifier = Modifier
                .fillMaxWidth(1f)
                .aspectRatio(3f / 4f)
                .weight(1f) // Take most of the available space
                .background(Color.White, shape = RoundedCornerShape(16.dp))
                .padding(2.dp),
            contentAlignment = Alignment.Center,
        ) {
            Image(
                painter = image, // Replace with your image
                contentDescription = "randomImage",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth(.8f) // Adjust size as needed
                    .aspectRatio(3f / 4f) // Aspect ratio of the image
            )
        }

        Spacer(modifier = Modifier.height(16.dp)) // Space between sections

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
//            verticalArrangement = Arrangement.Center,
//            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = quote,
                style = MaterialTheme.typography.titleMedium,
                color = Color.Black,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
            Spacer(modifier = Modifier.height(12.dp))
            Text(
                text = author,
                style = MaterialTheme.typography.bodyMedium,
                color = Color.Gray
            )

            Spacer(modifier = Modifier.height(12.dp))
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(
                onClick = {
                    count++
                    if (count > 3) {
                        count = 1
                    }
                },
                colors = ButtonDefaults.buttonColors(contentColor = Color(0xFF5E5E91)),
                modifier = Modifier
                    .weight(1f)
                    .padding(end = 8.dp)
            ) {
                Text(text = "Previous", color = Color.White)
            }
            Button(
                onClick = {
                    count--
                    if (count < 1) {
                        count = 3
                    }
                },
                colors = ButtonDefaults.buttonColors(contentColor = Color(0xFF5E5E91)),
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 8.dp)
            ) {
                Text(text = "Next", color = Color.White)
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
    }

}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun GreetingPreview() {
    ARTSpaceAppTheme {
        ArtSpace()
    }
}