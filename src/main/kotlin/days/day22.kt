package days

import api.fetchData

fun day22(part: Int) {
    val data = fetchData(22)

    when (part) {
        1 -> part1()
        2 -> part2()
        else -> throw Exception("Unknown part $part")
    }
}

private fun part1() {
    println("day 22; part 1")
}

private fun part2() {
    println("day 22; part 2")
}
