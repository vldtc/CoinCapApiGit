package com.example.coincapapi.ui.exchanges

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.coincapapi.R
import com.example.coincapapi.data.model.assets.AssetsDataModel
import com.example.coincapapi.data.model.assets.AssetsModel
import com.example.coincapapi.data.model.exchanges.ExchangesDataModel
import com.example.coincapapi.data.model.exchanges.ExchangesModel
import com.example.coincapapi.databinding.ItemAssetBinding
import com.example.coincapapi.databinding.ItemExchangeBinding

class ExchangesAdapter(val exchanges: ExchangesModel?) :
    RecyclerView.Adapter<ExchangesAdapter.ViewHolder>() {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding = ItemExchangeBinding.bind(view)

        fun handleData(item: ExchangesDataModel?) {
            item?.let {
                with(it) {
                        binding.tvRank.text = "#$rank"
                        binding.tvName.text = name
                        binding.tvVolumeUsd.text = volumeUsd
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExchangesAdapter.ViewHolder {
        //creates item/row for the UI

        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_exchange, parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount(): Int = exchanges?.data?.size ?: 0
    //size of the list


    override fun onBindViewHolder(holder: ExchangesAdapter.ViewHolder, position: Int) {
        //handle the current item u r on
        val rdModel = exchanges?.data?.get(position)
        holder?.handleData(rdModel)
    }

}
