package com.example.contactapp

class ContactRepository(private val contactDao: ContactDao) {
    val contacts = contactDao.getAllContactS()
    fun getContactByID(id:Int) = contactDao.getContactById(id)
    suspend fun deleteContact(contact: Contact){
        contactDao.deleteContact(contact)
    }
    suspend fun insertContact(contact: Contact){
        contactDao.insertContact(contact)
    }
    suspend fun updateContact(contact: Contact){
        contactDao.updateContact(contact)
    }
}