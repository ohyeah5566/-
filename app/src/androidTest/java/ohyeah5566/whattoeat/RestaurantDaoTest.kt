package ohyeah5566.whattoeat

import androidx.room.Room
import androidx.test.InstrumentationRegistry
import androidx.test.runner.AndroidJUnit4
import com.google.gson.Gson
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class RestaurantDaoTest {

    private lateinit var database: RestaurantDatabase

    @Before
    fun initDb() {
        database = Room.inMemoryDatabaseBuilder(
            InstrumentationRegistry.getContext(),
            RestaurantDatabase::class.java
        ).build()
    }

    @After
    fun closeDb() {
        if (::database.isInitialized)
            database.close()
    }

    @Test
    fun insertRestaurantAndGetAll() {
        val gson = Gson()
        var restaurant = gson.fromJson<Restaurant>(json, Restaurant::class.java)
        database.restaurantDao().insertRestaurant(restaurant)
        val lists = database.restaurantDao().getAllRestaurants()


        // The loaded data contains the expected values
        lists[0].run {
            assertEquals(25.037628, geometry?.location?.lat)
            assertEquals(121.5429943, geometry?.location?.lng)
            assertEquals(800, restaurant.photos.last()?.height)
            assertEquals(1200, restaurant.photos.last()?.width)
        }
    }


    companion object {
        val json =
            """{"geometry": {"location": {"lat": 25.037628,"lng": 121.5429943},"viewport": {"northeast": {"lat": 25.0390619302915,"lng": 121.5443446302915},"southwest": {"lat": 25.0363639697085,"lng": 121.5416466697085}}},"icon": "https://maps.gstatic.com/mapfiles/place_api/icons/restaurant-71.png","id": "cfbf752163976570a3e02337dd12f01d4ab44057","name": "花園大道(自助餐) Park Avenue-台北福華大飯店","opening_hours": {"open_now": false},"photos": [{"height": 800,"html_attributions": ["<a href=\"https://maps.google.com/maps/contrib/115557320280344157714/photos\">花園大道自助餐 Park Avenue- 台北福華大飯店</a>"],"photo_reference": "CmRaAAAAm9Jg9BUbpleOfAFUwI85UjmQh4QGb-2YAK5tk_oi1cMgliTpzeeRuaJu4ipWFps5Xy-ZhFM50L2iu2kKoUo7Ip-xe9j48aZq7qPHu1QqaH12rHT9LzRAoQC7i9Jv7KBpEhALgROVKOqbEEfcE5R4kTxIGhS4qRLq5Vbq1C1uSsIPH-Q9NrwJiQ","width": 1200}],"place_id": "ChIJRW2USNGrQjQR7bfTlD-BGjo","plus_code": {"compound_code": "2GQV+35 台灣台北市大安區","global_code": "7QQ32GQV+35"},"price_level": 2,"rating": 4.1,"reference": "ChIJRW2USNGrQjQR7bfTlD-BGjo","scope": "GOOGLE","types": ["restaurant","food","point_of_interest","establishment"],"user_ratings_total": 439,"vicinity": "大安區仁愛路三段160號4樓"}"""
    }

}