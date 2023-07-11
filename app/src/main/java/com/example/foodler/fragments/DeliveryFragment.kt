package com.example.foodler.fragments

import android.graphics.Typeface
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.foodler.R
import com.example.foodler.adapters.DeliveryListAdapter
import com.example.foodler.adapters.FilterListAdapter
import com.example.foodler.adapters.MenuListAdapter
import com.example.foodler.databinding.FragmentDeliveryBinding
import com.example.foodler.tempdata.filterDummyData
import com.example.foodler.tempdata.generateDummyMenu
import com.example.foodler.tempdata.generateDummyRestaurant

class DeliveryFragment : Fragment(){

    private lateinit var binding: FragmentDeliveryBinding
    private lateinit var deliveryAdapter: DeliveryListAdapter
    private lateinit var menuListAdapter: MenuListAdapter
    private lateinit var filterListAdapter: FilterListAdapter

    private val hintList = arrayOf(
        "cake",
        "biryani",
        "thali",
        "lollipop",
        "dosa",
        "khichdi",
        "burger",
        "pizza",
        "chicken curry ",
        "chicken chilli"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        deliveryAdapter = DeliveryListAdapter(generateDummyRestaurant())
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

        prepareUi()
        bottomSheet()
    }

    private fun prepareUi() {

        binding.textSwitcher.apply {
            setFactory {
                val textView = TextView(requireContext())
                textView.textSize = 14f
                textView.setTextColor(ContextCompat.getColor(requireContext(), R.color.colorTemp))
                textView.typeface = Typeface.DEFAULT_BOLD
                textView
            }

            val handler = Handler(Looper.getMainLooper())
            val delayInMillis: Long = 3000 // Delay of 3 seconds

            val countDownTimer = object : CountDownTimer(Long.MAX_VALUE, delayInMillis) {
                override fun onTick(millisUntilFinished: Long) {
                    // Change the text after each delay
                    binding.textSwitcher.setText("Search \"${hintList.random()}\"")
                }
                override fun onFinish() {
                    // Not used in this example
                }
            }
            handler.postDelayed({
                countDownTimer.start()
            }, delayInMillis)
        }

        binding.ivRandomMeal.setImageResource(generateDummyRestaurant().random().banner)

        //Restaurant List Views
        binding.rvRestaurants.apply {
            layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
            adapter = deliveryAdapter
        }

        //Recyclerview for menus
        binding.rvMenu.apply {
            layoutManager = GridLayoutManager(context, 2, GridLayoutManager.HORIZONTAL, false)
            adapter = menuListAdapter
        }

        //Recyclerview for Filter options
        binding.rvFilters.apply {
            layoutManager = GridLayoutManager(context, 1, GridLayoutManager.HORIZONTAL, false)
            adapter = filterListAdapter
            filterListAdapter.onItemClick = {

            }
        }
    }

    private fun bottomSheet() {
        val foodOptions = arrayOf("Pizza", "Sushi", "Burger", "Pasta", "Tacos")
        val foodBottomSheet = BottomSheetFragment.newInstance("Food List", foodOptions)

        // Show the bottom sheets when needed
//        binding.btnIvProfile.setOnClickListener {
//            foodBottomSheet.show(parentFragmentManager, "food_bottom_sheet")
//        }

    }
}