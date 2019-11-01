package ohyeah5566.whattoeat

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface RestaurantService {
    @GET("language=zh-TW")
    suspend fun getRestaurants(
        @Query("location") location: String,
        @Query("rankby") rankBy:String,
        @Query("radius") distance:Int,
        @Query("type") type:String,
        @Query("pagetoken") pageToken:String
    ): Response<BaseResponse>
}