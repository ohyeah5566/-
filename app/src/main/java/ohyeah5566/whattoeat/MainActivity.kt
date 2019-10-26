package ohyeah5566.whattoeat

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var vm: MyVm

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        vm = ViewModelProviders.of(this).get(MyVm::class.java)

        btn_login.setOnClickListener {
            vm.userInput = et_name.text.toString()
            vm.doGetData()
        }

        vm.info.observe(this,
                Observer<Info> { t -> label_information.text = t?.text })
    }
}