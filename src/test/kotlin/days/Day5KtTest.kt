package days

import kotlin.test.Test

class Day5KtTest {
    val testInput = """
        47|53
        97|13
        97|61
        97|47
        75|29
        61|13
        75|53
        29|13
        97|29
        53|29
        61|53
        97|53
        61|29
        47|13
        75|47
        97|75
        47|61
        75|61
        47|29
        75|13
        53|13
        
        75,47,61,53,29
        97,61,53,29,13
        75,29,13
        75,97,47,61,53
        61,13,29
        97,13,75,29,47
    """.trimIndent()

    @Test
    fun testDay5Part1() {
        val day5 = Day5(testInput)
        day5.execute(1)
    }

    @Test
    fun testDay5Part2() {
        val day5 = Day5(testInput)
        day5.execute(2)
    }
}