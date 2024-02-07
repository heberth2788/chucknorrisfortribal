package com.bbs.triballivecoding.data

import android.util.Log
import com.bbs.triballivecoding.data.api.JokesData
import javax.inject.Inject

class CategoryRepository @Inject constructor(
    // Inject Data Source
    private val dataSource: CategoryDataSource,
) {
    suspend fun getRandomData() : JokesData {
        Log.d(TAG, "getRandomData")
        return dataSource.getRandomData()
    }

    suspend fun getCategoryData(category: String) : JokesData {
        Log.d(TAG, "getCategoryData : $category")
        return dataSource.getDataByCategory(category)
    }

    suspend fun getCategories() : Set<String> { // CategoryList {
        Log.d(TAG, "getCategories")
        return dataSource.getCategories()
    }

    companion object {
        private val TAG = CategoryRepository::class.java.simpleName
    }
}