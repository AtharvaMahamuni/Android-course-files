package io.github.atharvamahamuni.composearticle

import android.icu.text.CaseMap.Title
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.github.atharvamahamuni.composearticle.ui.theme.ComposeArticleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeArticleTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ArticlePage(
                        title = stringResource(id = R.string.article_title),
                        shortDesc = stringResource(id = R.string.article_short_description),
                        longDesc = stringResource(id = R.string.article_long_description),
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun ArticlePage(title: String, shortDesc: String, longDesc: String, modifier: Modifier = Modifier) {
    Article(title, shortDesc, longDesc, modifier)
}

@Composable
fun Article(title: String, shortDesc: String, longDesc: String, modifier: Modifier = Modifier) {
    val articleImage = painterResource(R.drawable.bg_compose_background)

    Column(modifier = modifier) {
        Image(
            painter = articleImage,
            contentDescription = null
        )
        Text(
            text = title,
            fontSize = 24.sp,
            modifier = modifier
//                .align(alignment = Alignment.CenterHorizontally)
                .padding(paddingValues = PaddingValues(16.dp))
        )
        Text(
            text = shortDesc,
            fontSize = 16.sp,
            textAlign = TextAlign.Justify,
            modifier = modifier
//                .align(alignment = Alignment.CenterHorizontally)
                .padding(paddingValues = PaddingValues(start = 16.dp, end = 16.dp))
        )
        Text(
            text = longDesc,
            fontSize = 16.sp,
            textAlign = TextAlign.Justify,
            modifier = modifier
//                .align(alignment = Alignment.CenterHorizontally)
                .padding(paddingValues = PaddingValues(16.dp))
        )
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun GreetingPreview() {
    ComposeArticleTheme {
        ArticlePage(
            title = stringResource(id = R.string.article_title),
            shortDesc = stringResource(id = R.string.article_short_description),
            longDesc = stringResource(id = R.string.article_long_description),
            modifier = Modifier
        )    }
}