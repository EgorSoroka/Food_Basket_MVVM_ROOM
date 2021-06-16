package com.example.foodbasket.magpie.screens.new_food

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.foodbasket.magpie.R
import com.example.foodbasket.magpie.databinding.FragmentAddNewFoodBinding
import com.example.foodbasket.magpie.models.AppFood
import com.example.foodbasket.magpie.utilits.APP_ACTIVITY
import com.example.foodbasket.magpie.utilits.showToast
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AddNewFoodFragment : Fragment() {

    private var _binding:FragmentAddNewFoodBinding? = null
    private val mBinding get() = _binding!!
    private lateinit var mViewModel: AddNewFoodViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
            _binding = FragmentAddNewFoodBinding.inflate(layoutInflater, container, false)
        return mBinding.root
    }

    override fun onStart() {
        super.onStart()
        initialization()
    }

    private fun initialization() {
        mViewModel = ViewModelProvider(this).get(AddNewFoodViewModel::class.java)
        mBinding.btnAddFood.setOnClickListener{
            val name = mBinding.inputNameFood.text.toString()
            val quantity = mBinding.inputQuantityFood.text.toString()
            val datetime = mBinding.inputDatetimeFood.text.toString()
            val grocery = mBinding.inputGroceryFood.text.toString()
            if (name.isEmpty()){
                showToast(getString(R.string.toast_enter_name_food))
            }else{

                mViewModel.insert(AppFood(name = name, quantity = quantity, date = datetime, category = grocery )){
                    lifecycleScope.launch(Dispatchers.Main){
                        APP_ACTIVITY.navController.navigate(R.id.action_addNewFoodFragment_to_mainFragment)
                    }
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}