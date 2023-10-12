package com.example.androidapps2.repo.view

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androidapps2.databinding.ActivityRepoListBinding
import com.example.androidapps2.repo.model.RepoUiModel
import com.example.androidapps2.repo.viewmodel.RepoListViewModel
import com.example.androidapps2.repodetails.view.RepoDetailsActivity

class RepoListActivity : AppCompatActivity(), RepoAdapter.OnItemClickListener {

    private lateinit var binding: ActivityRepoListBinding
    private val viewModel: RepoListViewModel by viewModels { RepoListViewModel.factory }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRepoListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.getRepoList()

        viewModel.showLoaderLiveData.observe(this) {
            binding.progressBar.isVisible = it ?: false
        }

        viewModel.blogListUiModelLiveData.observe(this) {
            val layoutManager = LinearLayoutManager(this)
            binding.recyclerView.layoutManager = layoutManager

            val adapter = RepoAdapter(it, this)
            binding.recyclerView.adapter = adapter
        }

        viewModel.showErrorLiveData.observe(this) {
            Toast.makeText(this, it, Toast.LENGTH_LONG).show();
        }
    }

    override fun onItemClick(position: Int, blogPost: RepoUiModel) {
        val intent = Intent(binding.root.context, RepoDetailsActivity::class.java)
        intent.putExtra("repoItem", blogPost)
        binding.root.context.startActivity(intent)
    }
}