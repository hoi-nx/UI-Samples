package com.iiinaiii.uisamples.extendedfab

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.api.load
import coil.transform.CircleCropTransformation
import com.iiinaiii.uisamples.R

data class ExtendedFabData(val avatarUrl: String, val name: String)

class ExtendedFabListAdapter(private val dataList: List<ExtendedFabData>) :
    RecyclerView.Adapter<ExtendedFabListAdapter.ExtendedFabViewHolder>() {
    class ExtendedFabViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name: TextView = itemView.findViewById(R.id.name_text)
        val avatar: ImageView = itemView.findViewById(R.id.avatar_image)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExtendedFabViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ExtendedFabViewHolder(
            inflater.inflate(R.layout.item_extended_fab, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ExtendedFabViewHolder, position: Int) {
        val data = dataList[position]
        holder.name.text = data.name
        holder.avatar.load(data.avatarUrl) {
            transformations(CircleCropTransformation())
        }
    }

    override fun getItemCount() = dataList.size
}