package days

import api.fetchData

fun day20(part: Int) {
    val data = fetchData(20)

    when (part) {
        1 -> part1()
        2 -> part2()
        else -> throw Exception("Unknown part $part")
    }
}

private fun part1() {
    println("day 20; part 1")
}

private fun part2() {
    println("day 20; part 2")
}
