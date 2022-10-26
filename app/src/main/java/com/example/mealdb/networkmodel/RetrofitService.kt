package com.example.mealdb.networkmodel
import com.example.mealdb.databasemodel.CategoryEntity
import com.example.mealdb.databasemodel.MealList
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitService {

    @GET("categories.php/")
    suspend fun getAllMealCategory() : CategoryEntity

    @GET("filter.php/")
    suspend fun getMealForCategory(@Query("c") catName:String) : MealList
    @GET("lookup.php/")
    suspend fun getInstForMeal(@Query("i") idMeal:String) : MealList

    companion object {
        var baseUrl ="https://www.themealdb.com/api/json/v1/1/"

        var retrofitService: RetrofitService? = null
        fun getInstance() : RetrofitService {
            if (retrofitService == null) {
                val retrofit = Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                retrofitService = retrofit.create(RetrofitService::class.java)
            }
            return retrofitService!!
        }

    }
}