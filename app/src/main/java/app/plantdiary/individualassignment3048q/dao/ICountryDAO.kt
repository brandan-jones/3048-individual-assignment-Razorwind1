package app.plantdiary.individualassignment3048q.dao

import app.plantdiary.individualassignment3048q.dto.Country
import retrofit2.Call
import retrofit2.http.GET

interface ICountryDAO {

    @GET("/core/country-list/data_json/data/8c458f2d15d9f2119654b29ede6e45b8/data_json.json")
    fun fetchCountries(): Call<ArrayList<Country>>

}