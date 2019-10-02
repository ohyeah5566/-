package ohyeah5566.whattoeat

import android.location.Location
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.json.JSONObject

@Entity(tableName = "Restaurant")
data class Restaurant constructor(var result: String) {
    @PrimaryKey
    @ColumnInfo(name = "id")
    var id = ""
    @ColumnInfo(name = "location")
    var location = Location("")
    @ColumnInfo(name = "name")
    var name = ""
    @ColumnInfo(name = "rating")
    var rating = 5.0
    @ColumnInfo(name = "user_ratings_total")
    var userRatingsTotal = 10
    @ColumnInfo(name = "price_level")
    var priceLevel = 0
    @ColumnInfo(name = "vicinity")
    var vicinity = "" //地址
    @ColumnInfo(name = "place_id")
    var placeId = "" //拿餐廳詳細資料
    @ColumnInfo(name = "photo_reference")
    var photoReference = "" //拿圖片 ?

    init {
        JSONObject(result).run {
            id = getString("id")
            name = getString("name")
            rating = getDouble("rating")
            userRatingsTotal = getInt("user_ratings_total")
            priceLevel = getInt("price_level")
            vicinity = getString("vicinity")
            placeId = getString("place_id")
            photoReference = getJSONArray("photos").getJSONObject(0).getString("photo_reference")
            with(location){
                getJSONObject("geometry").getJSONObject("location").also {
                    latitude = it.getDouble("lat")
                    longitude= it.getDouble("lng")
                }
            }

        }
    }


}