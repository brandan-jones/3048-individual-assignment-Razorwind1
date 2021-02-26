package app.plantdiary.individualassignment3048q.service

import androidx.lifecycle.MutableLiveData
import app.plantdiary.individualassignment3048q.RetrofitClientInstance
import app.plantdiary.individualassignment3048q.dao.ICountryDAO
import app.plantdiary.individualassignment3048q.dto.Country
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CountryService {
    fun fetchCountries() : MutableLiveData<ArrayList<Country>> {
        val _countries = MutableLiveData<ArrayList<Country>>()

        //This is a Retrofit service (see RetrofitClientInstance.kt)
        val service = RetrofitClientInstance.retrofitInstance?.create(ICountryDAO::class.java)
        //this is a call of the JSON stream of countries (see ICountryDAO.kt)
        val call = service?.fetchCountries()
        //enqueue() puts the call before into a "queue" for asynchronous calling
        call?.enqueue(object: Callback<ArrayList<Country>> {
            /**
             * Invoked for a received HTTP response.
             * Note: An HTTP response may still indicate an application-level failure such as a 404 or 500.
             * Call [Response.isSuccessful] to determine if the response indicates success.
             */
            override fun onResponse(
                call: Call<ArrayList<Country>>,
                response: Response<ArrayList<Country>>
            ) {
                _countries.value = response.body()
            }

            /**
             * Invoked when a network exception occurred talking to the server or when an unexpected exception
             * occurred creating the request or processing the response.
             */
            override fun onFailure(call: Call<ArrayList<Country>>, t: Throwable) {
//                val j = 1 + 1
//                val i = 1 + 1
            }
        })

        return _countries
    }

}