package com.example.foodbasket.magpie.screens.start

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.foodbasket.magpie.database.room.AppRoomDatabase
import com.example.foodbasket.magpie.database.room.AppRoomRepository
import com.example.foodbasket.magpie.utilits.REPOSITORY

class StartFragmentViewModel(application: Application): AndroidViewModel(application) {
    private val mContext = application

    fun initDatabase(){
        val dao = AppRoomDatabase.getInstance(mContext).getAppRoomDao()
                REPOSITORY = AppRoomRepository(dao)
     }
    }
