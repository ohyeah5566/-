package ohyeah5566.whattoeat

import androidx.room.Room
import androidx.test.InstrumentationRegistry
import androidx.test.runner.AndroidJUnit4
import org.junit.After
import org.junit.Assert
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
        // When inserting a task
        database.restaurantDao().insertRestaurant(DEFAULT_RESTAURANT)

        // When getting the task by id from the database
        val lists = database.restaurantDao().getAllRestaurants()


        // The loaded data contains the expected values
        lists[0].run {
            Assert.assertEquals(rating,4.3,0.1)
            Assert.assertEquals(location.latitude,25.0298581,0.000001)
            Assert.assertEquals(location.longitude,121.5502276,0.000001)
        }
    }



    companion object{
        var DEFAULT_RESTAURANT = Restaurant("{\n" +
                "         \"geometry\": {\n" +
                "            \"location\": {\n" +
                "               \"lat\": 25.0298581,\n" +
                "               \"lng\": 121.5502276\n" +
                "            },\n" +
                "            \"viewport\": {\n" +
                "               \"northeast\": {\n" +
                "                  \"lat\": 25.0312070802915,\n" +
                "                  \"lng\": 121.5515765802915\n" +
                "               },\n" +
                "               \"southwest\": {\n" +
                "                  \"lat\": 25.0285091197085,\n" +
                "                  \"lng\": 121.5488786197085\n" +
                "               }\n" +
                "            }\n" +
                "         },\n" +
                "         \"icon\": \"https://maps.gstatic.com/mapfiles/place_api/icons/restaurant-71.png\",\n" +
                "         \"id\": \"effc67519584719a0f52a13e8bf9e2c48e5cd1ad\",\n" +
                "         \"name\": \"TAJ Sonoma\",\n" +
                "         \"opening_hours\": {\n" +
                "            \"open_now\": true\n" +
                "         },\n" +
                "         \"photos\": [\n" +
                "            {\n" +
                "               \"height\": 290,\n" +
                "               \"html_attributions\": [\n" +
                "                  \"<a href=\\\"https://maps.google.com/maps/contrib/106014224472743494020/photos\\\">Sonoma 焱 牛排館 大安區牛排館美食推薦 台北美食推薦</a>\"\n" +
                "               ],\n" +
                "               \"photo_reference\": \"CmRaAAAAcrFpi7V-oPK9MnwGMUhpNZFlDg7zv00PNJp88boXyuCW1Kq9YIAsbEVygbVtO-5FDJkOgYlJvcyMeuOnXHzSZfbiJjzGC9ds10CsNN_foVdA8VDlWXOAvCKt2_UA9n3jEhDp5V3sjTUz9b73HYGGRVcLGhR_7190b10TiqayMDA7y2wApYy8Ow\",\n" +
                "               \"width\": 635\n" +
                "            }\n" +
                "         ],\n" +
                "         \"place_id\": \"ChIJpUZvnc2rQjQR5gNZmIUpqAo\",\n" +
                "         \"plus_code\": {\n" +
                "            \"compound_code\": \"2HH2+W3 Da’an District, Taipei City, Taiwan\",\n" +
                "            \"global_code\": \"7QQ32HH2+W3\"\n" +
                "         },\n" +
                "         \"price_level\": 3,\n" +
                "         \"rating\": 4.3,\n" +
                "         \"reference\": \"ChIJpUZvnc2rQjQR5gNZmIUpqAo\",\n" +
                "         \"scope\": \"GOOGLE\",\n" +
                "         \"types\": [\n" +
                "            \"restaurant\",\n" +
                "            \"food\",\n" +
                "            \"point_of_interest\",\n" +
                "            \"establishment\"\n" +
                "         ],\n" +
                "         \"user_ratings_total\": 221,\n" +
                "         \"vicinity\": \"No. 22號, Lane 81, Section 2, Dunhua South Road, Da’an District\"\n" +
                "      }")
    }


}