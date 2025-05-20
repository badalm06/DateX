package com.dating.datexapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.dating.datexapp.ui.navigation.AppNavGraph
import com.dating.datexapp.ui.screens.InterestScreen
import com.dating.datexapp.ui.theme.DatexandroidappTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DatexandroidappTheme {
                val navController = rememberNavController()
                AppNavGraph(navController = navController)
            }
        }
    }
}


@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    DatexandroidappTheme {
        Greeting("Android")
    }
}