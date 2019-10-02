package ohyeah5566.whattoeat

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.room.Room
import androidx.viewpager.widget.PagerAdapter
import kotlinx.android.synthetic.main.item_restaurant.view.*

class ResaurantAdapter(val context: Context, val list:List<Restaurant>) : PagerAdapter(){
    private var database = Room.databaseBuilder(context,RestaurantDatabase::class.java,"Restaurant").build()

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val view = LayoutInflater.from(context).inflate(R.layout.item_restaurant,container,false)
        val restaurant = list[position]

        with(view){
            tv_name.text = restaurant.name
            tv_rating.text = restaurant.rating.toString()
            tv_rating_totals.text = restaurant.userRatingsTotal.toString()
            btn_like.setOnClickListener {
                database.restaurantDao().insertRestaurant(list[position])
            }
        }
        container.addView(view)
        return view
    }

    override fun isViewFromObject(view: View, any: Any): Boolean {
        return view == any
    }

    override fun getCount() = list.size

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        super.destroyItem(container, position, `object`)
    }

}