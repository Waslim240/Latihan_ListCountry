package waslim.binar.andlima.latihanlistcountry.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import waslim.binar.andlima.latihanlistcountry.model.GettAllCountryResponseItem
import waslim.binar.andlima.latihanlistcountry.network.ApiClient

class ViewModelCountry : ViewModel() {

    lateinit var liveDataCountry : MutableLiveData<List<GettAllCountryResponseItem>?>

    init {
        liveDataCountry = MutableLiveData()
    }

    fun liveGetDataCountry() : MutableLiveData<List<GettAllCountryResponseItem>?>{
        return liveDataCountry
    }

     fun getDataCountry(){
        ApiClient.instance.getDataCountry()
            .enqueue(object : Callback<List<GettAllCountryResponseItem>> {
                override fun onResponse(
                    call: Call<List<GettAllCountryResponseItem>>,
                    response: Response<List<GettAllCountryResponseItem>>
                ) {
                    if (response.isSuccessful){
                        liveDataCountry.postValue(response.body())
                    } else{
                        liveDataCountry.postValue(null)
                    }
                }

                override fun onFailure(call: Call<List<GettAllCountryResponseItem>>, t: Throwable) {
                    liveDataCountry.postValue(null)
                }

            })
    }

}