package waslim.binar.andlima.latihanlistcountry.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import waslim.binar.andlima.latihanlistcountry.R
import waslim.binar.andlima.latihanlistcountry.adapter.AdapterCountry
import waslim.binar.andlima.latihanlistcountry.model.GettAllCountryResponseItem
import waslim.binar.andlima.latihanlistcountry.network.ApiClient

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getDataCountry()
    }

    private fun getDataCountry(){
        ApiClient.instance.getDataCountry()
            .enqueue(object : Callback<List<GettAllCountryResponseItem>>{
                override fun onResponse(
                    call: Call<List<GettAllCountryResponseItem>>,
                    response: Response<List<GettAllCountryResponseItem>>
                ) {
                    if (response.isSuccessful){
                        val dataCountry = response.body()
                        val adaptCountry = AdapterCountry(dataCountry!!)
                        val lm = LinearLayoutManager(applicationContext, LinearLayoutManager.VERTICAL, false)
                        rvCountry.layoutManager = lm
                        rvCountry.adapter = adaptCountry
                    } else{
                        Toast.makeText(this@MainActivity, response.message(), Toast.LENGTH_LONG).show()
                    }
                }

                override fun onFailure(call: Call<List<GettAllCountryResponseItem>>, t: Throwable) {
                    Toast.makeText(this@MainActivity, t.message, Toast.LENGTH_LONG).show()
                }

            })
    }

    override fun onResume() {
        super.onResume()
        getDataCountry()
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}