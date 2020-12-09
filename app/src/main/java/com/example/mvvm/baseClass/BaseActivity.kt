package com.example.mvvm.baseClass

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.mvvm.R
import com.example.mvvm.databinding.SecondActivityBinding
import kotlinx.android.synthetic.main.second_activity.view.*

abstract class BaseActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<SecondActivityBinding>(this, R.layout.second_activity)

    }

}