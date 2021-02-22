package app.plantdiary.individualassignment3048q.dto

import com.google.gson.annotations.SerializedName

data class Country(@SerializedName("Code") var code: String, @SerializedName("Name")  var name: String) {
    override fun toString(): String {
        return "$name $code"
    }
}
