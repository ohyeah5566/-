package ohyeah5566.whattoeat

import android.os.Handler
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MyVm : ViewModel(){
    var dataModel = DataModel()
    var info = MutableLiveData<Info>()

    var userInput = ""

    fun doGetData() {

        Handler().postDelayed(object : Runnable {
            override fun run() {

                /*通知Activity刷新数据*/
                info.value = dataModel.getData(userInput)

            }
        }, 3000)
    }

}