package ohyeah5566.whattoeat

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters


@Database(entities = [Restaurant::class] , version = 1)
@TypeConverters(Converters::class)
abstract class RestaurantDatabase : RoomDatabase(){

    abstract fun restaurantDao():RestaurantDao

    companion object{
        private var INSTANCE: RestaurantDatabase? = null

        private val lock = Any()

        fun getInstance(context: Context): RestaurantDatabase {
            synchronized(lock) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.applicationContext,
                        RestaurantDatabase::class.java, "Restaurants.db")
                        .build()
                }
                return INSTANCE!!
            }
        }
    }

}