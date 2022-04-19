package com.example.tiktaktoe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    val grid: ArrayList<ImageView> = ArrayList()
    var player: Int = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        grid.add(findViewById(R.id.LeftCircle))
        grid.add(findViewById(R.id.MiddleCircle))
        grid.add(findViewById(R.id.RightCircle))

        for(circle in grid){
            circle.setOnClickListener{
                player = assignSymbol(circle, player)

            }
        }

    }

    private fun assignSymbol(circle:ImageView, p:Int):Int {
        return if(p == 0){
            circle.setColorFilter(R.color.purple_200)
            1
        }else{
            circle.setColorFilter(R.color.teal_200)
            0
        }
    }
}