package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    ImageGallery()
                }
            }
        }
    }
}


@Composable
fun ImageGallery(){
    val firstArt = R.drawable.lemon_tree;
    val secondArt = R.drawable.lemon_drink;
    val thirdArt = R.drawable.lemon_squeeze;
    val fourthArt = R.drawable.lemon_restart;
    var currentArt by remember {
        mutableStateOf(firstArt)
    }
    var currentTitle by remember {
        mutableStateOf(R.string.first_title)
    }
    var currentArticle by remember {
        mutableStateOf(R.string.first_article)
    }
   Column(modifier = Modifier
       .wrapContentSize()
       .fillMaxSize(),
       verticalArrangement = Arrangement.Center,
       horizontalAlignment = Alignment.CenterHorizontally
       ) {
       ArtWorkImage(img = currentArt)
       Spacer(modifier = Modifier.height(30.dp))
       Column(horizontalAlignment = Alignment.CenterHorizontally,
           modifier = Modifier
               .width(300.dp)
               .border(BorderStroke(1.dp, Color.Gray))
               .shadow(4.dp, MaterialTheme.shapes.medium)
           ) {
           ArtWorkTitle(currentTitle, currentArticle)
       }
       Spacer(modifier = Modifier.height(30.dp))
       Row(modifier = Modifier.width(250.dp)) {
           Button(
               onClick = {
                         when(currentArt){
                             firstArt ->{
                                 currentArt =fourthArt
                                 currentTitle = R.string.fourth_title
                                 currentArticle = R.string.fourth_article
                             }
                             secondArt ->{
                                 currentArt =firstArt
                                 currentTitle = R.string.first_title
                                 currentArticle = R.string.first_article
                             }
                             thirdArt ->{
                                 currentArt =secondArt
                                 currentTitle = R.string.second_title
                                 currentArticle = R.string.second_article
                             }
                             fourthArt ->{
                                 currentArt =thirdArt
                                 currentTitle = R.string.third_title
                                 currentArticle = R.string.third_article
                             }
                         }
               },
               modifier = Modifier.weight(1f)) {
               Text(text = "Previous")
           }
           Spacer(modifier = Modifier.width(10.dp))
           Button(
               onClick = {
                         when(currentArt){
                             firstArt ->{
                                 currentArt =secondArt
                                 currentTitle = R.string.second_title
                                 currentArticle = R.string.second_article
                             }
                             secondArt ->{
                                 currentArt =thirdArt
                                 currentTitle = R.string.third_title
                                 currentArticle = R.string.third_article
                             }
                             thirdArt ->{
                                 currentArt =fourthArt
                                 currentTitle = R.string.fourth_title
                                 currentArticle = R.string.fourth_article
                             }
                             fourthArt ->{
                                 currentArt =firstArt
                                 currentTitle = R.string.first_title
                                 currentArticle = R.string.first_article
                             }
                         }
               },
               modifier = Modifier.weight(1f)) {
               Text(text = "Next")
           }
       }
   }

}

@Composable
fun ArtWorkTitle(@StringRes title: Int, @StringRes article: Int){
    Text(stringResource(id = title), fontSize = 25.sp)
    Text(stringResource(id = article), fontSize = 13.sp)
}

@Composable
fun ArtWorkImage(@DrawableRes img: Int,
                 modifier: Modifier = Modifier
                     .size(300.dp)
                     .border(BorderStroke(1.dp, Color.Black))
                     ){
    Image(modifier = modifier,
        contentScale = ContentScale.Fit,
        painter = painterResource(img),
        contentDescription = null)
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ArtSpaceTheme {
        ImageGallery()
    }
}