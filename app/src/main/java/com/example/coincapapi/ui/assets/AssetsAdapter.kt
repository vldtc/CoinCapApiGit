package com.example.coincapapi.ui.assets

import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.os.bundleOf
import androidx.recyclerview.widget.RecyclerView
import com.example.coincapapi.R
import com.example.coincapapi.data.model.assets.AssetsDataModel
import com.example.coincapapi.data.model.assets.AssetsModel
import com.example.coincapapi.databinding.ItemAssetBinding
import com.example.coincapapi.ui.detailsFragment

class AssetsAdapter(val assets: AssetsModel?) :
    RecyclerView.Adapter<AssetsAdapter.ViewHolder>() {
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

    override fun getItemCount(): Int = assets?.data?.size ?: 0
    //size of the list


    override fun onBindViewHolder(holder: AssetsAdapter.ViewHolder, position: Int) {
        //handle the current item u r on
        val rdModel = assets?.data?.get(position)
        holder?.handleData(rdModel)
    }





}

