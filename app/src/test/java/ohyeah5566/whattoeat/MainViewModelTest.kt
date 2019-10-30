package ohyeah5566.whattoeat

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import org.junit.Assert.assertEquals
import org.junit.Test

import org.junit.Before
import org.junit.Rule

class MainViewModelTest {


    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    //可以用annotation的方式將webservice設成Mock物件
    @MockK
    private lateinit var webservice: Webservice

    //也可以用以下的方式
//    private var webservice = mockk<Webservice>()

    private lateinit var viewModel: MainViewModel

    @Before
    fun setup() {
        MockKAnnotations.init(this) //初始化Mock物件
        viewModel = MainViewModel(webservice)
    }

    /**
     * 測試正常的取得Todo資料流程
     */
    @Test
    fun testNormalGetTodo() {
        //因為getTodo是suspend的關係 因此這邊用coEvery+returns的方式,mockk的函式庫
        //當getTodo的Id是30時 會模擬回傳的資料為“Todo(30, "17:30 Go home", false)”
        coEvery {
            webservice.getTodo(30)
        } returns Todo(id, title, completed)

        //這邊模擬LiveData 註冊viewModel.result只要資料有變就會觸發
        viewModel.result.observeForever {
            assertEquals(id, it.id)
            assertEquals(title, it.titles)
            assertEquals(completed, it.completed)
        }

        viewModel.getTodo(30)
    }

    companion object {
        const val id = 30
        const val title = "17:30 Go home"
        const val completed = false
    }
}