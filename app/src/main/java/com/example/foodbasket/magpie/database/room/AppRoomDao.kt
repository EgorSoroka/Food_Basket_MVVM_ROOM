package com.example.foodbasket.magpie.database.room

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.foodbasket.magpie.models.AppFood


@Dao
interface AppRoomDao {
    @Query("SELECT * FROM food_table")
    fun getAll():LiveData<List<AppFood>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(food: AppFood)

    @Delete
    suspend fun delete(food: AppFood)
}