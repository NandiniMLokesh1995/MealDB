package com.example.mealdb.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mealdb.databasemodel.CategoryEntity
import com.example.mealdb.databasemodel.MealList
import com.example.mealdb.networkmodel.MealRetroRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MealVewModelRetro(val repository: MealRetroRepository) : ViewModel() {

    var categories = MutableLiveData<CategoryEntity>()
    var mealsList = MutableLiveData<MealList>()
    var mealsListInst = MutableLiveData<MealList>()
    var mealsId = MutableLiveData<String>()
    var TAG="MealVewModelRetro"

    fun getMealCategories() {
        CoroutineScope(Dispatchers.IO).launch {
            val response:CategoryEntity = repository.getAllCat()
            Log.d(TAG, "getMealCategories: "+response.categories)
            withContext(Dispatchers.Main) {
                Log.d(TAG, "getMealCategories: ")
                if (response.categories!=null) {
                    categories.postValue(response)

                } else {

                }

            }
        }
    }

    fun getMealListForCategory(catName:String) {
        CoroutineScope(Dispatchers.IO).launch {
            val response:MealList = repository.getAllMealsForCategory(catName)
            Log.d(TAG, "MealList: "+response.meals)
            withContext(Dispatchers.Main) {
                //Log.d(TAG, "MealList: ")
                if (response.meals!=null) {
                    mealsList.postValue(response)

                } else {

                }

            }
        }
    }

    fun getInsructionForMeal(idMeal: String) {
        CoroutineScope(Dispatchers.IO).launch {
            val response:MealList = repository.getInstructionForMeal(idMeal)
            Log.d(TAG, "getItemsInst: "+response.meals)
            withContext(Dispatchers.Main) {
                Log.d(TAG, "getMealCategories: ")
                if (response.meals!=null) {
                    mealsListInst.postValue(response)

                } else {

                }

            }
        }
    }
}