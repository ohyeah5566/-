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
    var id: String = ""
//    @ColumnInfo(name = "location")
//    lateinit var location: Location
    @ColumnInfo(name = "name")
    var name: String = ""
    @ColumnInfo(name = "rating")
    var rating: Double = 5.0
    @ColumnInfo(name = "user_ratings_totals")
    var userRatingsTotals: Int = 10

    init {
        var jsonObject = JSONObject(result)
        id = jsonObject.getString("id")
//        location = jsonObject.get("location") as Location
        name = jsonObject.getString("name")
        rating = jsonObject.getDouble("rating")
//        userRatingsTotals = jsonObject.getInt("user_ratings_totals")
    }


}