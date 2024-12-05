package days

import kotlin.math.floor

class Day5(private val data: String) {
    private val orderRules: Map<Int, List<Int>>
    private val printingInstructions: List<List<Int>>

    init {
        val splitInput = data.trim().split("\n\n")

        printingInstructions = splitInput.last().lines().map {
            it.split(",").map { entry -> entry.toInt() }
        }

        orderRules = splitInput.first().lines().fold(mutableMapOf<Int, MutableList<Int>>()) { acc, line ->
            val splitLine = line.split("|")
            val firstNumber = splitLine.first().toInt()
            val secondNumber = splitLine.last().toInt()

            if (acc[secondNumber] == null) {
                acc[secondNumber] = mutableListOf(firstNumber)
            } else {
                acc[secondNumber]!!.addLast(firstNumber)
            }

            acc
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
        val result = printingInstructions.filter { it.isCorrectlySorted(orderRules) }.sumOf { line ->
            line[floor(line.size.toDouble() / 2).toInt()]
        }
        println("result = $result")
    }

    private fun part2() {
        val result = printingInstructions
            .filter { line -> !line.isCorrectlySorted(orderRules) }
            .sumOf { line ->
                val sortedLine = line.sortAccordingToRules(orderRules)
                sortedLine[floor(sortedLine.size.toDouble() / 2).toInt()]
            }

        println("result = $result")
    }
}

private fun List<Int>.isCorrectlySorted(rules: Map<Int, List<Int>>): Boolean {
    return this.mapIndexed { index, entry ->
        if (index == this.size - 1 || rules[entry] == null) {
            true
        } else {
            val rulesForCurrentEntry = rules[entry]!!
            this.subList(index + 1, this.size)
                .none { rulesForCurrentEntry.contains(it) }
        }

    }.all { it }
}


private fun List<Int>.sortAccordingToRules(rules: Map<Int, List<Int>>): List<Int> {
    return this.sortedWith(object : Comparator<Int> {
        override fun compare(o1: Int, o2: Int): Int {
            val rulesForCurrentEntry = rules[o1] ?: return 0

            return if (rulesForCurrentEntry.contains(o2)) {
                -1
            } else {
                1
            }
        }
    })
}