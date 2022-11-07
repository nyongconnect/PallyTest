package com.example.pallytest.presentation.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pallytest.R
import com.example.pallytest.databinding.LayoutEventItemBinding
import com.example.pallytest.model.EventModel

class EventAdapter (private val context: Context, val onClick: (EventModel) -> Unit) : RecyclerView.Adapter<EventAdapter.EventViewHolder>() {

    private var events = emptyList<EventModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventViewHolder {
        return EventViewHolder(LayoutEventItemBinding.bind(LayoutInflater.from(context).inflate(
            R.layout.layout_event_item, parent, false)))
    }

    override fun onBindViewHolder(holder: EventViewHolder, position: Int) {
        holder.bind(events[position])
    }

    override fun getItemCount(): Int = events.size

    @SuppressLint("NotifyDataSetChanged")
    fun update(events: List<EventModel>) {
        this.events = events
        notifyDataSetChanged()
    }

    inner class EventViewHolder(val binding: LayoutEventItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(element: EventModel) {
           // binding.txtMilongasName.text = element.name
            itemView.setOnClickListener {
                //onClick.invoke(element)
            }
        }
    }
}
