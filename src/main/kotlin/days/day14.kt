package days

import api.fetchData

fun day14(part: Int) {
    val data = fetchData(14)

    when (part) {
        1 -> part1()
        2 -> part2()
        else -> throw Exception("Unknown part $part")
    }
}

private fun part1() {
    println("day 14; part 1")
}

private fun part2() {
    println("day 14; part 2")
}
