package ohyeah5566.whattoeat

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.gson.GsonBuilder
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainViewModel : ViewModel() {

    private var count = 1
    var result = MutableLiveData<Todo>()

    private val webService by lazy {
        Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build().create(Webservice::class.java)
    }

    fun getTodo() {
        viewModelScope.launch {
            result.value = webService.getTodo(count++) //因為getTodo有加suspend 因此這行不是在uiThread執行
        }
    }
}