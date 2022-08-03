package com.example.recylerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recylerview.databinding.RowLayoutVeloBinding
import com.squareup.picasso.Picasso

class VeloAdapter(val arrayListVelo:ArrayList<Velo>, val ovcl : OnVeloClickListener)
    : RecyclerView.Adapter<VeloAdapter.VeloViewHolder>() {

    class VeloViewHolder(val binding : RowLayoutVeloBinding)
        : RecyclerView.ViewHolder(binding.root)
    //A la création du ViewHolder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VeloViewHolder {
        val binding = RowLayoutVeloBinding.inflate(
            LayoutInflater.from(parent.context),parent,false
        )
        return VeloViewHolder(binding)
    }

    override fun onBindViewHolder(holder: VeloViewHolder, position: Int) {
        val veloDisplay = arrayListVelo[position]
        holder.binding.velo = veloDisplay
        Picasso.get().load(veloDisplay.imageUrl).into(holder.binding.imageView)
        holder.binding.imageViewVae.visibility =
            if(veloDisplay.vae) View.VISIBLE else View.GONE
        holder.itemView.setOnClickListener { ovcl.onVeloClick(veloDisplay) }
    }

    override fun getItemCount(): Int = arrayListVelo.size

    class OnVeloClickListener(val listener : (velo:Velo) -> Unit){
        fun onVeloClick(velo: Velo) = listener(velo)
    }

}