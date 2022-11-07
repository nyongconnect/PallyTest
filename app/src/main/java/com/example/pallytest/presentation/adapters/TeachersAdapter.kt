package com.example.pallytest.presentation.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pallytest.R
import com.example.pallytest.databinding.LayoutTeacherItemBinding
import com.example.pallytest.model.MilongasModel
import com.example.pallytest.model.TeachersModel
import com.example.pallytest.presentation.utils.setTextDiff

class TeachersAdapter (private val context: Context, val onClick: (MilongasModel) -> Unit) : RecyclerView.Adapter<TeachersAdapter.TeachersViewHolder>() {

    private var teachers = emptyList<TeachersModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeachersViewHolder {
        return TeachersViewHolder(LayoutTeacherItemBinding.bind(LayoutInflater.from(context).inflate(
            R.layout.layout_teacher_item, parent, false)))
    }

    override fun onBindViewHolder(holder: TeachersViewHolder, position: Int) {
        holder.bind(teachers[position])
    }

    override fun getItemCount(): Int = teachers.size

    @SuppressLint("NotifyDataSetChanged")
    fun update(teachers: List<TeachersModel>) {
        this.teachers = teachers
        notifyDataSetChanged()
    }

    inner class TeachersViewHolder(val binding: LayoutTeacherItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(element: TeachersModel) {
           binding.txtExperience.setTextDiff("20 years of experience", 9)
            itemView.setOnClickListener {
                //onClick.invoke(element)
            }
        }
    }
}
