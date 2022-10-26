package com.example.mealdb.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.mealdb.databinding.FragmentMealInstructionBinding
import com.example.mealdb.networkmodel.MealRetroRepository
import com.example.mealdb.networkmodel.RetrofitService
import com.example.mealdb.viewmodel.MealVewModelRetro
import com.example.mealdb.viewmodel.MealViewModelFactoryRetro

class MealInstructionFragment : Fragment() {
    val TAG="MealInstructionFragment"
    lateinit var binding: FragmentMealInstructionBinding
    var retrofitService: RetrofitService = RetrofitService.getInstance()
    lateinit var mealVewModelRetro: MealVewModelRetro
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentMealInstructionBinding.inflate(inflater, container, false)
        val view: View =binding.root

        mealVewModelRetro = ViewModelProvider(this,
            MealViewModelFactoryRetro(MealRetroRepository(retrofitService))
        ).get(MealVewModelRetro::class.java)

        mealVewModelRetro.mealsId.observe(requireActivity(), Observer {
            Log.d(TAG, "onCreateView: $it")
            mealVewModelRetro.getInsructionForMeal(it)
        })
        mealVewModelRetro.mealsListInst.observe(requireActivity(), Observer {

            val mealItem = it.meals.get(0)
            Log.d(TAG, "onCreateView: $mealItem")
            binding.instruction.text= mealItem.strInstructions
            binding.labelItem.text= mealItem.strMeal
            Glide.with(context).load(mealItem.strMealThumb).into(binding.tmage);
        })
        return view

    }



}