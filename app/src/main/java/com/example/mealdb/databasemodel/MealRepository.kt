package com.example.mealdb.databasemodel

class MealRepository(private val mDao: MealDAO) {
    val mealList = mDao.getListOfMeals()
}