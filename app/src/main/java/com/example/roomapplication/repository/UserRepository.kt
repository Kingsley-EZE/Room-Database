package com.example.roomapplication.repository

import androidx.lifecycle.LiveData
import com.example.roomapplication.data.UserDao
import com.example.roomapplication.model.User


// A Repository is a class that abstracts access to multiple data sources.
//The Repository is not part of the Architecture Components Libraries, but it is a suggested best practice for code separation and architecture

class UserRepository(private val userDao: UserDao) {

     fun readAllData() : LiveData<List<User>> = userDao.readAllData()


    suspend fun addUser(user: User){
        userDao.addUser(user)
    }

    suspend fun updateUser(user: User){
        userDao.updateUser(user)
    }

    suspend fun deleteUser(user: User){
        userDao.deleteUser(user)
    }

    suspend fun deleteAllUSer(){
        userDao.deleteAllUsers()
    }

}