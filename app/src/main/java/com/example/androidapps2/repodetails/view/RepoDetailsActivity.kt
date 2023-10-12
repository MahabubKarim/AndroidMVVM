package com.example.androidapps2.repodetails.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.androidapps2.core.utils.DateUtils
import com.example.androidapps2.databinding.ActivityRepoDetailsBinding
import com.example.androidapps2.repo.model.RepoUiModel

class RepoDetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRepoDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRepoDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val repoModel = intent.getSerializableExtra("repoItem") as RepoUiModel

        binding.name.text = repoModel.name
        binding.fullName.text = repoModel.fullName
        binding.date.text = DateUtils.getFormattedDate(repoModel.createdDate)
        binding.description.text = repoModel.description
    }
}