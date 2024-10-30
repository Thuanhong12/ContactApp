package com.example.contactapp

import android.app.Application

class ContactApplication:Application(){
    override fun onCreate(){
        super.onCreate()
        Graph.provide(this)
    }
}