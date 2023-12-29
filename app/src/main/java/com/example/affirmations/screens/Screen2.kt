package com.example.affirmations.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.affirmations.R
import com.example.affirmations.data.Datasource
import com.example.affirmations.model.Topic
import com.example.affirmations.navigation.AppRoutes

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Screen2(navController: NavController){
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = stringResource(R.string.screen2),
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth()
                    )
                },
                navigationIcon = { Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = null,
                    modifier = Modifier.clickable { navController.popBackStack() }
                )},
                actions = { Icon(
                    imageVector = Icons.Default.ArrowForward,
                    contentDescription = null,
                    modifier = Modifier.clickable { navController.navigate(AppRoutes.Screen3.route) }
                )}
            )
        }
    ) {
        ListTopics(
            listTopic = Datasource().loadTopics(),
            modifier = Modifier.padding(start = 8.dp, end = 8.dp),
            contentPadding = it
        )
    }
}

@Composable
private fun ListTopics(listTopic: List<Topic>, modifier: Modifier = Modifier, contentPadding: PaddingValues){
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_small)),
        horizontalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_small)),
        modifier = modifier,
        contentPadding = contentPadding
    ){
        items(listTopic){ topic ->
            TopicCard(topic)
        }
    }
}

@Composable
private fun TopicCard(topic: Topic, modifier: Modifier = Modifier){
    Card(modifier){
        Row{
            ImageCard(topic)
            DescriptionCard(topic)
        }
    }
}

@Composable
private fun ImageCard(topic: Topic, modifier: Modifier = Modifier){
    Image(
        painter = painterResource(topic.idImage),
        contentDescription = stringResource(topic.idTitle),
        contentScale = ContentScale.Crop,
        modifier = modifier
            .size(height = 68.dp, width = 68.dp)
            .aspectRatio(1f)
    )
}

@Composable
private fun DescriptionCard(topic: Topic, modifier: Modifier = Modifier){
    Column{
        Text(
            text = stringResource(topic.idTitle),
            style = MaterialTheme.typography.bodyMedium,
            modifier = modifier.padding(
                start = 16.dp,
                top = 16.dp,
                end = 16.dp,
                bottom = 8.dp
            )
        )
        Row{
            Icon(
                imageVector = Icons.Default.Favorite,
                contentDescription = null,
                modifier = modifier.padding(
                    start = 16.dp,
                    end = 8.dp
                )
            )
            Text(
                text = topic.numCourses.toString(),
                style = MaterialTheme.typography.labelMedium,
            )
        }
    }
}