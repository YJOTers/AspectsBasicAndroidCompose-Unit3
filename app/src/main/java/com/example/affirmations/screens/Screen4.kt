package com.example.affirmations.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.affirmations.R
import com.example.affirmations.data.Datasource
import com.example.affirmations.model.Hero
import com.example.affirmations.navigation.AppRoutes

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Screen4(navController: NavController){
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = stringResource(R.string.screen4),
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth()
                    )
                },
                navigationIcon = {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = null,
                        modifier = Modifier.clickable{
                            navController.popBackStack()
                        }
                    )
                },
                actions = {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = null,
                        modifier = Modifier.clickable{
                            navController.navigate(AppRoutes.Screen5.route)
                        }
                    )
                }
            )
        }
    ) {
        ListHero(
            heroes = Datasource().loadHeroes(),
            contentPadding = it
        )
    }
}

@Composable
private fun ListHero(heroes: List<Hero>, modifier: Modifier = Modifier, contentPadding: PaddingValues){
    LazyColumn(
        modifier = modifier,
        contentPadding = contentPadding
    ){
        items(heroes){
            ItemHero(
                hero = it,
                modifier = modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp, horizontal = 16.dp)
            )
        }
    }
}

@Composable
private fun ItemHero(hero: Hero, modifier: Modifier = Modifier){
    Card(
        modifier = modifier,
        shape = MaterialTheme.shapes.small,
        elevation = CardDefaults.cardElevation(2.dp)
    ){
        Row(
            modifier = Modifier.padding(16.dp)
        ){
            DescriptionHero(hero = hero)
            ImageHero(hero = hero)
        }
    }
}

@Composable
private fun DescriptionHero(hero: Hero, modifier: Modifier = Modifier){
    Column(
        modifier = modifier
            .padding(end = 16.dp)
            .width(250.dp)
    ){
        Text(
            text = stringResource(hero.nameRes),
            style = MaterialTheme.typography.displayMedium
        )
        Text(
            text = stringResource(hero.descriptionRes),
            style = MaterialTheme.typography.bodyLarge
        )
    }
}

@Composable
private fun ImageHero(hero: Hero, modifier: Modifier = Modifier){
    Image(
        painter = painterResource(hero.imageRes),
        contentDescription = stringResource(hero.descriptionRes),
        contentScale = ContentScale.Crop,
        modifier = modifier
            .aspectRatio(1f)
            .size(width = 72.dp, height = 72.dp)
            .clip(MaterialTheme.shapes.extraSmall)
    )
}