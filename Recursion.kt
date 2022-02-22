package recur

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

interface Recur {
    fun childAdd(desired: Int, current: Int = 1): Int {
        return if (desired == current) current else childAdd(desired, current+1)
    }
    
    fun childMult(num: Int, times: Int, result: Int = 0): Int {
        return if (num * times == result) result else childMult(num, times, result+times)
    }
    
    fun multPow(num: Int, pow: Int): Int {
        return if (pow == 0) num else multPow(num*pow, pow-1)
    }
    
    fun sumPartsOf(num: String, result: Int = 0): Int {
        return if(num.isEmpty()) result else sumPartsOf(num.drop(1), result+(num[0].digitToInt()))
    }
    
    fun palindrome(str: String, result: Boolean = true): Boolean {
        return if(str.isEmpty() || !result) result else palindrome(str.drop(1).dropLast(1), str[0] == str[str.length - 1])  
    }
}

class TestRecur : Recur {
    @test
    fun add() {
        assertEquals(69, childAdd(69))
    }

    @test
    fun mult() {
        assertEquals(25, childMult(5, 5))
    }

    @test
    fun pow() {
        assertEquals(10, multPow(5, 2))
    }

    @test
    fun sum() {
        assertEquals(18, sumPartsOf("666"))
    }

    @test
    fun palindromeTest() {
        assertEquals(true, palindrome("racecar"))
    }
}