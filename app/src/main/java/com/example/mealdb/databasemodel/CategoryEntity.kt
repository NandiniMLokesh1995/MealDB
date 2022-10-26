package com.example.mealdb.databasemodel

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


data class CategoryEntity(var categories: List<Category> )
@Entity(tableName = "category_data_table")
data class Category(
    @PrimaryKey
    @ColumnInfo(name = "cat_id")
    var idCategory: String,
    @ColumnInfo(name = "catg_name")
    var strCategory: String,
    @ColumnInfo(name = "catg_thumb")
    var strCategoryThumb: String,
    @ColumnInfo(name = "catg_desc")
    var strCategoryDescription: String
)

