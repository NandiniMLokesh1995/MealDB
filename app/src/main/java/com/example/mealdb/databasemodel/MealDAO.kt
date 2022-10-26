package com.example.mealdb.databasemodel

import androidx.room.Dao
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface MealDAO {
    @Query("SELECT * FROM meal_data_table")
    fun getListOfMeals(): Flow<List<MealEntity>>
}