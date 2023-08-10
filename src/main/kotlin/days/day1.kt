package days

import api.fetchData
import kotlin.time.measureTimedValue

// Example from 2022
fun day1(part: Int) {
    val data = fetchData(1)
    val cookiesPerElf =
        data.removeSuffix("\n").split("\n\n").map { it.split("\n").map { calories -> calories.toInt() } }

    when (part) {
        1 -> part1(cookiesPerElf)
        2 -> part2(cookiesPerElf)
        else -> throw Exception("Unknown part $part")
    }
}

private fun part1(cookiesPerElf: List<List<Int>>) {
    println(cookiesPerElf.maxOf { elf -> elf.sum() })
}

private fun part2(cookiesPerElf: List<List<Int>>) {
    measureTimedValue { println(cookiesPerElf.map { it.sum() }.sortedDescending().slice(0..2).sum()) }
}
