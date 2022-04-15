package waslim.binar.andlima.latihanlistcountry.network


import retrofit2.Call
import retrofit2.http.GET
import waslim.binar.andlima.latihanlistcountry.model.GettAllCountryResponseItem

interface ApiService {

    @GET("all")
    fun getDataCountry () : Call<List<GettAllCountryResponseItem>>

}