package com.example.foodbasket.magpie.database

import androidx.lifecycle.LiveData
import com.example.foodbasket.magpie.models.AppFood

interface DatabaseRepository {
    val allFoods:LiveData<List<AppFood>>
    suspend fun insert(food: AppFood, onSuccess:()->Unit)
    suspend fun delete(food: AppFood, onSuccess:()->Unit)
}