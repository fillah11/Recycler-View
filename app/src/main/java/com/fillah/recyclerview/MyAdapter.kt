package com.fillah.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView

class MyAdapter (private val placeList: ArrayList<Place>) :
    RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return MyViewHolder(itemView)

    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val currentItem = placeList[position]
        holder.titleImage.setImageResource(currentItem.titleImage)
        holder.tvHeading.text = currentItem.name
        holder.placeDesc.text = currentItem.placeDesc

        val isVisible : Boolean = currentItem.visibility
        holder.constaintLayout.visibility = if (isVisible) View.VISIBLE else View.GONE

        holder.tvHeading.setOnClickListener {

            currentItem.visibility = !currentItem.visibility
            notifyItemChanged(position)
        }

    }

    override fun getItemCount(): Int {
        return placeList.size
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val titleImage : ShapeableImageView = itemView.findViewById(R.id.imagetitle)
        val tvHeading : TextView = itemView.findViewById(R.id.tvHeading)
        val placeDesc : TextView = itemView.findViewById(R.id.placeDesc)
        val constaintLayout : ConstraintLayout = itemView.findViewById(R.id.expandedLayout)

    }

}