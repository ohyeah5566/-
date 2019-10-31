package ohyeah5566.whattoeat

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.google.gson.GsonBuilder
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    private lateinit var mainViewModel: MainViewModel

    private val webService by lazy {
        Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build().create(Webservice::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //測試可以直接 new MainViewModel(webService)
        //不過在Activity用ViewModelProviders產生 可以讓onCreate被再次呼叫時取得原本的ViewModel
        mainViewModel =
            ViewModelProviders.of(this, ViewModelFactory(webService)).get(MainViewModel::class.java)

        btn_loadData.setOnClickListener {
            mainViewModel.getTodo()
        }

        mainViewModel.result.observe(this, Observer {
            tv_message.text = it.toString()
        })
    }
}
