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
    var strMealThumb: String,
    @ColumnInfo(name = "meal_catg")
    var strCategory: String,
    @ColumnInfo(name = "meal_area")
    var strArea: String,
    @ColumnInfo(name = "meal_inst")
    var strInstructions: String,
    @ColumnInfo(name = "meal_youtube")
    var strYoutube: String,
    @ColumnInfo(name = "meal_ing1")
    var strIngredient1: String,
    @ColumnInfo(name = "meal_ing2")
    var strIngredient2: String,
    @ColumnInfo(name = "meal_ing3")
    var strIngredient3: String,
    @ColumnInfo(name = "meal_ing4")
    var strIngredient4: String,
    @ColumnInfo(name = "meal_ing5")
    var strIngredient5: String
    )
