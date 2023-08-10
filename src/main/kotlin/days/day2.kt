package days

import api.fetchData
import java.lang.Exception

fun day2(part: Int) {
    val data = fetchData(2)
    val rounds = data.removeSuffix("\n").split("\n").map { it.replace(" ", "") }

    when (part) {
        1 -> part1(rounds)
        2 -> part2(rounds)
        else -> throw Exception("Unknown part $part")
    }
}

private fun part1(rounds: List<String>) {
    println(rounds.sumOf { pointsPerChosenPlay[it.substring(1)]!! + pointsPerCombination[it]!! })
}

private fun part2(rounds: List<String>) {
    println(rounds.sumOf {
        val play = it.replaceRange(1..1, playForStrategy[it]!!)
        pointsPerChosenPlay[play.substring(1)]!! + pointsPerCombination[play]!!
    })
}

private val pointsPerChosenPlay = mapOf(
    "X" to 1,
    "Y" to 2,
    "Z" to 3
)

private val pointsPerCombination = mapOf(
    "AX" to 3,
    "AY" to 6,
    "AZ" to 0,
    "BX" to 0,
    "BY" to 3,
    "BZ" to 6,
    "CX" to 6,
    "CY" to 0,
    "CZ" to 3,
)

private val playForStrategy = mapOf(
    "AX" to "Z",
    "AY" to "X",
    "AZ" to "Y",
    "BX" to "X",
    "BY" to "Y",
    "BZ" to "Z",
    "CX" to "Y",
    "CY" to "Z",
    "CZ" to "X",
)