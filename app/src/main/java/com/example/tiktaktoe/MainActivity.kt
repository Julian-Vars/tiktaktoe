package com.example.tiktaktoe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TableLayout
import android.widget.TableRow
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    val game = Game(3)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val header:TextView = findViewById(R.id.Header)
        val table:TableLayout = findViewById(R.id.gameTable)

        header.text = "Current Player : ${game.currentPlayer}"

        for(row in 0 until game.gridSize){
            val tableRow = TableRow(table.context)
            for(cell in 0 until game.gridSize){
                val tv = TextView(tableRow.context)
                tv.text = game.grid[row*game.gridSize + cell].toString()
                tv.textSize = 80f
                tv.setOnClickListener{
                    if(game.checkWinner() == 0){
                        game.place(row*game.gridSize + cell)
                        tv.text = game.grid[row*game.gridSize + cell].toString()
                        header.text = "Current Player : ${game.currentPlayer}"
                        if(game.checkWinner() != 0){
                            header.text = "The winner is : ${game.checkWinner()}"
                        }
                    }

                }
                tableRow.addView(tv)
            }
            table.addView(tableRow)
        }


    }

}