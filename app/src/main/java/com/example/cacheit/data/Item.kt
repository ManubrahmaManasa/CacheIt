package com.example.cacheit.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "items_table")
data class Item(
    @PrimaryKey(autoGenerate = true)
    val id:Int = 0,
    val title:String,
    val body:String
)
