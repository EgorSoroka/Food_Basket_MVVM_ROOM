package com.example.foodbasket.magpie.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "food_table")
data class AppFood (
    @PrimaryKey(autoGenerate = true) val id:Int = 0,
    @ColumnInfo val name:String = "",
    @ColumnInfo val quantity:Int = 0,
    @ColumnInfo val date:String = ""
)