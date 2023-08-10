package days

import api.fetchData

fun day17(part: Int) {
    val data = fetchData(17)

    when (part) {
        1 -> part1()
        2 -> part2()
        else -> throw Exception("Unknown part $part")
    }
}

private fun part1() {
    println("day 17; part 1")
}

private fun part2() {
    println("day 17; part 2")
}
