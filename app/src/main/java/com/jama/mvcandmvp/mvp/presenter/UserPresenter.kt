package com.jama.mvcandmvp.mvp.presenter

import android.content.Context
import com.jama.mvcandmvp.mvp.db.AppDatabase
import com.jama.mvcandmvp.mvp.db.UserEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

// presenter

class UserPresenter(private var context: Context, private val contractView: ContractView) {
    private val appDatabase = AppDatabase.getInstance(context)
    private val userdao = appDatabase.userDao()

    fun showUsers(){
        GlobalScope.launch(Dispatchers.Main) {
            contractView.showProgressBar()
            delay(500)
            contractView.showUsers(userdao.getUsers())
            contractView.hideProgressBar()
        }
    }
    fun addUser(name:String, age:Int){
        val userEntity = UserEntity(name = name, age = age)
        userdao.addUser(userEntity)
        showUsers()
    }
}