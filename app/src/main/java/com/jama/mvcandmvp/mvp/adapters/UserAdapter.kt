package com.jama.mvcandmvp.mvp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.jama.mvcandmvp.databinding.ItemUserBinding
import com.jama.mvcandmvp.mvp.db.UserEntity

class UserAdapter: ListAdapter<UserEntity, UserAdapter.Vh>(MyDiffUtil()) {

    inner class Vh(var itemUserBinding:ItemUserBinding) :RecyclerView.ViewHolder(itemUserBinding.root){
        fun onBind(userEntity: UserEntity){
            itemUserBinding.apply {
                AgeTv.text = userEntity.age.toString()
                nameTv.text = userEntity.name
            }
        }
    }

    class MyDiffUtil: DiffUtil.ItemCallback<UserEntity>(){
        override fun areItemsTheSame(oldItem: UserEntity, newItem: UserEntity): Boolean = oldItem.id == newItem.id


        override fun areContentsTheSame(oldItem: UserEntity, newItem: UserEntity): Boolean = oldItem == newItem

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh  = Vh(ItemUserBinding.inflate(
        LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: Vh, position: Int) {
        holder.onBind(getItem(position))
    }
}