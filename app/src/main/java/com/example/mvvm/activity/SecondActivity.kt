package com.example.mvvm.activity

import android.content.pm.ActivityInfo
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.mvvm.R
import com.example.mvvm.databinding.SecondActivityBinding
import com.example.mvvm.viewmodel.MyViewModel

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val titleName  = intent.getStringExtra("titleName")
        val last= intent.getStringExtra("lastname")

        val binding = DataBindingUtil.setContentView<SecondActivityBinding>(this, R.layout.second_activity)
        binding.fullscreen.setOnClickListener { setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE); }
        val viewModel = ViewModelProvider(this).get(MyViewModel ::class.java)

        println("titleName===="+titleName)
        println("OnCreate Method===="+titleName)
        println("bundle===="+last)
        binding.secondScreen.isVisible = viewModel.hide
        binding.textview.text = last +" "+titleName
        binding.secondScreen.setOnClickListener {
            binding.secondScreen.isVisible = false
            viewModel.hide = false
        }

        binding.fullscreenExit.setOnClickListener {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        }


    }
}