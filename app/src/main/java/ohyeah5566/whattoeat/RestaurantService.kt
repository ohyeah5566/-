package ohyeah5566.whattoeat

import retrofit2.http.GET
import retrofit2.http.Query

interface RestaurantService {
    @GET("json?key=AIzaSyBfuK8uJG2eJ-S7cPNeA_mk2p48e8qZVUs&language=zh-TW")
    suspend fun getRestaurants(
        @Query("location") location: String,
        @Query("radius") distance: Int,
        @Query("type") type: String,
        @Query("pagetoken") pageToken: String
    ): BaseResponse
}