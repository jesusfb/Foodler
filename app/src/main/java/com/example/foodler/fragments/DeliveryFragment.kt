package com.example.foodler.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.foodler.adapters.DeliveryListAdapter
import com.example.foodler.adapters.FilterListAdapter
import com.example.foodler.adapters.MenuListAdapter
import com.example.foodler.databinding.FragmentDeliveryBinding
import com.example.foodler.tempdata.RestaurantDetails
import com.example.foodler.tempdata.filterDummyData
import com.example.foodler.tempdata.generateDummyMenu
import com.example.foodler.tempdata.generateDummyRestaurant

class DeliveryFragment : Fragment() {
    private lateinit var binding: FragmentDeliveryBinding
    private lateinit var deliveryAdapter: DeliveryListAdapter
    private lateinit var menuListAdapter: MenuListAdapter
    private lateinit var restaurantList: List<RestaurantDetails>
    private lateinit var filterListAdapter: FilterListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        restaurantList = generateDummyRestaurant()
        deliveryAdapter = DeliveryListAdapter(restaurantList)

        menuListAdapter = MenuListAdapter(generateDummyMenu())
        filterListAdapter = FilterListAdapter(filterDummyData())
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View {
        binding = FragmentDeliveryBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        prepareRestaurantRecyclerView()
        prepareMenuRecyclerView()
        prepareFilterRecyclerView()

        binding.ivRandomMeal.setImageResource(restaurantList.random().banner)
    }

    //Restaurant Recycler View
    private fun prepareRestaurantRecyclerView() {
        binding.rvRestaurants.apply {
            layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
            adapter = deliveryAdapter
        }
    }


    // Menu Option Recycler View
    private fun prepareMenuRecyclerView() {
        binding.rvMenu.apply {
            layoutManager = GridLayoutManager(context, 2, GridLayoutManager.HORIZONTAL, false)
            adapter = menuListAdapter
        }
    }

    private fun prepareFilterRecyclerView(){
        binding.rvFilters.apply {
            layoutManager = GridLayoutManager(context, 1, GridLayoutManager.HORIZONTAL, false)
            adapter = filterListAdapter
        }
    }
}