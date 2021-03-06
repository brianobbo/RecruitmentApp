package com.clakestudio.pc.countries.adapters.details

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.clakestudio.pc.countries.databinding.DetailBinding

class DetailAdapter(
) : RecyclerView.Adapter<DetailAdapter.DetailViewHolder>() {

    private val details: ArrayList<Pair<String, String?>> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = DetailBinding.inflate(inflater, parent, false)
        return DetailViewHolder(binding)
    }

    override fun getItemCount(): Int = details.size


    override fun onBindViewHolder(holder: DetailViewHolder, position: Int) {
        holder.bind(details[position].first, details[position].second!!)
    }

    class DetailViewHolder(private val binding: DetailBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(name: String, value: String) {
            binding.textViewDetailName.text = name
            binding.textViewDetailValue.text = value
        }
    }

    private fun setDetails(details: ArrayList<Pair<String, String?>>) {
        this.details.clear()
        details.forEach{
            if(it.second!=null && it.second!!.isNotEmpty())
                this.details.add(it)

        }
        notifyDataSetChanged()
    }

    fun replaceData(details: ArrayList<Pair<String, String?>>) = setDetails(details)
}