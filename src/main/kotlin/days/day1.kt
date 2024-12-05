package days

import kotlin.math.abs

class Day1(data: String) {
    private val firstColumn = mutableListOf<Int>()
    private val secondColumn = mutableListOf<Int>()
    private val numberMatcherRegex = Regex("(\\d+)")

    init {
        data.trim().split("\n")
            .forEach {
                val values = numberMatcherRegex.findAll(it)
                firstColumn.add(values.first().value.toInt())
                secondColumn.add(values.last().value.toInt())
            }
    }


    fun execute(part: Int) {
        when (part) {
            1 -> part1()
            2 -> part2()
            else -> throw Exception("Unknown part $part")
        }
    }

    private fun part1() {
        firstColumn.sort()
        secondColumn.sort()

        val result = firstColumn.indices.sumOf {
            abs(firstColumn[it] - secondColumn[it])
        }

        println("result = $result")
    }

    private fun part2() {
        val result = firstColumn.sumOf { entry ->
            entry * secondColumn.count { entry == it }
        }

        println("result = $result")
    }
}
