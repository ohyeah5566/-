package ohyeah5566.whattoeat

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.text.SpannableString
import android.text.style.UnderlineSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.room.Room
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_restaurant.view.*

class RestaurantAdapter(private val context: Context, private val list:List<Restaurant>) : PagerAdapter(){
    private var database = Room.databaseBuilder(context,RestaurantDatabase::class.java,"Restaurant").build()

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val view = LayoutInflater.from(context).inflate(R.layout.item_restaurant,container,false)
        val restaurant = list[position]

        with(view){
            tv_name.text = restaurant.name
            tv_rating.text = restaurant.rating.toString()
            rating_bar.rating = restaurant.rating.toFloat()
            tv_rating_totals.text = "(${restaurant.userRatingsTotal})"
            with(cover){
                Glide.with(context)
                    .load("https://maps.googleapis.com/maps/api/place/photo?maxwidth=1080&photoreference=${restaurant.photos?.last()?.photoReference}&key=AIzaSyDoeMyPmVAF8LFkr5oATdAVOcL7ddqsfUU")
                    .into(this)
            }
            with(tv_address){
                text = restaurant.vicinity
                setOnClickListener { //跳轉至google map
                    var uri = Uri.parse("geo:0,0?q=${restaurant.vicinity}")
                    var intent = Intent(Intent.ACTION_VIEW,uri)
                    intent.setPackage("com.google.android.apps.maps")
                    context.startActivity(intent)
                }
            }
            btn_like.setOnClickListener {
                database.restaurantDao().insertRestaurant(list[position])
                onButtonClick?.goNextItem()
            }
            btn_nope.setOnClickListener {
                onButtonClick?.goNextItem()
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
        (container as ViewPager).removeView(`object` as View)
    }


    private var onButtonClick:OnButtonClick? = null

    fun setOnButtonClick(listener : OnButtonClick){
        onButtonClick = listener
    }

    interface OnButtonClick{
        fun goNextItem()
    }

}