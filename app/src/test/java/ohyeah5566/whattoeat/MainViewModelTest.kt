package ohyeah5566.whattoeat

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.google.gson.Gson
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule

class MainViewModelTest {

    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    @MockK
    private lateinit var service: RestaurantService

    private lateinit var viewModel: MainViewModel

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        viewModel = MainViewModel(service)
    }

    @Test
    fun getRestaurant() {
        coEvery {
            service.getRestaurants("", "", 500, "", "")
        } returns Gson().fromJson<BaseResponse>(
            """html_attributions": ["next_page_token": "CrQCIQEAABfY0b_SXyPByg21UX03oDpN64Lqmugenhd5S-ojjZe2V7wJTa89pUqCNJVX-9Fd1aMEiGtEEDKuzU_j--dCnzD0DfF9uaoEy6tXzNAlxmDv7tFCVdnGxru9lbzISTyNd-g9iD3-QHHzLu2FQ8fKzFLQRBvaseDCG3fdjmLsNqVW21m5gAvTzZGb9MLz_8d-ndQojBSblocED5-f_y6ZtvlJ9FjCjrQHT5eJYU1vrrNuS-Ov0Q_xLoD89ezOMex0yiCezPs-MT9AAzPQLj2TOk6-6dLCyrc1hbjyQsck8kOWkMujQkJ77W7gL21EljHIANvf1xUmt2iFLt7u2EBTPWTHAoAgKbgT5JFVPFVxdpW7RgM81ttxyvDfmdPMoPffYB3rbAMt7r5CvupBlH9lsKsSEMD2fa4bXtLoNPFTiiuXE1AaFDT-s8F8yJu4sTvY1ZAMvzNPOU2K"results":"geometry":"location":"lat": 25.03762"lng": 121.54299"viewport":"northeast":"lat": 25.039061930291"lng": 121.54434463029"southwest":"lat": 25.036363969708"lng": 121.54164666970"icon": "https://maps.gstatic.com/mapfiles/place_api/icons/restaurant-71.png"id": "cfbf752163976570a3e02337dd12f01d4ab44057"name": "花園大道(自助餐) Park Avenue-台北福華大飯店"opening_hours":"open_now": fal"photos":"height": 80"html_attributions":"<a href=\"https://maps.google.com/maps/contrib/115557320280344157714/photos\">花園大道自助餐 Park Avenue- 台北福華大飯店</a"photo_reference": "CmRaAAAAm9Jg9BUbpleOfAFUwI85UjmQh4QGb-2YAK5tk_oi1cMgliTpzeeRuaJu4ipWFps5Xy-ZhFM50L2iu2kKoUo7Ip-xe9j48aZq7qPHu1QqaH12rHT9LzRAoQC7i9Jv7KBpEhALgROVKOqbEEfcE5R4kTxIGhS4qRLq5Vbq1C1uSsIPH-Q9NrwJiQ"width": 12"place_id": "ChIJRW2USNGrQjQR7bfTlD-BGjo"plus_code":"compound_code": "2GQV+35 台灣台北市大安區"global_code": "7QQ32GQV+3"price_level": "rating": 4."reference": "ChIJRW2USNGrQjQR7bfTlD-BGjo"scope": "GOOGLE"types":"restaurant"food"point_of_interest"establishmen"user_ratings_total": 43"vicinity": "大安區仁愛路三段160號4"geometry":"location":"lat": 25.048823"lng": 121.53326"viewport":"northeast":"lat": 25.050174030291"lng": 121.53450728029"southwest":"lat": 25.047476069708"lng": 121.53180931970"icon": "https://maps.gstatic.com/mapfiles/place_api/icons/lodging-71.png"id": "87a07fd354871621773cbbd107525bc16cf8f065"name": "長榮桂冠酒店(台北) Evergreen Laurel Hotel,Taipei"photos":"height": 364"html_attributions":"<a href=\"https://maps.google.com/maps/contrib/105836063235599499350/photos\">長榮桂冠酒店(台北) Evergreen Laurel Hotel,Taipei</a"photo_reference": "CmRZAAAAALPUp7Un6hgO0jnb2lh0_-72t2PjgmwxjqviGM6KYXaqKZN_2y1wimVOUVnXKZf-N86RY_awlfVokJetVtEM2VLcnwj9CDtOOnHe2D7BOFFxzZFHjh6dpFRwA7eNVMoCEhByrsFA8sxRbSduipo42wudGhTKfSY3mW2r7LH3CQ5ENOxJCIPcbQ"width": 54"place_id": "ChIJBzo922OpQjQRJV3Z1pRbT10"plus_code":"compound_code": "2GXM+G8 台灣台北市中山區"global_code": "7QQ32GXM+G"rating": 4."reference": "ChIJBzo922OpQjQRJV3Z1pRbT10"scope": "GOOGLE"types":"lodging"restaurant"food"point_of_interest"establishmen"user_ratings_total": 79"vicinity": "中山區松江路63"status": "OK"}""",
            BaseResponse::class.java
        )
    }
}