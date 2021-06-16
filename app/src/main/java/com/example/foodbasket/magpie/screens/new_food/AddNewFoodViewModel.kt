package com.example.foodbasket.magpie.screens.new_food

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.foodbasket.magpie.models.AppFood
import com.example.foodbasket.magpie.utilits.REPOSITORY
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AddNewFoodViewModel(application: Application): AndroidViewModel(application) {
        fun insert(food:AppFood, onSuccess:()->Unit) =
                viewModelScope.launch(Dispatchers.IO){
                    REPOSITORY.insert(food){
                        onSuccess()
                    }
                }
}