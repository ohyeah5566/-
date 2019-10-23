package ohyeah5566.whattoeat

import com.google.gson.annotations.SerializedName

data class Todo(
    val id: Int = 0,
    @SerializedName(value="title") val titles: String = "",
    val completed: Boolean = false
)