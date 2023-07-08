package com.example.foodler.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.foodler.databinding.MenuItemListBinding
import com.example.foodler.tempdata.MenuData

class MenuListAdapter(private val menuItemList: List<MenuData>) :
    RecyclerView.Adapter<MenuListAdapter.MenuListViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuListViewHolder {
        return MenuListViewHolder(
            MenuItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun getItemCount(): Int {
        return menuItemList.size
    }

    override fun onBindViewHolder(holder: MenuListViewHolder, position: Int) {
        val currentItem = menuItemList[position]
        holder.binding.apply {
            menuItem.setImageResource(currentItem.image)
            menuTitle.text = currentItem.name
        }
    }

    inner class MenuListViewHolder(val binding: MenuItemListBinding) :
        RecyclerView.ViewHolder(binding.root)
}