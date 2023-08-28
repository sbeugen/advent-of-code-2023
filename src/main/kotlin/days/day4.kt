package days

import api.fetchData
import java.lang.Exception

data class Range(val start: Int, val end: Int)

fun day4(part: Int) {
    val data = fetchData(4)
    val rangePairs: List<Pair<Range, Range>> = data.removeSuffix("\n").split("\n")
        .map { row ->
            val entries = row.split(",")
            val firstRange = entries[0].split("-")
            val secondRange = entries[1].split("-")
            Pair(
                Range(firstRange[0].toInt(), firstRange[1].toInt()),
                Range(secondRange[0].toInt(), secondRange[1].toInt())
            )
        }

    when (part) {
        1 -> part1(rangePairs)
        2 -> part2(rangePairs)
        else -> throw Exception("Unknown part $part")
    }
}

private fun part1(rangePairs: List<Pair<Range, Range>>) {
    val result = rangePairs.count {
        (it.first.start <= it.second.start && it.first.end >= it.second.end) || (it.second.start <= it.first.start && it.second.end >= it.first.end)
    }
    println(result)
}

private fun part2(rangePairs: List<Pair<Range, Range>>) {
    val result = rangePairs.count {
        (it.first.start <= it.second.start && it.first.end >= it.second.start)
                || (it.first.end >= it.second.end && it.first.start <= it.second.end)
                || (it.second.start <= it.first.start && it.second.end >= it.first.start)
                || (it.second.end >= it.first.end && it.second.start <= it.first.end)
    }
    println(result)
}

private fun rangeStringToRangeList(rangeString: String): IntRange {
    val splitRange = rangeString.split("-")
    return splitRange[0].toInt()..splitRange[1].toInt()
}