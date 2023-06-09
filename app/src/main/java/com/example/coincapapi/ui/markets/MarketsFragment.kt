package com.example.coincapapi.ui.markets

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.example.coincapapi.data.model.markets.MarketsModel
import com.example.coincapapi.databinding.FragmentMarketsBinding

class MarketsFragment : Fragment() {

    private var _binding: FragmentMarketsBinding? = null
    private val binding get() = _binding!!
    private lateinit var marketsViewModel: MarketsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        marketsViewModel =
            ViewModelProvider(this).get(MarketsViewModel::class.java)

        _binding = FragmentMarketsBinding.inflate(inflater, container, false)

        marketsViewModel.markets.observe(viewLifecycleOwner) {
            it?.let {
                setupUI(it)
            }
        }

        marketsViewModel.getMarket()

        return binding.root
    }

    private fun setupUI(markets: MarketsModel) {
        binding.rvMarkets.apply {
            layoutManager = GridLayoutManager(context, 2)
            adapter = MarketsAdapter(markets?.data?.sortedBy { it?.baseSymbol })

        }
    }


}