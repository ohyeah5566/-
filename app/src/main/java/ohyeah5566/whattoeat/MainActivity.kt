package ohyeah5566.whattoeat

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewpager.adapter = ResaurantAdapter(this,list)


    }



    companion object{
        var restaurant1 = Restaurant("{\n" +
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

        val restaurant2 = Restaurant("{\n" +
                "         \"geometry\": {\n" +
                "            \"location\": {\n" +
                "               \"lat\": 25.0283003,\n" +
                "               \"lng\": 121.5563756\n" +
                "            },\n" +
                "            \"viewport\": {\n" +
                "               \"northeast\": {\n" +
                "                  \"lat\": 25.0295822302915,\n" +
                "                  \"lng\": 121.5576826802915\n" +
                "               },\n" +
                "               \"southwest\": {\n" +
                "                  \"lat\": 25.0268842697085,\n" +
                "                  \"lng\": 121.5549847197085\n" +
                "               }\n" +
                "            }\n" +
                "         },\n" +
                "         \"icon\": \"https://maps.gstatic.com/mapfiles/place_api/icons/restaurant-71.png\",\n" +
                "         \"id\": \"3bb90a7db5e90cbea6fcabac427888a25a4508e8\",\n" +
                "         \"name\": \"Tajin Moroccan Cuisine\",\n" +
                "         \"opening_hours\": {\n" +
                "            \"open_now\": true\n" +
                "         },\n" +
                "         \"photos\": [\n" +
                "            {\n" +
                "               \"height\": 3024,\n" +
                "               \"html_attributions\": [\n" +
                "                  \"<a href=\\\"https://maps.google.com/maps/contrib/118225768998386278034/photos\\\">Quentin Yang</a>\"\n" +
                "               ],\n" +
                "               \"photo_reference\": \"CmRaAAAA4GyNlmlIsJ3W8gj31xxG5bHIga_Ws9zRLHMXDVa-Htf_WfuCSgw4rL2tBsgkmwW7ghYd7SFWwhJddVgnpht2GozewQFnO4c0bjFzCOMMdYr4MY-UEaDch7xCMQrhjyjVEhDHu2vPalLa3qAOwJn6KQNJGhRgiutUFu7py37lKW2n2UNjucdxaw\",\n" +
                "               \"width\": 4032\n" +
                "            }\n" +
                "         ],\n" +
                "         \"place_id\": \"ChIJOQxXLcurQjQRdA2IH0xpZ60\",\n" +
                "         \"plus_code\": {\n" +
                "            \"compound_code\": \"2HH4+8H Da’an District, Taipei City, Taiwan\",\n" +
                "            \"global_code\": \"7QQ32HH4+8H\"\n" +
                "         },\n" +
                "         \"price_level\": 2,\n" +
                "         \"rating\": 4.6,\n" +
                "         \"reference\": \"ChIJOQxXLcurQjQRdA2IH0xpZ60\",\n" +
                "         \"scope\": \"GOOGLE\",\n" +
                "         \"types\": [\n" +
                "            \"restaurant\",\n" +
                "            \"food\",\n" +
                "            \"point_of_interest\",\n" +
                "            \"establishment\"\n" +
                "         ],\n" +
                "         \"user_ratings_total\": 1210,\n" +
                "         \"vicinity\": \"No. 3號, Lane 144, Section 2, Jilong Road, Da’an District\"\n" +
                "      }")
        var list = listOf(restaurant1, restaurant2)
    }
}
