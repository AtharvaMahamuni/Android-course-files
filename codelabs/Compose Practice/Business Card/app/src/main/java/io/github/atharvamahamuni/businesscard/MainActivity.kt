package io.github.atharvamahamuni.businesscard

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
import androidx.compose.foundation.layout.fillMaxHeight
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
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import io.github.atharvamahamuni.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BusinessCardTheme {
                Scaffold(modifier = Modifier
                    .fillMaxSize()
                ) { innerPadding ->
                    BusinessCard(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun BusinessCard(name: String, modifier: Modifier = Modifier) {
    Column (
        modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(Color(0xFF7cec9f)),
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        CardMain(name = "Atharva Mahamuni", description = "Android Developer", modifier)
        ContactDetails(phoneNo = "+11 (2312) 213 123", socialHandle = "@athmatwt", email = "atharvamahamuni@outlook.com", modifier)
    }
}

@Composable
fun CardMain(name: String, description: String, modifier: Modifier) {
    val image = painterResource(id = R.drawable.android_logo)
    Column (
        modifier
            .fillMaxWidth()
    ) {
        Image(
            painter = image,
            contentDescription = null,
            modifier = Modifier
                .background(Color(0xFF218f76))
                .width(200.dp)
                .align(Alignment.CenterHorizontally)
        )
        Text(
            text = name,
            modifier = modifier.align(Alignment.CenterHorizontally)
        )
        Text(
            text=description,
            modifier = modifier.align(Alignment.CenterHorizontally)
        )
    }
}

@Composable
fun ContactDetails(phoneNo: String, socialHandle: String, email: String, modifier: Modifier) {
    Column(
        modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Icon(
                imageVector = Icons.Filled.Phone,
                contentDescription = "Phone Icon",
                tint = Color.Black,              // Set color
                modifier = Modifier.size(20.dp) // Set size

            )
            Text(text = phoneNo)
        }
        Row(
            modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Icon(
                imageVector = Icons.Filled.Share,
                contentDescription = "Share Icon",
                tint = Color.Black,              // Set color
                modifier = Modifier.size(20.dp) // Set size

            )
            Text(text = socialHandle)
        }
        Row(
            modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
        ) {
            Icon(
                imageVector = Icons.Filled.Email,
                contentDescription = "Email Icon",
                tint = Color.Black,              // Set color
                modifier = Modifier.size(20.dp), // Set size
            )
            Text(text = email)
        }
    }
}


@Preview(
    showSystemUi = true,
    showBackground = true
)
@Composable
fun BusinessCardPreview() {
    BusinessCardTheme {
        BusinessCard("Android")
    }
}