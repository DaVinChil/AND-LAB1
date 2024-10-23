package ru.ns.laba1

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.ns.laba1.ui.theme.LABA_1Theme

class MainActivity2 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LABA_1Theme {
                EnterName()
            }
        }
    }
}

@Composable
fun EnterName(modifier: Modifier = Modifier) {
    val context = LocalContext.current as Activity

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val greeting = context.intent.extras!!.getString("greet")!!
        Text(text = greeting, fontSize = 40.sp, color = Color.Cyan, fontStyle = FontStyle.Italic)

        Spacer(modifier = modifier.height(10.dp))

        var name by remember { mutableStateOf("") }
        TextField(
            value = name,
            onValueChange = { name = it },
            placeholder = { Text(text = "Enter your name") }
        )

        Spacer(modifier = Modifier.height(10.dp))

        Button(
            onClick = {
                val intent = Intent(context, MainActivity::class.java)
                intent.putExtra("name", name)
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                context.startActivity(intent)
                context.finish()
            }
        ) {
            Text("Submit!")
        }
    }
}
