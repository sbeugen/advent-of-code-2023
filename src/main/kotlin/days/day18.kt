package days

import api.fetchData

fun day18(part: Int) {
    val data = fetchData(18)

    when (part) {
        1 -> part1()
        2 -> part2()
        else -> throw Exception("Unknown part $part")
    }
}

private fun part1() {
    println("day 18; part 1")
}

private fun part2() {
    println("day 18; part 2")
}
