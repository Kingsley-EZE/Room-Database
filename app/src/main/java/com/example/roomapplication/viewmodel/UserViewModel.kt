package com.example.roomapplication.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.roomapplication.data.UserDatabase
import com.example.roomapplication.repository.UserRepository
import com.example.roomapplication.model.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


// The ViewModel is responsible for providing data to the UI and surviving configuration changes.
// A ViewModel serves as the communication center between the Repository and the UI

class UserViewModel(application: Application) : AndroidViewModel(application) {

     val readAllData : LiveData<List<User>>
    private val repository : UserRepository

    init {
        val userDao = UserDatabase.getDatabase(application).userDao()
        repository = UserRepository(userDao)
         readAllData = repository.readAllData()
    }

    fun addUser(user: User){
        viewModelScope.launch(Dispatchers.IO){
            repository.addUser(user)

        }
    }

    fun updateUser(user: User){
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateUser(user)
        }
    }

    fun deleteUser(user: User){
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteUser(user)
        }
    }

    fun deleteAllUser(){
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteAllUSer()
        }
    }

}