package com.jama.mvcandmvp.mvc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.jama.mvcandmvp.databinding.ActivityMainBinding
import java.util.Observable
import java.util.Observer

class MainActivity : AppCompatActivity(), Observer {
    lateinit var binding : ActivityMainBinding
    private var model: Model?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        model = Model()
        model?.addObserver(this)

        // appDatabase.getUserDao().addUser(user)
        // model -> appDatabase, dao, entity
        // controller -> activity
        // view -> rv

        // model -> ApiClient, ApiService
        // ApiClient.getRetrofit().create(ApiService::java.class)
        // controller -> activity
        // view -> textview, rv ...


        // view
        binding.apply {
            //get data
            button1.setOnClickListener {
                model?.setValueWithIndex(0)
            }
            button2.setOnClickListener {
                model?.setValueWithIndex(1)
            }
            button3.setOnClickListener {
                model?.setValueWithIndex(2)
            }
        }
    }

    override fun update(p0: Observable?, p1: Any?) {
        // update presentation
        binding.button1.text = model?.getValueWithIndex(0).toString()
        binding.button2.text = model?.getValueWithIndex(1).toString()
        binding.button3.text = model?.getValueWithIndex(2).toString()
    }
}