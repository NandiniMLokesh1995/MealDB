package com.example.mealdb.networkmodel

import com.example.mealdb.databasemodel.CategoryEntity
import com.example.mealdb.databasemodel.MealList

class MealRetroRepository(private val retrofitService: RetrofitService) {
    suspend fun getAllCat() : CategoryEntity = retrofitService.getAllMealCategory()
    suspend fun getAllMealsForCategory(catName: String) : MealList = retrofitService.getMealForCategory(catName)
}