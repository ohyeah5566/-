package ohyeah5566.whattoeat

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import java.lang.Exception


class MainViewModel(val restaurantService: RestaurantService) : ViewModel() {

    val restaurants = MutableLiveData<List<Restaurant>>()

    fun getRestaurant() {
        viewModelScope.launch {
            val baseResponse = restaurantService.getRestaurants(
                "25.030266,121.554234",
                500,
                "restaurant",
                ""
            )
            with(baseResponse) {
                if (status == "OK")
                    restaurants.value = results
            }
            Log.d("BaseResponse", baseResponse.toString())
        }
    }


}