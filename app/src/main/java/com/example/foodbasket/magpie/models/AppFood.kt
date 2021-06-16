package com.example.foodbasket.magpie.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable


@Entity(tableName = "food_table")
data class AppFood(
        @PrimaryKey(autoGenerate = true) val id:Int = 0,
        @ColumnInfo val name:String = "",
        @ColumnInfo val quantity: String = "",
        @ColumnInfo val date:String = "",
        @ColumnInfo val category:String = ""
):Serializable