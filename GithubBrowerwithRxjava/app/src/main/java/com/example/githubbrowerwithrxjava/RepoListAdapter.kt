package com.example.githubbrowerwithrxjava


import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import android.view.LayoutInflater
import android.view.ViewGroup
import com.android.example.github.ui.common.DataBoundListAdapter
import com.example.githubbrowerwithrxjava.databinding.RecyclerviewRowBinding

/**
 * A RecyclerView adapter for [Repo] class.
 */

class RepoListAdapter(
    appExecutors: AppExecutors,
    private val repoClickCallback: ((GithubRepo) -> Unit)?
) : DataBoundListAdapter<GithubRepo, RecyclerviewRowBinding>(
    appExecutors = appExecutors,
    diffCallback = object : DiffUtil.ItemCallback<GithubRepo>() {
        override fun areItemsTheSame(oldItem: GithubRepo, newItem: GithubRepo): Boolean {
            return oldItem.id == newItem.id
                    && oldItem.name == newItem.name
        }

        override fun areContentsTheSame(oldItem: GithubRepo, newItem: GithubRepo): Boolean {
            return oldItem.name == newItem.name
                    && oldItem.date == newItem.date
        }
    }
) {

    override fun createBinding(parent: ViewGroup): RecyclerviewRowBinding {
        val binding = DataBindingUtil.inflate<RecyclerviewRowBinding>(
            LayoutInflater.from(parent.context),
            R.layout.recyclerview_row,
            parent,
            false
        )
       // binding.showFullName = showFullName
        binding.root.setOnClickListener {
            binding.repo?.let {
                repoClickCallback?.invoke(it)
            }
        }
        return binding
    }

    override fun bind(binding: RecyclerviewRowBinding, item: GithubRepo) {
        binding.repo = item
    }
}
