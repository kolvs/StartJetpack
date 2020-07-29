package com.assess15.jetpacks.room.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.assess15.jetpacks.R
import com.assess15.jetpacks.room.db.entity.StudentEntity

class StudentListAdapter internal constructor(
    context: Context
) : RecyclerView.Adapter<StudentListAdapter.WordViewHolder>() {

    private val inflater: LayoutInflater = LayoutInflater.from(context)
    private var words = emptyList<StudentEntity>() // Cached copy of words

    inner class WordViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val wordItemView: TextView = itemView.findViewById(R.id.textView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordViewHolder {
        val itemView = inflater.inflate(R.layout.jetpack_recyclerview_item, parent, false)
        return WordViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: WordViewHolder, position: Int) {
        val current = words[position]
        holder.wordItemView.text = current.name
    }

    internal fun setWords(words: List<StudentEntity>) {
        this.words = words
        notifyDataSetChanged()
    }

    override fun getItemCount() = words.size
}