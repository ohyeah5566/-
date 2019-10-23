package ohyeah5566.whattoeat

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.gson.GsonBuilder
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val webservice by lazy {
            Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
                .build().create(Webservice::class.java)
        }

        btn_loadData.setOnClickListener {
//            webservice.getTodo(1).execute().body()?.run {
//                tv_message.text = "id = $id \ntitles = $titles \ncompleted = $completed"
//            }
            webservice.getTodo(2).enqueue(object: Callback<Todo>{
                override fun onFailure(call: Call<Todo>, t: Throwable) {
                }

                override fun onResponse(call: Call<Todo>, response: Response<Todo>) {
                    response.body()?.run {
                        tv_message.text = "id = $id \ntitles = $titles \ncompleted = $completed"
                    }
                }
            })
        }

    }
}
