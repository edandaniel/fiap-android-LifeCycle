package com.edandaniel.lifecycle.viewmodelcomlivedata

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.edandaniel.lifecycle.R
import kotlinx.android.synthetic.main.activity_score.*

class ScoreActivity : AppCompatActivity() {

    var scoreViewModel:ScoreViewModel? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_score)

        scoreViewModel = ViewModelProviders.of(this).get(ScoreViewModel::class.java)

        scoreViewModel?.scoreHome?.observe(this,Observer{
            tvHome.setText(it?.toString())
        })

        scoreViewModel?.scoreGuest?.observe(this,Observer{
            tvGuest.setText(it?.toString())
        })

        bt1Home.setOnClickListener{ scoreViewModel?.pointHome(1)}
        bt2Home.setOnClickListener{ scoreViewModel?.pointHome(2)}
        bt3Home.setOnClickListener{ scoreViewModel?.pointHome(3)}

        bt1Guest.setOnClickListener{ scoreViewModel?.pointGuest(1)}
        bt2Guest.setOnClickListener{ scoreViewModel?.pointGuest(2)}
        bt3Guest.setOnClickListener{ scoreViewModel?.pointGuest(3)}

        btReset.setOnClickListener{
            scoreViewModel?.reset()
        }
    }
}
