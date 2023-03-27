package com.example.coincapapi.ui.assets

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.coincapapi.R
import com.example.coincapapi.data.model.assets.AssetsDataModel
import com.example.coincapapi.databinding.ItemAssetBinding

class AssetsAdapter(val assets: List<AssetsDataModel>?) :
    RecyclerView.Adapter<AssetsAdapter.ViewHolder>() {

    var onItemClick: ((AssetsDataModel) -> Unit)? = null
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding = ItemAssetBinding.bind(view)


        fun handleData(item: AssetsDataModel?) {
            item?.let {
                with(it) {
                    binding.tvRank.text = "#$rank"
                    binding.tvName.text = name
                    binding.tvPriceUsd.text = "Price($): $priceUsd"

                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AssetsAdapter.ViewHolder {
        //creates item/row for the UI

        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_asset, parent, false)
        view.setOnClickListener{
        }

        return ViewHolder(view)
    }

    override fun getItemCount(): Int = assets?.size ?: 0
    //size of the list


    override fun onBindViewHolder(holder: AssetsAdapter.ViewHolder, position: Int) {
        //handle the current item u r on
        val rdModel = assets?.get(position)
        holder?.handleData(rdModel)
        holder.itemView.setOnClickListener{
            assets?.get(position)?.let {
                onItemClick?.invoke(it)
            }
        }
    }





}

