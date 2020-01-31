package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.devrel.android.fitactions.R
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.topup.view.*

class ChannelAdapter(private val list: List<Channel>) : RecyclerView.Adapter<ChannelAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), LayoutContainer {
        override val containerView: View?
            get() = itemView
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.topup, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return if (list.size > 5) {
            5
        } else {
            list.size
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list[position]
        holder.itemView.channel_name.text = item.title
        holder.itemView.genre.text = item.genres__name
    }
}
