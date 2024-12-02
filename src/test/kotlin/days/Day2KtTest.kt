package days

import kotlin.test.Test

class Day2KtTest {
    val testInput = """
            7 6 4 2 1
            1 2 7 8 9
            9 7 6 2 1
            1 3 2 4 5
            8 6 4 4 1
            1 3 6 7 9
        """.trimIndent()

    @Test
    fun testDay2Part1() {
        val day2 = Day2(testInput)
        day2.execute(1)
    }

    @Test
    fun testDay2Part2() {
        val day2 = Day2(testInput)
        day2.execute(2)
    }
}