package com.example.androidapps2.repo.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.androidapps2.core.utils.DateUtils
import com.example.androidapps2.databinding.ItemRepoBinding
import com.example.androidapps2.repo.model.RepoUiModel

class RepoAdapter(private val repoList: List<RepoUiModel>, private val onItemClickListener : OnItemClickListener) :
    RecyclerView.Adapter<RepoAdapter.BlogViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BlogViewHolder {
        val binding = ItemRepoBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return BlogViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BlogViewHolder, position: Int) {
        val repo = repoList[position]
        holder.bind(repo, position)
    }

    override fun getItemCount(): Int {
        return repoList.size;
    }

    inner class BlogViewHolder(private val itemRepoBinding: ItemRepoBinding) :
        RecyclerView.ViewHolder(itemRepoBinding.root){

        fun bind(repo: RepoUiModel, position: Int) {
            itemRepoBinding.name.text = repo.name
            itemRepoBinding.fullName.text = repo.fullName
            itemRepoBinding.date.text = DateUtils.getFormattedDate(repo.createdDate)

            itemRepoBinding.root.setOnClickListener {
                onItemClickListener.onItemClick(position, repo)
            }
        }
    }

    interface OnItemClickListener {
        fun onItemClick(position: Int, blogPost: RepoUiModel)
    }
}