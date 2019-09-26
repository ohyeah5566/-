package ohyeah5566.whattoeat

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface RestaurantDao{
    @Query("SELECT * FROM Restaurant")
    fun getAllRestaurants(): List<Restaurant>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertRestaurant(restaurant: Restaurant):Long


}