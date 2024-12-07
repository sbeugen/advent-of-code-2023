package days

import kotlin.test.Test

class Day7KtTest {
    private val testInput = """
        190: 10 19
        3267: 81 40 27
        83: 17 5
        156: 15 6
        7290: 6 8 6 15
        161011: 16 10 13
        192: 17 8 14
        21037: 9 7 18 13
        292: 11 6 16 20
    """.trimIndent()

    @Test
    fun testDay7Part1() {
        val day7 = Day7(testInput)
        day7.execute(1)
    }

    @Test
    fun testDay6Part2() {
        val day7 = Day7(testInput)
        day7.execute(2)
    }
}