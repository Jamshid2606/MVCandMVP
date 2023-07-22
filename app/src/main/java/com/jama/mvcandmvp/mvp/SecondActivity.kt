package com.jama.mvcandmvp.mvp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ListAdapter
import androidx.core.view.isVisible
import com.jama.mvcandmvp.R
import com.jama.mvcandmvp.databinding.ActivityMainBinding
import com.jama.mvcandmvp.databinding.ActivitySecondBinding
import com.jama.mvcandmvp.mvp.adapters.UserAdapter
import com.jama.mvcandmvp.mvp.db.UserEntity
import com.jama.mvcandmvp.mvp.presenter.ContractView
import com.jama.mvcandmvp.mvp.presenter.UserPresenter

class SecondActivity : AppCompatActivity(), ContractView  {
    lateinit var binding: ActivitySecondBinding
    lateinit var userPresenter: UserPresenter
    lateinit var userAdapter: UserAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // MVP -> model view presentation
        userPresenter = UserPresenter(this, this )
        userAdapter = UserAdapter()
        binding.rv.adapter = userAdapter
        userPresenter.showUsers()
        binding.apply {
            saveBtn.setOnClickListener {
                val name = etName.toString()
                val age :Int  = etAge.toString().toInt()
                userPresenter.addUser(name, age)
            }
        }
    }

    override fun showUsers(userList: List<UserEntity>) {
        userAdapter.submitList(userList)
    }

    override fun showProgressBar() {
        binding.progress.isVisible = true
        binding.progress.isVisible = false
    }

    override fun hideProgressBar() {
        binding.progress.isVisible = false
        binding.progress.isVisible = true
    }
}