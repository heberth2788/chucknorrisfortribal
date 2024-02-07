package com.bbs.triballivecoding.ui

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bbs.triballivecoding.data.CategoryRepository
import com.bbs.triballivecoding.data.api.JokesData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TribalViewModel @Inject constructor(
    // Inject Repository
    private val repository: CategoryRepository,
) : ViewModel() {

    private val _tribalState = mutableStateOf(TribalState())
    val tribalState = _tribalState

    init {
        Log.d(TAG, "init")

    }

    fun onValueChangeTextField(newStr: String) {
        Log.d(TAG, "onValueChangeTextField")
        _tribalState.value = _tribalState.value.copy(
            textFieldStr = newStr
        )
    }

    fun onValueChangeTextFieldResult(newStr: String) {
        Log.d(TAG, "onValueChangeTextFieldResult")
        _tribalState.value = _tribalState.value.copy(
            textFieldResult = newStr,
        )
    }

    fun onClickRandom() {
        Log.d(TAG, "onClickRandom")
        viewModelScope.launch(Dispatchers.IO) {
            runCatching {
                val rd: JokesData = repository.getRandomData()
                _tribalState.value = _tribalState.value.copy(
                    textFieldResult = rd.toString(),
                )
            }.onFailure { exception ->
                _tribalState.value = _tribalState.value.copy(
                    textFieldResult = "Exception : ${ exception.message }",
                )
            }
        }
    }

    fun onClickQuery() {
        Log.d(TAG, "onClickQuery : ${ _tribalState.value.textFieldStr }")
        viewModelScope.launch(Dispatchers.IO) {
            runCatching {
                val cd: JokesData = repository.getCategoryData(_tribalState.value.textFieldStr)
                _tribalState.value = _tribalState.value.copy(
                    textFieldResult = cd.toString(),
                )
            }.onFailure { exception ->
                _tribalState.value = _tribalState.value.copy(
                    textFieldResult = "Unknown category : ${ _tribalState.value.textFieldStr } \n\n exception : ${ exception.message }",
                )
            }

        }
    }

    fun onClickAllCategories() {
        Log.d(TAG, "onClickAllCategories")
        viewModelScope.launch {
            runCatching {
                //val cat: CategoryList = repository.getCategories()
                val cat: Set<String> = repository.getCategories()
                _tribalState.value = _tribalState.value.copy(
                    textFieldResult = cat.toString()
                )
            }.onFailure { exception ->
                _tribalState.value = tribalState.value.copy(
                    textFieldResult = " Exception : ${ exception.message }"
                )
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        Log.d(TAG , "onCleared")
    }

    companion object {
        private val TAG = TribalViewModel::class.java.simpleName
    }
}