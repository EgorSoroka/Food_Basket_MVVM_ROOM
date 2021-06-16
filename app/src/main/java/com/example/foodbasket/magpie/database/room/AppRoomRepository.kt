package com.example.foodbasket.magpie.database.room

import androidx.lifecycle.LiveData
import com.example.foodbasket.magpie.database.DatabaseRepository
import com.example.foodbasket.magpie.models.AppFood


class AppRoomRepository(private val appRoomDao: AppRoomDao) : DatabaseRepository {
    override val allFoods: LiveData<List<AppFood>>
        get() = appRoomDao.getAll()

    override suspend fun insert(food: AppFood, onSuccess: () -> Unit) {
        appRoomDao.insert(food)
        onSuccess()
    }

    override suspend fun delete(food: AppFood, onSuccess: () -> Unit) {
        appRoomDao.delete(food)
        onSuccess()
    }

}