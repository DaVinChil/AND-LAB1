package ru.ns.laba1

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.interaction.DragInteraction
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import ru.ns.laba1.ui.theme.LABA_1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LABA_1Theme {
                Start()
            }
        }
    }
}

@Composable
fun Start(modifier: Modifier = Modifier) {
    val context = LocalContext.current as Activity
    val extras = context.intent.extras

    if (extras == null || !extras.containsKey("name")) {
        val intent = Intent(context, MainActivity2::class.java)
        intent.putExtra("greet", "Welcome, dear friend!")
        context.startActivity(intent);
    } else {
        val name = extras.getString("name")

        Box(modifier = Modifier.fillMaxSize()) {
            Text(
                text = "Hello, $name",
                modifier = Modifier.align(Alignment.Center),
                fontSize = 40.sp,
                fontStyle = FontStyle.Italic,
                fontWeight = FontWeight.Black,
                color = Color.Magenta
            )
        }
    }
}