package com.example.app30days

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.app30days.data.DaysRepository.days
import com.example.app30days.model.Days
import com.example.app30days.ui.theme.App30DaysTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            App30DaysTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    DayList()
                }
            }
        }
    }
}

@Composable
fun DayInformation(
    @StringRes title: Int,
    @StringRes description: Int,
    modifier: Modifier = Modifier
){
    Column() {
        Text(text = stringResource(title))
        Text(text = stringResource(description))
    }
}

@Composable
fun DayImage(
    @DrawableRes imgRes: Int,
    modifier: Modifier = Modifier
){
    Box(modifier = modifier.height(200.dp)) {
        Image(
            painter = painterResource(imgRes),
            contentScale = ContentScale.Crop,
            contentDescription = null
        )
    }
}

@Composable
fun DayItem(
    day: Days,
    modifier: Modifier = Modifier
){
    Card(modifier = modifier.padding(5.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)) {
        Column(modifier = modifier
            .padding(16.dp)
            .fillMaxWidth()) {
            DayInformation(title = day.title,
                description = day.description)
            Spacer(modifier = modifier.height(5.dp))
            DayImage(imgRes = day.imgRes)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DayTopAppBar(modifier: Modifier = Modifier){
    CenterAlignedTopAppBar(
        title = {
                Text(text = stringResource(id = R.string.app_name))
        }
        , modifier = modifier)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DayList() {
    Scaffold(
        topBar = { DayTopAppBar() }
    ) { it ->
        LazyColumn(contentPadding = it) {
            items(days) {
                DayItem(
                    day = it,
                    modifier = Modifier.padding(dimensionResource(id = R.dimen.padding_small))
                )
            }
        }
    }
}
@Preview
@Composable
fun GreetingPreview() {
    App30DaysTheme {
//        DayItem(Days(R.string.day1,
//        R.string.description1, R.drawable.day1_bryce_canyon
//            ))
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            DayList()
        }
    }
}