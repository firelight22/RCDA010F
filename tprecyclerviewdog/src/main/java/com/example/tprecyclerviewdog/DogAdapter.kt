package com.example.tprecyclerviewdog

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tprecyclerviewdog.databinding.RowLayoutDogBinding
import com.squareup.picasso.Picasso

class DogAdapter(val ald : ArrayList<Dog>, val listenerClickDog : (dog:Dog) -> Unit)
    : RecyclerView.Adapter<DogAdapter.DogViewHolder>() {

    class DogViewHolder(val db : RowLayoutDogBinding)
        : RecyclerView.ViewHolder(db.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DogViewHolder {
        val binding = RowLayoutDogBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return DogViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DogViewHolder, position: Int) {
        val dogDispl = ald[position]
        holder.db.dog = dogDispl
        Picasso.get().load(dogDispl.imageUrl).into(holder.db.imageView)
        holder.itemView.setOnClickListener { listenerClickDog(dogDispl) }
    }

    override fun getItemCount(): Int = ald.size


}