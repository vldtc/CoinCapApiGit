package com.example.coincapapi.ui.rates.ratesdetails

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.coincapapi.R

class RatesDetailsFragment : Fragment() {

    companion object {
        fun newInstance() = RatesDetailsFragment()
    }

    private lateinit var viewModel: RatesDetailsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_rates_details, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(RatesDetailsViewModel::class.java)
        // TODO: Use the ViewModel
    }

}