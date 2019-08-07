/*
 * Copyright (C) 2017 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.kakaotest.ui.search

import androidx.databinding.DataBindingComponent
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import android.view.LayoutInflater
import android.view.ViewGroup

import com.android.example.github.ui.common.DataBoundListAdapter

import com.example.kakaotest.AppExecutors
import com.example.kakaotest.R
import com.example.kakaotest.data.search.SearchImage
import com.example.kakaotest.databinding.SearchItemBinding


class SearchListAdapter(
    private val dataBindingComponent: DataBindingComponent,
    appExecutors: AppExecutors,
    private val repoClickCallback: ((SearchImage.Document) -> Unit)?
) : DataBoundListAdapter<SearchImage.Document, SearchItemBinding>(
    appExecutors = appExecutors,
    diffCallback = object : DiffUtil.ItemCallback<SearchImage.Document>() {
        override fun areItemsTheSame(oldItem: SearchImage.Document, newItem: SearchImage.Document): Boolean {
            return oldItem.thumbnail_url == newItem.thumbnail_url
                    && oldItem.thumbnail_url == newItem.thumbnail_url
        }

        override fun areContentsTheSame(oldItem: SearchImage.Document, newItem: SearchImage.Document): Boolean {
            return oldItem.display_sitename == newItem.display_sitename
                    && oldItem.image_url == newItem.image_url
        }

    }) {
    override fun createBinding(parent: ViewGroup): SearchItemBinding {
        val binding = DataBindingUtil.inflate<SearchItemBinding>(
            LayoutInflater.from(parent.context),
            R.layout.search_item,
            parent,
            false,
            dataBindingComponent
        )
        binding.root.setOnClickListener {
            binding.searchitem?.let {
                repoClickCallback?.invoke(it)
            }
        }
        return binding
    }

    override fun bind(binding: SearchItemBinding, item: SearchImage.Document) {
        binding.searchitem = item
    }
}
