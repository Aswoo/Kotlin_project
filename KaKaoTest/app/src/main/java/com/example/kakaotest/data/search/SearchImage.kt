package com.example.kakaotest.data.search

data class SearchImage(
    val meta: Meta,
    val documents: List<Document>
) {
    data class Meta(
        val total_count: Int,
        val pageable_count: Int,
        val is_end: Boolean
    )

    data class Document(
        var collection: String = "",
        var thumbnail_url: String = "",
        var image_url: String = "",
        var width: Int = 0,
        var height: Int = 0,
        var display_sitename: String = "",
        var doc_url: String = "",
        var datetime: String = ""
    )

}