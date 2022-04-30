package waslim.binar.andlima.latihanlistcountry.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import waslim.binar.andlima.latihanlistcountry.R
import waslim.binar.andlima.latihanlistcountry.adapter.AdapterCountry
import waslim.binar.andlima.latihanlistcountry.model.GettAllCountryResponseItem
import waslim.binar.andlima.latihanlistcountry.network.ApiClient
import waslim.binar.andlima.latihanlistcountry.viewmodel.ViewModelCountry

class MainActivity : AppCompatActivity() {
    lateinit var adapterCountry: AdapterCountry

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapterCountry = AdapterCountry()

        initRecycler()
    }

    private fun initRecycler(){
        rvCountry.layoutManager = LinearLayoutManager(this)
        rvCountry.adapter = adapterCountry
        initViewModel()
    }

    private fun initViewModel(){
        val viewModel = ViewModelProvider(this).get(ViewModelCountry::class.java)

        viewModel.liveGetDataCountry().observe(this, Observer {
            if ( it != null){
                adapterCountry.setDataCountry(it)
                adapterCountry.notifyDataSetChanged()
            }
        })

        viewModel.getDataCountry()
    }

}