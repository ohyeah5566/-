package ohyeah5566.whattoeat

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class Converters {
    @TypeConverter
    fun geometryToString(geometry: Geometry): String {
        return "${geometry?.location?.lat},${geometry?.location?.lng}"
    }

    @TypeConverter
    fun stringToGeometry(string: String?): Geometry {
        var lists = string?.split(",")
        val lat = lists?.get(0)?.toDouble()
        val lng = lists?.get(1)?.toDouble()
        return Geometry(Location(lat ?: 0.0, lng ?: 0.0))

    }

    @TypeConverter
    fun photosToString(photos: List<Photos>): String {
        return Gson().toJson(photos)
    }

    @TypeConverter
    fun stringToPhotos(string: String?): List<Photos> {
        val photosType = object : TypeToken<List<Photos>>() {}.type
        return Gson().fromJson<List<Photos>>(string, photosType)
    }
}