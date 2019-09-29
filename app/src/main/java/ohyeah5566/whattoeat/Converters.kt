package ohyeah5566.whattoeat

import android.location.Location
import androidx.room.TypeConverter

class Converters {
    @TypeConverter
    fun LocationToString(location: Location): String {
        return "${location.latitude},${location.longitude}"
    }

    @TypeConverter
    fun StringToLocation(string: String?): Location {
        var lists = string?.split(",")
        return Location("").apply{
            latitude = lists?.get(0)?.toDouble()!!
            longitude = lists?.get(1)?.toDouble()!!
        }
    }
}