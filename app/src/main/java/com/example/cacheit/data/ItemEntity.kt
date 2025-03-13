package com.example.cacheit.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "items_table")
data class ItemEntity(
    @PrimaryKey(autoGenerate = true)
    var id:Int? = 0,
    var title:String?,
    var body:String?
)

