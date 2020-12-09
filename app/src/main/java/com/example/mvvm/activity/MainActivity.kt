package com.example.mvvm.activity

import android.content.Intent
import android.content.pm.ActivityInfo
import android.os.Bundle
import android.provider.Settings
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.mvvm.R
import com.example.mvvm.baseClass.BaseActivity
import com.example.mvvm.databinding.ActivityMainBinding
import com.example.mvvm.retrofit.Repository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : BaseActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

      //  val viewModel = ViewModelProvider(this).get(MyViewModel::class.java)
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this,
            R.layout.activity_main
        )
        Settings.System.USER_ROTATION
        val config = resources.configuration
        onConfigurationChanged(config)

        binding.fullscreen.setOnClickListener {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        }

        binding.fullscreenExit.setOnClickListener {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        }

        binding.nextscreen.setOnClickListener {
            val intent : Intent = Intent(this, SecondActivity :: class.java)
            val bundel = Bundle()
            bundel.putString("lastname","Kolli")

            intent.putExtra("titleName","Ravichand")
            intent.putExtras(bundel)
            startActivity(intent)
        }

        println("****** onCreate Methode ********")
        CoroutineScope(Dispatchers.Main).launch {
            System.out.println("====== SafeApiRequest =====")
            val response   = Repository().resp()
            binding.textview.text = response.get(2).title
            //restext.set(response.toString())
        } //End of CoroutineScope

    }  //End of OnCreate Method

}