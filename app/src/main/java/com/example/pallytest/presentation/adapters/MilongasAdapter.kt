package com.example.pallytest.presentation.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pallytest.R
import com.example.pallytest.databinding.LayoutMilongasItemBinding
import com.example.pallytest.model.MilongasModel

class MilongasAdapter (private val context: Context, val onClick: (MilongasModel) -> Unit) : RecyclerView.Adapter<MilongasAdapter.MilongasViewHolder>() {

    private var countries = emptyList<MilongasModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MilongasViewHolder {
        return MilongasViewHolder(LayoutMilongasItemBinding.bind(LayoutInflater.from(context).inflate(
            R.layout.layout_milongas_item, parent, false)))
    }

    override fun onBindViewHolder(holder: MilongasViewHolder, position: Int) {
        holder.bind(countries[position])
    }

    override fun getItemCount(): Int = countries.size

    @SuppressLint("NotifyDataSetChanged")
    fun update(countries: List<MilongasModel>) {
        this.countries = countries
        notifyDataSetChanged()
    }

    inner class MilongasViewHolder(val binding: LayoutMilongasItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(element: MilongasModel) {
            binding.txtMilongasName.text = element.name
            itemView.setOnClickListener {
                //onClick.invoke(element)
            }
        }
    }
}
