package com.example.tiktaktoe

import android.widget.ImageView
import org.junit.Test

import org.junit.Assert.*
import java.lang.Exception
import java.lang.IllegalArgumentException
import java.security.InvalidParameterException

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    class Circle{
        var color = 0
    }
    private fun assignSymbol(circle:Circle, p:Int):Int {
        return when(p){
            0 ->{
                circle.color = 1
                2
            }
            1 ->{
                circle.color = 2
                0
            }
            else ->{
                throw IllegalArgumentException()
            }
        }
    }
    @Test
    fun assignCircleWorksForPlayerOne(){
        val circle1 = Circle()
        var player = 0
        assignSymbol(circle1, player)

        assertEquals(1, circle1.color)
    }
    @Test
    fun assignCircleWorksForPlayerTwo(){
        val circle1 = Circle()
        var player = 1
        assignSymbol(circle1, player)

        assertEquals(circle1.color, 2)
    }
    @Test
    fun assignCircleChangesPlayerOne(){
        val circle1 = Circle()
        var player = 0
        player = assignSymbol(circle1, player)

        assertEquals(player, 1)
    }
    @Test
    fun assignCircleChangesPlayerTwo(){
        val circle1 = Circle()
        var player = 1
        player = assignSymbol(circle1, player)
        assertEquals(player, 0)
    }
}