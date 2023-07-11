package com.example.foodler.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.foodler.databinding.FilterItemsBinding
import com.example.foodler.tempdata.FilterData

class FilterListAdapter(private val filterList:List<FilterData>):RecyclerView.Adapter<FilterListAdapter.FilterListViewHolder>() {

    var onItemClick : ((FilterData) -> Unit)? = null
    inner class FilterListViewHolder(val binding: FilterItemsBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilterListViewHolder {
        return FilterListViewHolder(
            FilterItemsBinding.inflate(LayoutInflater.from(parent.context), parent , false)
        )
    }

    override fun getItemCount(): Int {
       return filterList.size
    }

    override fun onBindViewHolder(holder: FilterListViewHolder, position: Int) {
        holder.binding.tvFilterTitle.text = filterList[position].title
        holder.itemView.setOnClickListener {
            onItemClick?.invoke(filterList[position])
        }
    }
}