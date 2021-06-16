package com.example.foodbasket.magpie.food

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.foodbasket.magpie.models.AppFood
import com.example.foodbasket.magpie.utilits.REPOSITORY
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FoodFragmentViewModel(application: Application): AndroidViewModel(application) {
        fun  delete(food: AppFood, onSuccess:()->Unit) =
                viewModelScope.launch(Dispatchers.IO){
                    REPOSITORY.delete(food){
                        viewModelScope.launch(Dispatchers.Main) {
                            onSuccess()
                        }
                    }
                }
}