package com.example.coincapapi

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class MarketsDetailsFragment : Fragment() {

    companion object {
        fun newInstance() = MarketsDetailsFragment()
    }

    private lateinit var viewModel: MarketsDetailsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_markets_details, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MarketsDetailsViewModel::class.java)
        // TODO: Use the ViewModel
    }

}