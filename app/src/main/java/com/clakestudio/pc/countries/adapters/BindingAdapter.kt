package com.clakestudio.pc.countries.adapters

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView

object BindingAdapter {

    @JvmStatic
    @BindingAdapter("app:countries")
    fun setCountries(recyclerView: RecyclerView, countries: ArrayList<String>) {
        with(recyclerView.adapter as CountryAdapter) {
            replaceData(countries)
        }
    }

}