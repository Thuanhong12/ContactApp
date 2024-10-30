package com.example.contactapp

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument

sealed class NavRoute(val route:String){
    object LIST_SCREEN:NavRoute("contactlist")
    object DETAIL_SCREEN:NavRoute("contactDetail")
}
@Composable
fun NavigationGraph(navController: NavHostController){
    NavHost(navController = navController, startDestination = NavRoute.LIST_SCREEN.route) {
        composable(NavRoute.LIST_SCREEN.route) {
            ContactListScreen(navController)
        }
        composable(NavRoute.DETAIL_SCREEN.route+"?id={id}",
        arguments= listOf(navArgument("id") { nullable=true })
        ){
            var id=it.arguments?.getString("id")
            if (id!=null){
                ContactDetailScreen(navController = navController,id.toInt())
            }
            else{
                ContactDetailScreen(navController = navController)
            }
        }
    }
}
