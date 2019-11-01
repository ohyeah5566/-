package ohyeah5566.whattoeat

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch


class MainViewModel(val restaurantService: RestaurantService) : ViewModel() {

    lateinit var baseResponse: MutableLiveData<BaseResponse>
    lateinit var restaurants: MutableLiveData<List<Restaurant>>

    fun getRestaurant(){
        viewModelScope.launch {
            baseResponse.value = restaurantService.getRestaurants(
                "25.030266,121.554234",
                "distance",
                500,
                "restaurant",
                ""
            )
        }
    }

}