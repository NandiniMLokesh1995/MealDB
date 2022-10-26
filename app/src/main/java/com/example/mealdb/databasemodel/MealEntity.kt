package com.example.mealdb.databasemodel

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

data class MealList(var meals: List<MealEntity> )

@Entity(tableName = "meal_data_table")
data class MealEntity(
    @PrimaryKey
    @ColumnInfo(name = "meal_id")
    var idMeal: String,

    @ColumnInfo(name = "meal_name")
    var strMeal: String,

    @ColumnInfo(name = "meal_thumb")
    var strMealThumb: String
    )
