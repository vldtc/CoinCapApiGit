package com.example.coincapapi.ui.assets.assetsdetails

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.coincapapi.R
import com.example.coincapapi.data.model.assets.AssetsDataModel
import com.example.coincapapi.data.model.exchanges.ExchangesDataModel
import com.example.coincapapi.databinding.FragmentAssetsDetailsBinding
import com.example.coincapapi.databinding.FragmentExchangeDetailsBinding
import com.example.coincapapi.ui.exchanges.exchangesdetails.ExchangeDetailsViewModel

class AssetsDetailsFragment : Fragment() {

    private var _binding: FragmentAssetsDetailsBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: AssetsDetailsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel =
            ViewModelProvider(this)[AssetsDetailsViewModel::class.java]
        _binding = FragmentAssetsDetailsBinding.inflate(inflater, container, false)

        val assets = arguments?.getSerializable("AssetsItem") as AssetsDataModel

        binding.tvAssetsName.text = assets.name


        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(AssetsDetailsViewModel::class.java)
        // TODO: Use the ViewModel
    }

}