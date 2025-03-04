package com.example.cacheit.data

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase

abstract class ItemDatabase:RoomDatabase() {
    abstract fun itemDao():ItemDao

    companion object{
        private var INSTANCE:ItemDatabase? = null

        fun getDatabase(context: Context):ItemDatabase{
            return INSTANCE ?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ItemDatabase::class.java,
                    "item_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}