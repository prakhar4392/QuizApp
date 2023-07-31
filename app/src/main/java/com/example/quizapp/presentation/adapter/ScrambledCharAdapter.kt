package com.example.quizapp.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.quizapp.databinding.ItemRowBinding

class ScrambledCharAdapter(val onClick:(String)->Unit): RecyclerView.Adapter<ScrambledCharAdapter.ScrambledCharViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ScrambledCharViewHolder =
        ScrambledCharViewHolder(ItemRowBinding.inflate(LayoutInflater.from(parent.context),
        parent,false))

    var listOfScrambledChars = arrayListOf<Char>()
    override fun onBindViewHolder(
        holder: ScrambledCharAdapter.ScrambledCharViewHolder,
        position: Int
    ) {
        holder.setUp(listOfScrambledChars[position])
    }

    override fun getItemCount(): Int {
        return listOfScrambledChars.size
    }

    inner class ScrambledCharViewHolder(private val binding: ItemRowBinding):RecyclerView.ViewHolder(binding.root){

        fun setUp(char:Char){
            binding.apply {
                btnChar.text = char.toString()
                btnChar.setOnClickListener {
                    onClick(btnChar.text as String)
                }
            }
        }

    }

    fun updateList(list:List<Char>){
        listOfScrambledChars.clear()
        listOfScrambledChars.addAll(list)
    }
}