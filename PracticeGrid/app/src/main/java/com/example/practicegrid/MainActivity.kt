package com.example.practicegrid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.practicegrid.data.DataSource
import com.example.practicegrid.model.Topic
import com.example.practicegrid.ui.theme.PracticeGridTheme
import javax.sql.CommonDataSource

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PracticeGridTheme {
                // A surface container using the 'background' color from the theme
                    
                    GridList(listTopic = DataSource.topics,
                        modifier = Modifier.padding(10.dp)
                        )
                }
        }
    }
}

@Composable
fun GridCard(topic: Topic, modifier: Modifier = Modifier){
    Card{
       Row() {
           Image(painter = painterResource(topic.imageRes),
               contentDescription = stringResource(topic.name))
          Column(
              modifier.padding(8.dp)
          ) {
              Text(text = stringResource(topic.name))
              Text(text = topic.availableCourses.toString())
          }
       }
    }
}

@Composable
fun GridList(listTopic: List<Topic>,modifier: Modifier = Modifier){

    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        verticalArrangement = Arrangement.spacedBy(4.dp),
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        modifier = modifier
        ){
        items(listTopic){ topic ->
            GridCard(topic)
        }
    }
}

@Composable
@Preview
fun GridPreview(){
    //GridCard(Topic(R.string.architecture,58,R.drawable.architecture))

    GridList(listTopic = DataSource.topics)
}