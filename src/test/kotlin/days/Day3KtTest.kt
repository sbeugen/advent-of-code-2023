package days

import kotlin.test.Test

class Day3KtTest {

    @Test
    fun testDay3Part1() {
        val testInput = "xmul(2,4)%&mul[3,7]!@^do_not_mul(5,5)+mul(32,64]then(mul(11,8)mul(8,5))"
        val day3 = Day3(testInput)
        day3.execute(1)
    }

    @Test
    fun testDay3Part2() {
        val testInput = "xmul(2,4)&mul[3,7]!^don't()_mul(5,5)+mul(32,64](mul(11,8)undo()?mul(8,5))"
        val day3 = Day3(testInput)
        day3.execute(2)
    }
}