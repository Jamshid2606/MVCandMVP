package com.jama.mvcandmvp.mvp.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface UserDao {
    @Insert
    fun addUser(userEntity: UserEntity) {}

    @Query("select * from userentity")
    fun getUsers() :List<UserEntity> {
        return emptyList()
    }
}