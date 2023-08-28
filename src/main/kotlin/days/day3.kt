package days

import api.fetchData
import kotlin.math.floor

fun day3(part: Int) {
    val data = fetchData(3)
    val backpacks = data.removeSuffix("\n").split("\n")

    when (part) {
        1 -> part1(backpacks)
        2 -> part2(backpacks)
        else -> throw Exception("Unknown part $part")
    }
}

private fun part1(backpacks: List<String>) {
    val compartments = backpacks.map {
        val middleIndex = floor((it.length / 2).toDouble()).toInt()
        Pair(it.substring(0, middleIndex), it.substring(middleIndex))
    }
    val result = compartments.sumOf {
        val first = it.first.splitWithoutEmptyStrings().toSet()
        val second = it.second.splitWithoutEmptyStrings().toSet()
        val code = first.intersect(second).first().first().code

        getPriorityForCharCode(code)
    }

    println(result)
}

private fun part2(backpacks: List<String>) {
    val result = backpacks.chunked(3).sumOf {
        val code = it[0].splitWithoutEmptyStrings().intersect(it[1].splitWithoutEmptyStrings().toSet())
            .intersect(it[2].splitWithoutEmptyStrings().toSet()).first().first().code

        getPriorityForCharCode(code)
    }

    println(result)
}

private fun String.splitWithoutEmptyStrings() = this.split("").filter { it != "" }

private fun getPriorityForCharCode(charCode: Int) = if (charCode <= 90) charCode - 38 else charCode - 96