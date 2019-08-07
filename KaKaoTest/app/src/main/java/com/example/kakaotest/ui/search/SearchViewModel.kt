package com.example.kakaotest.ui.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.example.kakaotest.data.search.SearchImage

import com.example.kakaotest.repository.SearchRepository
import com.example.kakaotest.util.Resource
import java.util.*
import javax.inject.Inject

class SearchViewModel @Inject constructor(repository: SearchRepository) : ViewModel() {

    private val _query = MutableLiveData<String>()

    val results: LiveData<Resource<SearchImage>> = Transformations
        .switchMap(_query) { search ->
            repository.search(search)
        }

    val source: LiveData<SearchImage> = Transformations.map(results,
        { it -> it.data })

    val query: LiveData<String> = _query

    fun setQuery(originalInput: String) {
        val input = originalInput.toLowerCase(Locale.getDefault()).trim()
        if (input == _query.value) {
            return
        }
        _query.value = input
    }

}

