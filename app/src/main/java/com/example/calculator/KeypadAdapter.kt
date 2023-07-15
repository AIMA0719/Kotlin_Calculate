package com.example.calculator

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView

class KeypadAdapter : RecyclerView.Adapter<KeypadAdapter.KeypadViewHolder>() {

    private var number: List<String> = emptyList()
    var itemClickListener: ((String) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KeypadViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.keypad_item, parent, false)
        return KeypadViewHolder(view)
    }

    override fun onBindViewHolder(holder: KeypadViewHolder, position: Int) {
        val key = number[position]
        holder.bind(key)

    }

    override fun getItemCount(): Int {
        return number.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setNumbers(number: List<String>){
        this.number = number
        notifyDataSetChanged()
    }

    fun setOnItemClickListener(listener: ((String) -> Unit)?) {
        this.itemClickListener = listener
    }

    inner class KeypadViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val btnKey: Button = itemView.findViewById(R.id.btnKey)

        init {
            btnKey.setOnClickListener {
                val key = number[adapterPosition]
                itemClickListener?.invoke(key)
            }
        }

        fun bind(key: String) {
            btnKey.text = key
        }
    }

}