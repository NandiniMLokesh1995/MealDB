package com.example.mealdb.viewmodel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mealdb.databasemodel.MealRepository

class MealViewModelFactoryRealm(private val repository: MealRepository): ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(MealVewModelRealm::class.java)) {
            return MealVewModelRealm(repository) as T
        }

        throw IllegalArgumentException("Illegal argument Exception")
    }

}