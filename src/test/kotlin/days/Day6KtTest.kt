package days

import kotlin.test.Test

class Day6KtTest {
    private val testInput = """
        ....#.....
        .........#
        ..........
        ..#.......
        .......#..
        ..........
        .#..^.....
        ........#.
        #.........
        ......#...
    """.trimIndent()

    @Test
    fun testDay6Part1() {
        val day6 = Day6(testInput)
        day6.execute(1)
    }

    @Test
    fun testDay6Part2() {
        val day6 = Day6(testInput)
        day6.execute(2)
    }
}