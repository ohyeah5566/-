package ohyeah5566.whattoeat

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "Restaurant")
data class Restaurant constructor(
    @PrimaryKey
    @ColumnInfo(name = "id")
    var id: String = "",
    @ColumnInfo(name = "geometry")
    var geometry: Geometry?,
    @ColumnInfo(name = "name")
    var name: String = "",
    @ColumnInfo(name = "rating")
    var rating: Double = 5.0,
    @ColumnInfo(name = "user_ratings_total")
    var userRatingsTotal: Int = 10,
    @ColumnInfo(name = "price_level")
    var priceLevel: Int = 0,
    @ColumnInfo(name = "vicinity")
    var vicinity: String = "", //地址
    @ColumnInfo(name = "place_id")
    @SerializedName("place_id")
    var placeId: String = "", //拿餐廳詳細資料
    @ColumnInfo(name = "photos")
    val photos: List<Photos?> //Photos的結構是JSONArray的方式 因此這邊是用List<Photos>
)

/**
 * 用Gson遇到nested jsonObject 只要再創一個對應的物件名稱就可以轉了
 *  "geometry": {
 *      "location": {
 *      "lat": 25.037628,
 *      "lng": 121.5429943
 *      }...下略
 *  }
 */
data class Geometry(
    val location: Location
)

data class Location(
    val lat: Double = 0.0,
    val lng: Double = 0.0
)

data class Photos(
    val height: Int,
    val width: Int,
    @SerializedName("photo_reference")
    val photoReference: String
)