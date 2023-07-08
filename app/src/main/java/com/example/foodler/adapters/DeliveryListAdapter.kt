package com.example.foodler.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.foodler.databinding.DeliveryItemListBinding
import com.example.foodler.tempdata.RestaurantDetails

class DeliveryListAdapter(private val dataItemList: List<RestaurantDetails>) :
    RecyclerView.Adapter<DeliveryListAdapter.DeliveryViewHolder>() {


    inner class DeliveryViewHolder(val binding: DeliveryItemListBinding) :
        RecyclerView.ViewHolder(binding.root)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DeliveryViewHolder {

        return DeliveryViewHolder(
            DeliveryItemListBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return dataItemList.size
    }

    override fun onBindViewHolder(holder: DeliveryListAdapter.DeliveryViewHolder, position: Int) {

        val currentItem = dataItemList[position]
        holder.binding.apply {
            dvTvRestaurantName.text = currentItem.restaurantName
            dvTvRestaurantRating.text = currentItem.rating
            dvIvBanner.setImageResource(currentItem.banner)
            dvTvFoodName.text =
                "${currentItem.foodName} ● ${currentItem.foodCategory} ● ${currentItem.foodPrice}"
            dvTvExpectedTime.text = "${currentItem.expectedTime} ● ${currentItem.distance}"
            dvTvDiscount.text = currentItem.discount
        }
    }

}
