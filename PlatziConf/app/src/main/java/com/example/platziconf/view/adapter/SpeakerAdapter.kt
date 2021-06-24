package com.example.platziconf.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.platziconf.R
import com.example.platziconf.model.Speaker
import com.example.platziconf.view.ui.fragments.Speakers.SpeakersFragment
import kotlin.collections.ArrayList

class SpeakerAdapter(val speakerListener: SpeakersFragment) : RecyclerView.Adapter<SpeakerAdapter.ViewHolder>() {

    private var listSpeakers = ArrayList<Speaker>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_speaker, parent, false))

    override fun getItemCount() = listSpeakers.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val speaker = listSpeakers[position] as Speaker

        holder.tvItemSpeakerName.text = speaker.name
        holder.tvItemSpeakerWork.text = speaker.workplace

        Glide.with(holder.itemView.context)
                .load(speaker.image)
                .apply(RequestOptions.circleCropTransform())
                .into(holder.ivItemSpeakerImage)

        holder.itemView.setOnClickListener {
            speakerListener.onSpeakerClicked(speaker, position)
        }

    }

    fun updateData(data: List<Speaker>) {
        listSpeakers.clear()
        listSpeakers.addAll(data)
        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val tvItemSpeakerName = itemView.findViewById<TextView>(R.id.tvItemSpeakerName)
        val tvItemSpeakerWork = itemView.findViewById<TextView>(R.id.tvItemSpeakerWork)
        val ivItemSpeakerImage = itemView.findViewById<ImageView>(R.id.ivItemSpeakerImage)
    }
}