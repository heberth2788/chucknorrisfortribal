package com.bbs.triballivecoding.data.api

// POJO class for Retrofit API
data class JokesData(
    val categories: List<String> = emptyList(),
    val created_at: String = "",
    val icon_url: String = "",
    val id: String = "",
    val updated_at: String = "",
    val url: String = "",
    val value: String = "",
)