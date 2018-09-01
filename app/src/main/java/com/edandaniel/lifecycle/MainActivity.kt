package com.edandaniel.lifecycle

import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainViewModel = ViewModelProviders
                .of(this).get(MainViewModel::class.java)

        updateHome()
        updateGuest()

        btHome.setOnClickListener {
            mainViewModel.scoreHome++
            updateHome()
        }
        btGuest.setOnClickListener {
            mainViewModel.scoreGuest++
            updateGuest()
        }
    }

    private fun updateHome(){
        tvHome.setText(mainViewModel.scoreHome.toString())
    }
    private fun updateGuest(){
        tvGuest.setText(mainViewModel.scoreGuest.toString())
    }
}
