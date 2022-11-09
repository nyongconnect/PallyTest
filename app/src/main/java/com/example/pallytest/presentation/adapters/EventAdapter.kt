package com.example.pallytest.presentation.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pallytest.R
import com.example.pallytest.databinding.LayoutEventItemBinding
import com.example.pallytest.model.Event
import com.example.pallytest.model.EventModel
import com.example.pallytest.presentation.utils.loadImage

class EventAdapter (private val context: Context, val onClick: (EventModel) -> Unit) : RecyclerView.Adapter<EventAdapter.EventViewHolder>() {

    private var events = emptyList<Event>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventViewHolder {
        return EventViewHolder(LayoutEventItemBinding.bind(LayoutInflater.from(context).inflate(
            R.layout.layout_event_item, parent, false)))
    }

    override fun onBindViewHolder(holder: EventViewHolder, position: Int) {
        holder.bind(events[position])
    }

    override fun getItemCount(): Int = events.size

    @SuppressLint("NotifyDataSetChanged")
    fun update(events: List<Event>) {
        this.events = events
        notifyDataSetChanged()
    }

    inner class EventViewHolder(val binding: LayoutEventItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(element: Event) {

            binding.txtDate.text = element.event_end_date
            binding.imgEvent.loadImage(element.event_link, placeholder = R.drawable.event_image_placeholder, radius = 10f)
            binding.eventAddress.text = element.address
            binding.txtEventName.text = element.event_name
            itemView.setOnClickListener {
                //onClick.invoke(element)
            }
        }
    }
}
