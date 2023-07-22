package com.jama.mvcandmvp.mvc

import java.util.Observable


class Model : Observable(){
    val list:MutableList<Int>
    init {
        list = ArrayList(3)
        list.add(1)
        list.add(2)
        list.add(3)
    }
    fun getValueWithIndex(index:Int) :Int = list[index]
    fun setValueWithIndex(index: Int) {
        list[index] += 1
        // update data
        setChanged()
        notifyObservers()
    }
}