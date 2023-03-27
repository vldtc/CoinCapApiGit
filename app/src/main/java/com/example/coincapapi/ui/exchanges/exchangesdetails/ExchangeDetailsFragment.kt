package com.example.coincapapi.ui.exchanges.exchangesdetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.coincapapi.data.model.exchanges.ExchangesDataModel
import com.example.coincapapi.databinding.FragmentExchangeDetailsBinding

class ExchangeDetailsFragment : Fragment() {

    private var _binding: FragmentExchangeDetailsBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: ExchangeDetailsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel =
            ViewModelProvider(this)[ExchangeDetailsViewModel::class.java]
        _binding = FragmentExchangeDetailsBinding.inflate(inflater, container, false)

        val exchanges = arguments?.getSerializable("ExchangesItem") as ExchangesDataModel

        binding.tvExchangesRank.text = "#${exchanges.rank}"
        binding.tvExchangesName.text = exchanges.name
        binding.tvExchangesTradingPairs.text = "Trading pairs\n${exchanges.tradingPairs}"
        binding.tvExchangesExchangeUrl.text = "Website\n${exchanges.exchangeUrl}"
        binding.tvExchangesExchangeID.text = "Symbol ID \n${exchanges.exchangeId}"
        binding.tvExchangesPercentTotalVolume.text = "Total Volume\n${exchanges.percentTotalVolume}"
        binding.tvExchangesSocket.text = exchanges.socket.toString()
        binding.tvExchangesUpdated.text = exchanges.updated.toString()
        binding.tvExchangesVolumeUsd.text = "Volume USD($) \n${exchanges.volumeUsd.toString()}"


        return binding.root
    }

}