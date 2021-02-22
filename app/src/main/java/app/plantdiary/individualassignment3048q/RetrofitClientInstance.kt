package app.plantdiary.individualassignment3048q

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClientInstance {

    //private vals
    private var retrofit: Retrofit? = null;
    private val BASE_URL = "https://pkgstore.datahub.io"

    //public vals. Can have getters right here!
    val retrofitInstance : Retrofit?
        get() {
            //has this object been created yet?
            if (retrofit == null) {
                retrofit = retrofit2.Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return retrofit
        }
}