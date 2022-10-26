package com.example.mealdb.view

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.mealdb.databasemodel.Category
import com.example.mealdb.databinding.ActivityMainBinding
import com.example.mealdb.networkmodel.MealRetroRepository
import com.example.mealdb.networkmodel.RetrofitService
import com.example.mealdb.viewmodel.MealVewModelRetro
import com.example.mealdb.viewmodel.MealViewModelFactoryRetro

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var catgAdapter:  CategoryItemAdpter
    var retrofitService: RetrofitService= RetrofitService.getInstance()
    lateinit var mealVewModelRetro: MealVewModelRetro
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.labelCategory.text="Meal Categories"
        mealVewModelRetro = ViewModelProvider(this,
            MealViewModelFactoryRetro(MealRetroRepository(retrofitService)))
            .get(MealVewModelRetro::class.java)

        mealVewModelRetro.getMealCategories()

        catgAdapter = CategoryItemAdpter()
        binding.recyclerview.adapter=catgAdapter

        mealVewModelRetro.categories.observe(this, Observer {
            catgAdapter.setData(it.categories)
            catgAdapter.notifyDataSetChanged()

        })
        catgAdapter!!.setOnItemClickListener(object : ClickListener<Category> {
            override fun onClick(view: View?, data: Category, position: Int) {
                mealVewModelRetro.getMealListForCategory(data.strCategory)
                Toast.makeText(
                    applicationContext, """"Position = ${position.inc()} Category= ${data.strCategory} """, Toast.LENGTH_SHORT
                ).show()
            }
        })



    }
}

