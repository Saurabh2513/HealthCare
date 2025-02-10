package com.example.apifetchingbyjson.onboarding.ui.adapter;

import android.view.View;

import com.example.apifetchingbyjson.onboarding.ui.model.User;

import java.util.ArrayList;

class UsersAdapter(
        var users :ArrayList<User>
) : RecyclerView.Adapter<UsersAdapter.UserViewHolder>() {

class UserViewHolder(itemView :View) : RecyclerView.ViewHolder(itemView) {
        var binding = UserViewBinding.bind(itemView)
        }

        override fun getItemCount(): Int {
        return users.size
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        return UserViewHolder(
        LayoutInflater.from(parent.context)
        .inflate(R.layout.user_view, null)
        )
        }

        override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.binding.user = users[position]
        }
        }
