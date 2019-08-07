package com.example.kakaotest.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.example.kakaotest.data.search.SearchImage

import javax.inject.Inject


class DetailViewModel @Inject constructor() : ViewModel() {

    val document = SearchImage.Document();

    fun setId(imageUrl: String, siteName: String) {

        document?.image_url = imageUrl
        document?.display_sitename = siteName
    }

}