package com.bbs.triballivecoding.data.api

import retrofit2.http.GET
import retrofit2.http.Query

interface CategoryService {

    // https://api.chucknorris.io/jokes/random
    @GET("random")
    suspend fun getRandom(): JokesData

    // https://api.chucknorris.io/jokes/random?category={category}
    // category: "animal","career","celebrity","dev","explicit","fashion","food","history","money","movie","music","political","religion","science","sport","travel"
    @GET("random?")
    suspend fun getCategory(
        //@Path("category")
        @Query(value = "category")
        category: String,
    ) : JokesData

    //https://api.chucknorris.io/jokes/categories
    @GET("categories")
    suspend fun getCategories(): Set<String>
}