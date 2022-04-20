package com.example.tiktaktoe


class Game(val gridSize: Int, private val playerCount:Int = 2) {
    val grid: ArrayList<Int> = ArrayList()
    var currentPlayer = 1
    init {
        while(grid.size != gridSize*gridSize){
            grid.add(0)
        }
    }

    fun place(index:Int):Boolean {
            if(grid[index] == 0){
                grid[index] = currentPlayer
                updatePlayer()
                return true
            }
            return false
    }

    fun checkWinner():Int{
        //Horizontal
        var check = 0
        for(index in 0 until grid.size){
            if(index == 0 || index%gridSize == 0){
                if(check != 0){
                    return check
                }
                check = grid[index]
            }
            if(grid[index] != check) check = 0
        }
        // Vertical
        for(column in 0 until gridSize){
            check = 0
            for(row in 0 until gridSize){
                if(row == 0)check = grid[row*gridSize + column]
                if(grid[row*gridSize + column] != check) check = 0
            }
            if(check != 0){
                return check
            }
        }
        //Diagonal \
        check = grid[0]
        for(diagonal in 0 until gridSize){
            if(check != grid[diagonal*gridSize + diagonal]) check = 0
        }
        if(check != 0) return check
        //Diagonal /
        check = grid[gridSize-1]
        for(diagonal in 1 until gridSize){
            if(check != grid[gridSize*diagonal-diagonal])check = 0
        }
        if(check != 0) return check

        return 0
    }

    private fun updatePlayer() {
        if(currentPlayer == playerCount){
            currentPlayer = 1
        }else{
            currentPlayer++
        }
    }

    override fun toString():String{
        var returnVal = ""
        for(index in 0 until grid.size){
            if(index != 0 && index%gridSize == 0){
                returnVal +="\n"
            }
            when {
                grid[index] == 0 -> {
                    returnVal +="-"
                }
                grid[index] == 1 -> {
                    returnVal += "X"
                }
                grid[index] == 2 -> {
                    returnVal += "O"
                }
                grid[index] > 2 -> {
                    returnVal += index
                }
            }
        }
        return returnVal
    }

}
