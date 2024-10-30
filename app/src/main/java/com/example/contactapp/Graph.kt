package com.example.contactapp

import android.content.Context

object Graph{
    lateinit var db:ContactDatabase
        private set
    val repository by lazy{
        ContactRepository(
            db.dao
        )
    }
    fun provide(context: Context){
        db=ContactDatabase.getDatabase(context=context)
    }
}