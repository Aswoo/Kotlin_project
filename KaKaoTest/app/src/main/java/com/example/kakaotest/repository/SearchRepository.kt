package com.example.kakaotest.repository

import com.example.kakaotest.AppExecutors
import com.example.kakaotest.api.SearchImageService
import com.example.kakaotest.data.search.SearchImage
import com.example.kakaotest.api.NetworkCall

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SearchRepository @Inject constructor(private val searchImageService: SearchImageService,
                                           private val appExecutors: AppExecutors) {

    private val KAKAO_APP_KEY: String = "8e72e426a16bc09362b1d4eb46f1ec11"

    fun search(query: String) = NetworkCall<SearchImage>().makeCall( searchImageService
        .searchImage("KakaoAK $KAKAO_APP_KEY", query, "accuracy", 1, 10))

    /*
    fun searchNextPage(query: String,page : Int,orderData : ): MutableLiveData<Resource<SearchImage>> {

        val search = NetworkCall<SearchImage>().makeCall( searchImageService
            .searchImage("KakaoAK $KAKAO_APP_KEY", query, "accuracy", page, 10))
        when(search.value?.status){
            Resource.Status.SUCCESS -> {
                var documents = search.value!!.data?.documents
            }
        }
        return search
    }
    */

}
