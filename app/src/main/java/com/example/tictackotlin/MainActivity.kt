package com.example.tictackotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //animation
        image.translationY= -2000f
        textView.translationY= 2000f
        image.animate().translationY(0f).duration= 1800  //1500 = 1.5 second
        textView.animate().translationY(0f).duration= 1500
        // Splash Screen
        Handler(Looper.getMainLooper()).postDelayed({
                                                    val intent= Intent(this, StartActivity::class.java)
            //startActivity() is function.. not the name of our activity
             startActivity(intent)
        }, 2500)


    }
}