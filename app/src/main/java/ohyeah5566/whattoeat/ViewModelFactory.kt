package ohyeah5566.whattoeat

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class ViewModelFactory constructor(
    private val webservice: Webservice
) : ViewModelProvider.NewInstanceFactory() {

    /**
     * 這邊因為when會直接return MainViewModel(webservice)
     * with會將最後一行回傳 再轉成(as) T 即可
     *
     * isAssignableFrom 判斷class or interface 是否有繼承關係 或是自己本身
     */
    override fun <T : ViewModel?> create(modelClass: Class<T>) =
        with(modelClass) {
            when {
                isAssignableFrom(MainViewModel::class.java) ->
                    MainViewModel(webservice)
                else ->
                    throw IllegalArgumentException("Unknown ViewModel class: ${modelClass.name}")
            }
        } as T

}