package com.example.lemonada

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lemonada.ui.theme.LemonadaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonadaTheme {
                AppLemonade()
            }
        }
    }
}

@Composable
fun AppLemonade() {

    Header()

    var currentStep by remember { mutableStateOf(1) }

    val imageResource = when (currentStep) {
        1 -> LemonadeImageAndText(R.drawable.lemon_tree, R.string.lemon_tree_content_description, onImageClick = { currentStep++ })
        2 -> LemonadeImageAndText(R.drawable.lemon_squeeze, R.string.Lemon_content_description, onImageClick = { currentStep++ })
        3 -> LemonadeImageAndText(R.drawable.lemon_drink, R.string.glass_of_lemonade_content_description, onImageClick = { currentStep++ })
        else -> LemonadeImageAndText(R.drawable.lemon_restart, R.string.empty_glass_content_description, onImageClick = { currentStep = 1 })
    }


}


@Composable
fun Header(
    modifier: Modifier = Modifier
) {
    Box {
        Text(
            text = "Lemonade",
            modifier
                .background(Color.Yellow)
                .fillMaxWidth()
                .padding(16.dp)
                .align(alignment = Alignment.TopCenter),
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun LemonadeImageAndText(
    drawableResourceId: Int,
    textLabelResourceId: Int,
    onImageClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box {
        Column(
            modifier
                .fillMaxSize()
                .align(alignment = Alignment.Center),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image (
                painter = painterResource(drawableResourceId), //Se pasa el id de la imagen
                contentDescription = null,
                modifier
                    .clickable(onClick = onImageClick)
                    .clip(RoundedCornerShape(16.dp))
                    .background(Color.Cyan)
                    .padding(64.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = stringResource(textLabelResourceId), //Se pasa el id del texto
                fontSize = 18.sp
            )

            }
        }
    }

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LemonadaTheme {
        AppLemonade()
    }
}