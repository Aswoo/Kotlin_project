package com.example.githubbrowerwithrxjava

import android.os.Bundle

import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.githubbrowerwithrxjava.databinding.RecyclerviewRowBinding
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private var appExecutors : AppExecutors = AppExecutors()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapter = RepoListAdapter(appExecutors) {

        }

        mRecyclerView.layoutManager = LinearLayoutManager(this) as RecyclerView.LayoutManager?
        mRecyclerView.adapter = adapter

        val disposable = GithubClient().getApi().getRepos(intent.extras?.get("owner").toString())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe { items -> adapter.submitList(items)

                }

    }
}
