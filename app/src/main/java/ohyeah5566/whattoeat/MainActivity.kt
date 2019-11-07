package ohyeah5566.whattoeat

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import com.google.gson.GsonBuilder
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class MainActivity : AppCompatActivity() {

    private val restaurantService by lazy {
        Retrofit.Builder()
            .baseUrl("https://maps.googleapis.com/maps/api/place/nearbysearch/")
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build().create(RestaurantService::class.java)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewModel = MainViewModel(restaurantService)

        viewModel.restaurants.observe(this, Observer {
            var adapter = RestaurantAdapter(this, it)
            with(adapter) {
                viewpager.adapter = adapter
                setOnButtonClick(object : RestaurantAdapter.OnButtonClick {
                    override fun goNextItem() {
                        viewpager.setCurrentItem(viewpager.currentItem + 1, true)
                    }
                })
            }
        })

        viewModel.getRestaurant()

    }
}
