package com.example.affirmations.navigation

sealed class AppRoutes(val route: String){
    object Screen1: AppRoutes("Screen1")
    object Screen2: AppRoutes("Screen2")
    object Screen3: AppRoutes("Screen3")
    object Screen4: AppRoutes("Screen4")
    object Screen5: AppRoutes("Screen5")
}