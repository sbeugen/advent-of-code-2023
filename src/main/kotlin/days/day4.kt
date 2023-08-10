package days

import api.fetchData

fun day4(part: Int) {
    val data = fetchData(4)

    when (part) {
        1 -> part1()
        2 -> part2()
        else -> throw Exception("Unknown part $part")
    }
}

private fun part1() {
    println("day 4; part 1")
}

private fun part2() {
    println("day 4; part 2")
}
