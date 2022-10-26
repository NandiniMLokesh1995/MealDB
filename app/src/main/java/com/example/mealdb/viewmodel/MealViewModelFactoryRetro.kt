package com.example.mealdb.viewmodel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mealdb.networkmodel.MealRetroRepository

class MealViewModelFactoryRetro(private val repository: MealRetroRepository): ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(MealVewModelRetro::class.java)) {
            return MealVewModelRetro(repository) as T
        }

        throw IllegalArgumentException("Illegal argument Exception")
    }

}