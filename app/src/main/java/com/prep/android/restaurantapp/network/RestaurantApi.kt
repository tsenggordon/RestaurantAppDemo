package com.prep.android.restaurantapp.network

import com.prep.android.restaurantapp.model.RestaurantBrief
import com.prep.android.restaurantapp.model.RestaurantInfo
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RestaurantApi {
    @GET("/v2/restaurant/")
    fun getRestaurants(
        @Query("lat") lat: Double,
        @Query("lng") lng: Double,
        @Query("offset") offset: Int,
        @Query("limit") limit: Int
    ): Call<List<RestaurantBrief>>

    @GET("/v2/restaurant/{restaurant_id}")
    fun getRestaurantInfo(
        @Path("restaurant_id") id: Int
    ): Call<RestaurantInfo>
}