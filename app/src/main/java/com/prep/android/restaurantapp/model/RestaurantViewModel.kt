package com.prep.android.restaurantapp.model

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.prep.android.restaurantapp.repository.RestaurantRepository

private const val DOORDASH_LOCATION_LAT = 37.422740
private const val DOORDASH_LOCATION_LNG = -122.139956

class RestaurantViewModel(application: Application) : AndroidViewModel(application) {
    private var _restaurantBriefs = MutableLiveData<List<RestaurantBrief>>()
    private var _restaurantInfo = MutableLiveData<RestaurantInfo>()

    init {
        fetchMoreRestaurant()
    }

    fun fetchMoreRestaurant() {
        RestaurantRepository.fetchMoreRestaurants(DOORDASH_LOCATION_LAT, DOORDASH_LOCATION_LNG)
    }

    fun fetchRestaurantInfo(id: Int) {
        RestaurantRepository.fetchRestaurantInfo(id)
    }

    fun getRestaurantBriefs(): LiveData<List<RestaurantBrief>> {
        _restaurantBriefs = RestaurantRepository.getRestaurantLiveData()
        return _restaurantBriefs
    }

    fun getRestaurantInfo(): LiveData<RestaurantInfo> {
        _restaurantInfo = RestaurantRepository.getRestaurantInfoLiveData()
        return _restaurantInfo
    }

    fun clearData() {
        RestaurantRepository.resetCache()
    }
}