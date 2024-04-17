package com.example.iplscoreapi.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.iplscoreapi.R
import com.example.iplscoreapi.databinding.ItemLayoutBinding
import com.example.iplscoreapi.model.Match
import com.example.iplscoreapi.model.TeamInfo

class MatchAdapter(val context: Context, val list: List<Match> ) :
    RecyclerView.Adapter<MatchAdapter.MatchViewHolder>() {

    class MatchViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding = ItemLayoutBinding.bind(view)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MatchViewHolder {
        return MatchViewHolder(
            LayoutInflater.from(context).inflate(R.layout.item_layout, parent, false)
        )
    }

    override fun onBindViewHolder(holder: MatchViewHolder, position: Int) {
        val item = list[position]
        holder.binding.matchTitle.text = item.name
        holder.binding.matchStatus.text = item.status
        holder.binding.matchType.text = item.matchType
        holder.binding.date.text = item.date
        holder.binding.venue.text = item.venue
        holder.binding.teams.text = item.teams.toString()
//        var teamName = ""
//        for (team in item.teams) {
//            teamName += team + "  "
//        }
//        holder.binding.teams.text = teamName

    }

    override fun getItemCount(): Int {
        return list.size
    }
}