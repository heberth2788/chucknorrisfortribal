package com.bbs.triballivecoding.uixml

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.bbs.triballivecoding.R
import com.bbs.triballivecoding.databinding.TribalActivityBinding
import com.bbs.triballivecoding.ui.TribalViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainXmlActivity : AppCompatActivity() {

    // Creating ViewModel object
    private val viewModel: TribalXmlViewModel by viewModels()

    private lateinit var binding: TribalActivityBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //setContentView(R.layout.activity_main)

        binding = DataBindingUtil.setContentView(this, R.layout.tribal_activity)
        binding.viewModel = viewModel

        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.tribalState.collect { state ->
                    binding.textViewResult.text = state.textFieldResult
                }
            }
        }
    }
}