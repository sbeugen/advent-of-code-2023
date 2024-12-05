package days

import kotlin.test.Test

class Day4KtTest {
    val testInput = """
        MMMSXXMASM
        MSAMXMSMSA
        AMXSXMAAMM
        MSAMASMSMX
        XMASAMXAMM
        XXAMMXXAMA
        SMSMSASXSS
        SAXAMASAAA
        MAMMMXMMMM
        MXMXAXMASX
    """.trimIndent()

    @Test
    fun testDay4Part1() {
        val day4 = Day4(testInput)
        day4.execute(1)
    }

    @Test
    fun testDay4Part2() {
        val day4 = Day4(testInput)
        day4.execute(2)
    }
}