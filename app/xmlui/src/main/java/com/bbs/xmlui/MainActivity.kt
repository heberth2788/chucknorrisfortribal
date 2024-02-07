package com.bbs.xmlui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.bbs.triballivecoding.ui.TribalViewModel
import com.bbs.xmlui.databinding.TribalActivityBinding
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Creating ViewModel object
        val viewModel: TribalViewModel by viewModels()

        /*val textView = TextView(this)
        textView.text = "Hello XML Ui again !"
        setContentView(textView)*/

        //setContentView(R.layout.activity_main)

        //setContentView(R.layout.tribal_activity)

        val binding: TribalActivityBinding = DataBindingUtil.setContentView(this, R.layout.tribal_activity)
        binding.viewModel = viewModel

        /*lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
            }
        }*/
    }
}