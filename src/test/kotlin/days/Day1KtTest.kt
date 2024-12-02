package days

import org.junit.jupiter.api.Assertions.*
import kotlin.test.Test

class Day1KtTest {
    @Test
    fun testDay1Part1() {
        val testInput = """
            3   4
            4   3
            2   5
            1   3
            3   9
            3   3
        """.trimIndent()

        val day1 = Day1(testInput)
        day1.execute(1)
    }

    @Test
    fun testDay1Part2() {
        val testInput = """
            3   4
            4   3
            2   5
            1   3
            3   9
            3   3
        """.trimIndent()

        val day1 = Day1(testInput)
        day1.execute(2)
    }
}