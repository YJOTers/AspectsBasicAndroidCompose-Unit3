package com.example.affirmations.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.affirmations.screens.Screen1
import com.example.affirmations.screens.Screen2
import com.example.affirmations.screens.Screen3
import com.example.affirmations.screens.Screen4
import com.example.affirmations.screens.Screen5

@Composable
fun AppNavigation(){
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = AppRoutes.Screen1.route
    ){
        composable(route = AppRoutes.Screen1.route){
            Screen1(navController)
        }
        composable(route = AppRoutes.Screen2.route){
            Screen2(navController)
        }
        composable(route = AppRoutes.Screen3.route){
            Screen3(navController)
        }
        composable(route = AppRoutes.Screen4.route){
            Screen4(navController)
        }
        composable(route = AppRoutes.Screen5.route){
            Screen5(navController)
        }
    }
}