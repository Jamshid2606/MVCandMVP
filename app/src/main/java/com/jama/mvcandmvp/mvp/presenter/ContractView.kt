package com.jama.mvcandmvp.mvp.presenter

import com.jama.mvcandmvp.mvp.db.UserEntity

interface ContractView {
    fun showUsers(userList: List<UserEntity>)
    fun showProgressBar()
    fun hideProgressBar()
}