package com.example.mealdb.databasemodel

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [MealEntity::class], version = 1 )
abstract class MealDatbase : RoomDatabase() {
    @Volatile
    private var mealDatbase:MealDatbase?=null
    fun getMealDatabaseInstance(context: Context):MealDatbase{
        synchronized(this) {
            var instance = mealDatbase
            if (instance == null) {
                instance = Room.databaseBuilder(
                    context.applicationContext,
                    MealDatbase::class.java, "meal_data_database"
                ).build()
            }
            return instance
        }
    }
}