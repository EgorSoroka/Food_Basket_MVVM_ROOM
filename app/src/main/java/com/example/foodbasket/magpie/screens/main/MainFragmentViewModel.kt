package com.example.foodbasket.magpie.screens.main

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.foodbasket.magpie.utilits.REPOSITORY

class MainFragmentViewModel(application: Application): AndroidViewModel(application) {
    val allProducts = REPOSITORY.allFoods
}