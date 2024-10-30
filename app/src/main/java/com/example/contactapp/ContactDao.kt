package com.example.contactapp

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow
@Dao
interface ContactDao{
    @Query("Select* From Contact")
    fun getAllContactS(): Flow<List<Contact>>
    @Query("Select* From Contact Where Id= :contactId")
    fun getContactById(contactId:Int):Flow<Contact>
    @Insert
    suspend fun insertContact(contact: Contact)
    @Update
    suspend fun updateContact(contact: Contact)
    @Delete
    suspend fun deleteContact(contact: Contact)
}