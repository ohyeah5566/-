package ohyeah5566.whattoeat

import retrofit2.http.GET
import retrofit2.http.Path

interface Webservice {
    @GET("/todos/{id}")
    suspend fun getTodo(@Path(value = "id") todoId: Int): Todo
}