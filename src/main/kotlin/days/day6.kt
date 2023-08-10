package days

import api.fetchData

fun day6(part: Int) {
    val data = fetchData(6)

    when (part) {
        1 -> part1()
        2 -> part2()
        else -> throw Exception("Unknown part $part")
    }
}

private fun part1() {
    println("day 6; part 1")
}

private fun part2() {
    println("day 6; part 2")
}
