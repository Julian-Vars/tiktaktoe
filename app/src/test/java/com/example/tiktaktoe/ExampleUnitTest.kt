package com.example.tiktaktoe

import org.junit.Assert.*
import org.junit.Test


/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun initGame3x3(){
        val game = Game(3)
        val expected = "---\n---\n---"
        assertEquals(expected, game.toString())
    }
    @Test
    fun initGame2x2(){
        val game = Game(2)
        val expected = "--\n--"
        assertEquals(expected, game.toString())
    }
    @Test
    fun placeOne3x3(){
        val game = Game(3)
        game.place(0)
        val expected = "X--\n---\n---"
        assertEquals(expected, game.toString())
    }
    @Test
    fun placeTwo3x3(){
        val game = Game(3)
        game.place(0)
        game.place(1)
        val expected = "XO-\n---\n---"
        assertEquals(expected, game.toString())
    }
    @Test
    fun placeOnBlank(){
        val game = Game(3)
        assertTrue(game.place(0))
    }
    @Test
    fun placeOnOccupied(){
        val game = Game(3)
        game.place(0)
        assertFalse(game.place(0))
    }
    @Test
    fun misplacedOne3x3(){
        val game = Game(3)
        game.place(0)
        game.place(0)
        game.place(1)
        val expected = "XO-\n---\n---"
        assertEquals(expected, game.toString())
    }
    @Test
    fun placeOutsideGrid(){
        assertThrows(IndexOutOfBoundsException::class.java){
            val game = Game(3)
            game.place(10)
        }

    }
    @Test
    fun checkWinnerEmptyGrid(){
        val game = Game(3)
        assertEquals(0, game.checkWinner())
    }
    @Test
    fun checkWinnerPlayer1Horizontal1(){
        val game = Game(3)
        game.place(0)
        game.place(3)
        game.place(1)
        game.place(4)
        game.place(2)

        assertEquals(1, game.checkWinner())
    }

    @Test
    fun checkWinnerPlayer1Horizontal2(){
        val game = Game(3)
        game.place(3)
        game.place(1)
        game.place(4)
        game.place(2)
        game.place(5)

        assertEquals(1, game.checkWinner())
    }
    @Test
    fun `check winner player 1 vertical`(){
        val game = Game(3)
        game.place(0)
        game.place(1)
        game.place(3)
        game.place(2)
        game.place(6)

        assertEquals(1, game.checkWinner())
    }
    @Test
    fun `winner player 1 diagonal descending`(){
        val game = Game(3)
        game.place(0)
        game.place(1)
        game.place(4)
        game.place(2)
        game.place(8)

        assertEquals(1, game.checkWinner())
    }
    @Test
    fun `winner player 1 diagonal ascending`(){
        val game = Game(3)
        game.place(2)
        game.place(1)
        game.place(4)
        game.place(2)
        game.place(6)

        assertEquals(1, game.checkWinner())
    }
    @Test
    fun `winner player 2 diagonal descending`(){
        val game = Game(3)
        game.place(2)
        game.place(0)
        game.place(3)
        game.place(4)
        game.place(6)
        game.place(8)

        assertEquals(2, game.checkWinner())
    }
}