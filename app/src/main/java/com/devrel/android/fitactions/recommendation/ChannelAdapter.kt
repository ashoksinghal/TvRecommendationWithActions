package com.devrel.android.fitactions.recommendation

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.devrel.android.fitactions.R
import com.example.myapplication.Channel
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.topup.view.*

class ChannelAdapter(private val list: List<Channel>) :
    RecyclerView.Adapter<ChannelAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), LayoutContainer {
        override val containerView: View?
            get() = itemView
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.topup, parent, false)
        val viewHolder = ViewHolder(view)
        val context = viewHolder.itemView.context
        viewHolder.itemView.setOnClickListener {
            context.startActivity(Intent(context, ChannelAddedActivity::class.java))
        }
        return viewHolder
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
        Glide.with(holder.itemView.context).load(item.channel_logo).into(holder.itemView.logo)
    }
}
