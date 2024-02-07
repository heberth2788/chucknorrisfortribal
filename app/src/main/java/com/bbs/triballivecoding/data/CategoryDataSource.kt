package com.bbs.triballivecoding.data

import android.util.Log
import com.bbs.triballivecoding.data.api.CategoryService
import com.bbs.triballivecoding.data.api.JokesData
import retrofit2.Retrofit
import javax.inject.Inject

class CategoryDataSource @Inject constructor(
    // Inject retrofit
    private val retrofit: Retrofit
){
    suspend fun getRandomData() : JokesData {
        Log.d(TAG, "getRandomData")
        val apiService = retrofit.create(CategoryService::class.java)
        return apiService.getRandom()
    }

    //Categories: "animal","career","celebrity","dev","explicit","fashion","food","history","money","movie","music","political","religion","science","sport","travel"
    suspend fun getDataByCategory(category: String) : JokesData {
        Log.d(TAG, "getDataByCategory : $category")
        val apiService = retrofit.create(CategoryService::class.java)
        return apiService.getCategory(category)
    }

    suspend fun getCategories() : Set<String> { //CategoryList {
        Log.d(TAG, "getCategories")
        val apiService = retrofit.create(CategoryService::class.java)
        return apiService.getCategories()
    }

    companion object {
        private val TAG = CategoryDataSource::class.java.simpleName
    }
}