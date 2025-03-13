package com.example.cacheit.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import androidx.room.Upsert
import com.example.cacheit.domain.Item

@Dao
interface ItemDao {

    @Upsert
    suspend fun insert(item: ItemEntity)
    
    @Delete
    suspend fun delete(item: ItemEntity)

    @Query("SELECT * FROM items_table ORDER BY id DESC")
    suspend fun getAllItems():List<ItemEntity>

    @Query("SELECT COUNT(*) FROM items_table")
    suspend fun getItemCount(): Int

}