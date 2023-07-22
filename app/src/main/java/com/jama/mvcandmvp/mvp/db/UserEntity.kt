package com.jama.mvcandmvp.mvp.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class UserEntity(
    @PrimaryKey(autoGenerate = true)
    var id:Int = 0,
    val name:String,
    val age:Int
)
