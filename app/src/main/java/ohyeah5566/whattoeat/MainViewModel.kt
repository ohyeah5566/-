package ohyeah5566.whattoeat

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.*

class MainViewModel(private val webService: Webservice) : ViewModel() {

    private var count = 1
    var result = MutableLiveData<Todo>()

    fun getTodo() {
        viewModelScope.launch {
            result.value = webService.getTodo(count++) //因為getTodo有加suspend 因此這行不是在uiThread執行
        }
    }

    fun getTodo(id:Int) {
        CoroutineScope(Dispatchers.Unconfined + SupervisorJob()).launch {
            result.value = webService.getTodo(id) //因為getTodo有加suspend 因此這行不是在uiThread執行
        }
    }
}