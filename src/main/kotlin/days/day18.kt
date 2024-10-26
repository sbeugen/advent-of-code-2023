package days

class Day18(private val data: String) {
    fun execute(part: Int) {
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
}
