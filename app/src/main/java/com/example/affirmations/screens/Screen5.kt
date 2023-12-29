package com.example.affirmations.screens

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.affirmations.R
import com.example.affirmations.data.Datasource
import com.example.affirmations.model.Fitness

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Screen5(navController: NavController){
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = stringResource(R.string.screen5),
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth()
                    )
                },
                navigationIcon = {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = null,
                        modifier = Modifier.clickable {
                            navController.popBackStack()
                        }
                    )
                }
            )
        }
    ) {
        ListFitness(
            listFitness = Datasource().loadFitness(),
            contentPadding = it
        )
    }
}

@Composable
private fun ListFitness(listFitness: List<Fitness>, contentPadding: PaddingValues, modifier: Modifier = Modifier){
    LazyColumn(
        modifier = modifier,
        contentPadding = contentPadding
    ){
        items(listFitness){
            ItemFitness(
                fitness = it
            )
        }
    }
}

@Composable
private fun ItemFitness(fitness: Fitness, modifier: Modifier = Modifier){
    var showDescription by remember { mutableStateOf(false) }
    Card(
        modifier = modifier
            .padding(horizontal =  16.dp, vertical = 4.dp)
            .animateContentSize(
                animationSpec = spring(
                    dampingRatio = Spring.DampingRatioMediumBouncy,
                    stiffness = Spring.StiffnessVeryLow
                )
            )
            .clickable {
                showDescription = !showDescription
            },
        shape = MaterialTheme.shapes.small
    ){
        Column(
            modifier = Modifier.padding(12.dp)
        ){
            Text(
                text = stringResource(fitness.dayRes),
                style = MaterialTheme.typography.displayMedium
            )
            Text(
                text = stringResource(fitness.nameRes),
                style = MaterialTheme.typography.bodyLarge
            )
            Image(
                painter = painterResource(fitness.imageRes),
                contentDescription = stringResource(fitness.nameRes),
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
            )
            if(showDescription){
                Text(
                    text = stringResource(fitness.descriptionRes),
                    style = MaterialTheme.typography.bodyLarge
                )
            }
        }
    }
}