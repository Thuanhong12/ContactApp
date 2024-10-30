package com.example.contactapp

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class ContactDetailViewModel(
    private val contactId:Int,
    private val contactRepository: ContactRepository=Graph.repository):ViewModel() {
    var state by mutableStateOf(ContactStae())
        private set
    init {
        if(contactId>0){
            viewModelScope.launch {
                contactRepository.getContactByID(contactId).collectLatest {
                    state =state.copy(
                        fullname = it.Fullname,
                        email = it.Email,
                        phone = it.Phone
                    )
                }
            }
        }
    }
    fun onChangeFullName(newValue: String){
        state = state.copy(fullname =newValue)
    }
    fun onChangePhone(newValue: String){
        state = state.copy(phone =newValue)
    }
    fun onChangeEmail(newValue: String){
        state = state.copy(email =newValue)
    }
    fun insertContact(contact: Contact){
        viewModelScope.launch {
            contactRepository.insertContact(contact=contact)
        }
    }
    fun updateContact(contact: Contact){
        viewModelScope.launch {
            contactRepository.updateContact(contact=contact)
        }
    }
}
@Suppress("UNCHECKED_CAST")
class ContactDetailViewModelFactor(private  val id:Int):ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ContactDetailViewModel(contactId = id) as T
    }
}
data class ContactStae(
    val fullname:String="",
    val phone:String="",
    val email:String=""
)
