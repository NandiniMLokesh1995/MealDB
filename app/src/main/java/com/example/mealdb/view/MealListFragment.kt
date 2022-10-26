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
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentMealListBinding.inflate(inflater, container, false)
        val view: View =binding.root
        val context = requireContext()
        binding.recyclerview.layoutManager = GridLayoutManager(activity, 4)
        mealVewModelRetro = ViewModelProvider(this,
            MealViewModelFactoryRetro(MealRetroRepository(retrofitService))
        )
            .get(MealVewModelRetro::class.java)
        mealVewModelRetro.getMealListForCategory("Beef")
        mealAdapter = MealsItemAdpter()

        binding.recyclerview.adapter = mealAdapter
        mealVewModelRetro.mealsList.observe(requireActivity(), Observer {

            mealAdapter.clearItems()
            mealAdapter.setData(it.meals)
            mealAdapter.notifyDataSetChanged()

        })
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

}