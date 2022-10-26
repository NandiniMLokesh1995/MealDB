package com.example.mealdb.networkmodel

class MealRetroRepository(private val retrofitService: RetrofitService) {
    suspend fun getAllCat() = retrofitService.getAllMealCategory()
    suspend fun getAllMealsForCategory(catName: String) = retrofitService.getMealForCategory(catName)
}