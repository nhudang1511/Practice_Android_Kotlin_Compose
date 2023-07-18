package com.example.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lemonade.ui.theme.LemonadeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonadeTheme {
                // A surface container using the 'background' color from the theme
                LemonadeApp()
            }
        }
    }
}

@Composable
fun LemonadeApp(modifier: Modifier = Modifier){
    var currentStep by remember { mutableStateOf(1) }
    var squeezeCount by remember { mutableStateOf(0) }
   Surface(color = MaterialTheme.colors.background) {
       when(currentStep){
           1 -> {
               Column(modifier = Modifier
                   .fillMaxSize()
                   .wrapContentSize(),
                   horizontalAlignment = Alignment.CenterHorizontally,
                   verticalArrangement = Arrangement.Center) {
                   Text(stringResource(id = R.string.action1))
                   Spacer(modifier = Modifier.padding(16.dp))
                   Image(
                       painter = painterResource(R.drawable.lemon_tree),
                       contentDescription = R.string.picture1.toString(),
                       modifier = Modifier.clickable {
                           currentStep = 2
                           squeezeCount = (2..4).random()
                       }
                   )
               }
           }
           2 -> {
               Column(modifier = Modifier
                   .fillMaxSize()
                   .wrapContentSize(),
                   horizontalAlignment = Alignment.CenterHorizontally,
                   verticalArrangement = Arrangement.Center) {
                   Text(stringResource(id = R.string.action2))
                   Spacer(modifier = Modifier.padding(16.dp))
                   Image(
                       painter = painterResource(R.drawable.lemon_squeeze),
                       contentDescription = R.string.picture2.toString(),
                       modifier = Modifier.clickable {
                           squeezeCount--
                           if(squeezeCount == 0){
                               currentStep = 3
                           }

                       }
                   )
               }
           }
           3 -> {
               Column(modifier = Modifier
                   .fillMaxSize()
                   .wrapContentSize(),
                   horizontalAlignment = Alignment.CenterHorizontally,
                   verticalArrangement = Arrangement.Center) {
                   Text(stringResource(id = R.string.action3))
                   Spacer(modifier = Modifier.padding(16.dp))
                   Image(
                       painter = painterResource(R.drawable.lemon_drink),
                       contentDescription = R.string.picture3.toString(),
                       modifier = Modifier.clickable {
                           currentStep = 4
                       }
                   )
               }
           }
           4 -> {
               Column(modifier = Modifier
                   .fillMaxSize()
                   .wrapContentSize(),
                   horizontalAlignment = Alignment.CenterHorizontally,
                   verticalArrangement = Arrangement.Center) {
                   Text(stringResource(id = R.string.action4))
                   Spacer(modifier = Modifier.padding(16.dp))
                   Image(
                       painter = painterResource(R.drawable.lemon_restart),
                       contentDescription = R.string.picture4.toString(),
                       modifier = Modifier.clickable {
                           currentStep = 1
                       }
                   )
               }
           }
       }
   }
}

@Composable
@Preview
fun LemonadePreview(){
    LemonadeApp()
}