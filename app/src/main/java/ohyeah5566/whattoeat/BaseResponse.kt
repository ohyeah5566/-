package ohyeah5566.whattoeat

import com.google.gson.annotations.SerializedName

data class BaseResponse(
    @SerializedName("next_page_token")
    val nextPageToken: String,
    val results: List<Restaurant>,
    val status: String,
    @SerializedName("error_message")
    val errorMessage: String
)