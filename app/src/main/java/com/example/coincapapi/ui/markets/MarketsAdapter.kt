package com.example.coincapapi.ui.markets

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.coincapapi.R
import com.example.coincapapi.data.model.assets.AssetsDataModel
import com.example.coincapapi.data.model.assets.AssetsModel
import com.example.coincapapi.data.model.markets.MarketsDataModel
import com.example.coincapapi.data.model.markets.MarketsModel
import com.example.coincapapi.databinding.ItemAssetBinding
import com.example.coincapapi.databinding.ItemMarketBinding

class MarketsAdapter(val markets: MarketsModel?) :
    RecyclerView.Adapter<MarketsAdapter.ViewHolder>() {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding = ItemMarketBinding.bind(view)

        fun handleData(item: MarketsDataModel?) {
            item?.let {
                with(it) {
                    binding.tvBaseSymbol.text = baseSymbol
                    binding.tvQuoteSymbol.text = quoteSymbol
                    binding.tvPriceUsd.text = priceUsd
                    binding.tvTradesCount.text = tradesCount24Hr
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MarketsAdapter.ViewHolder {
        //creates item/row for the UI

        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_market, parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount(): Int = markets?.data?.size ?: 0
    //size of the list


    override fun onBindViewHolder(holder: MarketsAdapter.ViewHolder, position: Int) {
        //handle the current item u r on
        val rdModel = markets?.data?.get(position)
        holder?.handleData(rdModel)
    }

}
