package com.example.mealdb.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.mealdb.databasemodel.Category
import com.example.mealdb.databasemodel.MealEntity
import com.example.mealdb.databinding.FragmentMealListBinding
import com.example.mealdb.networkmodel.MealRetroRepository
import com.example.mealdb.networkmodel.RetrofitService
import com.example.mealdb.viewmodel.MealVewModelRetro
import com.example.mealdb.viewmodel.MealViewModelFactoryRetro

class MealListFragment : Fragment() {


    lateinit var binding: FragmentMealListBinding
    var retrofitService: RetrofitService = RetrofitService.getInstance()
    lateinit var mealVewModelRetro: MealVewModelRetro
    lateinit var mealAdapter:  MealsItemAdpter
    lateinit var catgAdapter:  CategoryItemAdpter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentMealListBinding.inflate(inflater, container, false)
        val view: View =binding.root
        val context = requireContext()

        mealVewModelRetro = ViewModelProvider(this,
            MealViewModelFactoryRetro(MealRetroRepository(retrofitService)))
            .get(MealVewModelRetro::class.java)

        mealVewModelRetro.getMealCategories()

        catgAdapter = CategoryItemAdpter()
        binding.rvCategories.adapter=catgAdapter

        mealVewModelRetro.categories.observe(requireActivity(), Observer {
            catgAdapter.setData(it.categories)
            catgAdapter.notifyDataSetChanged()

        })
        catgAdapter!!.setOnItemClickListener(object : ClickListener<Category> {
            override fun onClick(view: View?, data: Category, position: Int) {
                mealVewModelRetro.getMealListForCategory(data.strCategory)

                observer()
                Toast.makeText(
                    requireActivity(), """"Position = ${position.inc()} Category= ${data.strCategory} """, Toast.LENGTH_SHORT
                ).show()
            }
        })



        binding.rvItemList.layoutManager=GridLayoutManager(requireActivity(),3)
        mealAdapter = MealsItemAdpter()
        binding.rvItemList.adapter = mealAdapter
        mealVewModelRetro.getMealListForCategory("Beef")

        observer()

        mealAdapter!!.setOnItemClickListener(object : ClickListener<MealEntity> {
            override fun onClick(view: View?, data: MealEntity, position: Int) {

                Toast.makeText(
                    context,
                    """"Position = ${position.inc()} Category= ${data.strMeal} """,
                    Toast.LENGTH_SHORT
                ).show()
            }
        })
        return view

    }

    private fun observer() {
        mealVewModelRetro.mealsList.observe(requireActivity(), Observer {

            mealAdapter.setData(it.meals)
            mealAdapter.notifyDataSetChanged()


        })
    }

}