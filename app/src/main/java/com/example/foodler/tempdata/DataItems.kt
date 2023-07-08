package com.example.foodler.tempdata

import com.example.foodler.R

data class RestaurantDetails(
    val restaurantName: String,
    val rating: String,
    val banner: Int,
    val foodName: String,
    val foodCategory: String,
    val foodPrice: String,
    val expectedTime: String,
    val distance: String,
    val discount: String
)

data class MenuData(
    val name: String,
    val image: Int
)

data class FilterData(
    val title:String
)

fun generateDummyMenu(): List<MenuData> {
    val menuList = mutableListOf<MenuData>()

    menuList.add(MenuData("Beef", R.drawable.ic_beef))
    menuList.add(MenuData("Cake", R.drawable.ic_cake))
    menuList.add(MenuData("Pizza", R.drawable.ic_pizza))
    menuList.add(MenuData("Thali", R.drawable.ic_thali))
    menuList.add(MenuData("Chicken", R.drawable.ic_chicken))
    menuList.add(MenuData("Fried Rice", R.drawable.ic_friedrice))
    menuList.add(MenuData("Lamb", R.drawable.ic_lamb))
    menuList.add(MenuData("Misc", R.drawable.ic_misc))
    menuList.add(MenuData("Pasta", R.drawable.ic_pasta))
    menuList.add(MenuData("Seafood", R.drawable.ic_seafood))

    return menuList
}

fun filterDummyData():List<FilterData>{
    val filterList = mutableListOf<FilterData>()

    filterList.add(FilterData("Sort"))
    filterList.add(FilterData("Nearest"))
    filterList.add(FilterData("Rating 4.0+"))
    filterList.add(FilterData("Pure Veg"))
    filterList.add(FilterData("New Arrivals"))
    filterList.add(FilterData("Cuisines"))

    return filterList
}


fun generateDummyRestaurant(): List<RestaurantDetails> {

    val restaurantName = arrayOf(
        "Delhi Darbar", "Bakeup Bakery", "Ghousia Hotel", "Saffron", "Hindustan Fried Chicken",
        "Hungry Kya", "Kolkata Laziz Biryani", "Pizza Hut", "Khalsa Hotel", "Al Baik"
    )


    val rating =
        arrayOf("3.1", "3.2", "3.3", "3.4", "3.5", "3.6", "3.7", "3.8", "3.9", "4.0", "4.1", "4.2")

    val banner = ArrayList<Int>().apply {
        add(R.drawable.img_1)
        add(R.drawable.img_2)
        add(R.drawable.img_3)
        add(R.drawable.img_4)
        add(R.drawable.img_5)
        add(R.drawable.img_6)
        add(R.drawable.img_7)
        add(R.drawable.img_8)
        add(R.drawable.img_9)
        add(R.drawable.img_10)
    }

    val foodName = arrayOf(
        "Chicken Biryani",
        "Pineapple Cake",
        "Chicken Roll",
        "Chicken Lollipop",
        "Cheese burger",
        "Paneer Masala",
        "Chicken Fried Rice",
        "Margherita Pizza",
        "Vegetable Biryani",
        "Chicken Chilli"
    )

    val foodCategory = arrayOf(
        "Biryani ",
        "Desert ",
        "Fast Food",
        "Fast Food",
        "Dinner",
        "Fast Food",
        "Fast Food",
        "Pizza",
        "Veg Biryani",
        "Fast Food"
    )

    val foodPrice = arrayOf(
        "₹200 for one ",
        "₹160 for one ",
        "₹150 for one ",
        "₹100 for one ",
        "₹80 for one ",
        "₹200 for one ",
        "₹300 for one ",
        "₹320 for one ",
        "₹120 for one ",
        "₹60 for one "
    )

    val expectedTime = arrayOf(
        "5-10 min",
        "15-20 min",
        "10-20 min",
        "35-40 min",
        "35-40 min",
        "25-30 min",
        "5-15 min",
        "15-30 min",
        "10-30 min",
        "35-40 min"
    )

    val distance = arrayOf(
        "1 km",
        "2 km",
        "3 km",
        "1 km",
        "3 km",
        "2 km",
        "5 km",
        "4 km",
        "6 km",
        "7 km"
    )

    val discount = arrayOf(
        "50% OFF up to 100",
        "30% OFF up to 100",
        "40% OFF up to 100",
        "60% OFF up to 100",
        "40% OFF up to 100",
        "50% OFF up to 100",
        "50% OFF up to 100",
        "45% OFF up to 100",
        "40% OFF up to 100",
        "30% OFF up to 100"
    )


    //For Restaurant Details
    val dummyRestaurantDetails = mutableListOf<RestaurantDetails>()

    for (i in 0 until 8) {
        val restaurantDetails = RestaurantDetails(
            restaurantName[i],
            rating[i],
            banner[i],
            foodName[i],
            foodCategory[i],
            foodPrice[i],
            expectedTime[i],
            distance[i],
            discount[i]
        )
        dummyRestaurantDetails.add(restaurantDetails)
    }

    return dummyRestaurantDetails
}
