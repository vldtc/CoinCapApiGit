package com.example.coincapapi.ui.rates

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.coincapapi.R
import com.example.coincapapi.data.model.assets.AssetsDataModel
import com.example.coincapapi.data.model.assets.AssetsModel
import com.example.coincapapi.data.model.rates.RatesDataModel
import com.example.coincapapi.data.model.rates.RatesModel
import com.example.coincapapi.databinding.ItemAssetBinding
import com.example.coincapapi.databinding.ItemRatesBinding

class RatesAdapter(val rates: RatesModel?) :
    RecyclerView.Adapter<RatesAdapter.ViewHolder>() {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding = ItemRatesBinding.bind(view)

        fun handleData(item: RatesDataModel?) {
            item?.let {
                with(it) {
                    binding.tvSymbol.text = symbol
                    binding.tvRateUsd.text = rateUsd

                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RatesAdapter.ViewHolder {
        //creates item/row for the UI

        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_rates, parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount(): Int = rates?.data?.size ?: 0
    //size of the list


    override fun onBindViewHolder(holder: RatesAdapter.ViewHolder, position: Int) {
        //handle the current item u r on
        val rdModel = rates?.data?.get(position)
        holder?.handleData(rdModel)
    }

}
