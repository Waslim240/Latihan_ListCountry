package waslim.binar.andlima.latihanlistcountry.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_country_adapter.view.*
import waslim.binar.andlima.latihanlistcountry.R
import waslim.binar.andlima.latihanlistcountry.model.GettAllCountryResponseItem

class AdapterCountry() : RecyclerView.Adapter<AdapterCountry.ViewHolder> () {

    private var datacountry : List<GettAllCountryResponseItem>? = null

    fun setDataCountry(listCountry : List<GettAllCountryResponseItem>){
        this.datacountry = listCountry
    }

    class ViewHolder(itemview : View) : RecyclerView.ViewHolder(itemview){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterCountry.ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_country_adapter, parent, false)
        return ViewHolder(itemView)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: AdapterCountry.ViewHolder, position: Int) {
        holder.itemView.nameTv.text = datacountry!![position].name
        holder.itemView.capitalTv.text = "Capital : ${datacountry!![position].capital}"
        holder.itemView.regionTv.text = "Region : ${datacountry!![position].region}"
        holder.itemView.population.text = "Population : ${datacountry!![position].population}"
        Glide.with(holder.itemView.context).load(datacountry!![position].flags.png).into(holder.itemView.imageView)


    }

    override fun getItemCount(): Int {
        return if (datacountry == null){
            0
        } else {
            datacountry!!.size
        }
    }

}