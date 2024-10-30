package com.example.contactapp

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
@Database(entities = [Contact::class], version = 1)
abstract class ContactDatabase:RoomDatabase(){
    abstract val dao:ContactDao

    companion object{
        @Volatile
        private var Instance:ContactDatabase?=null
        fun getDatabase(context: Context):ContactDatabase{
            return Instance ?: synchronized(this){
                Room.databaseBuilder(
                    context,
                    ContactDatabase::class.java,
                    "contact_db"
                )
                    .build().also { Instance = it }
            }
        }
    }
}