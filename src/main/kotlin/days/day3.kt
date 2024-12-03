package days

class Day3(private val data: String) {
    private val instructionRegex = Regex("mul\\(\\d{1,3},\\d{1,3}\\)")
    private val instructionRegex2 = Regex("(mul\\(\\d{1,3},\\d{1,3}\\))|(do\\(\\))|(don't\\(\\))")
    private val numberRegex = Regex("\\d{1,3}")

    fun execute(part: Int) {
        when (part) {
            1 -> part1()
            2 -> part2()
            else -> throw Exception("Unknown part $part")
        }
    }

    private fun part1() {
        val result = instructionRegex.findAll(data).toList().map { it.value }.sumOf {
            val matches = numberRegex.findAll(it)
            matches.first().value.toInt() * matches.last().value.toInt()
        }

        println("result = $result")
    }

    private fun part2() {
        val instructions = instructionRegex2.findAll(data).map { it.value }.toList()

        var active = true
        var result = 0

        for (instruction in instructions) {
            val numberMatches = numberRegex.findAll(instruction).map { it.value.toInt() }.toList()
            if (numberMatches.isNotEmpty() && active) {
                result += numberMatches.first() * numberMatches.last()
            }

            active = when (instruction) {
                "do()" -> true
                "don't()" -> false
                else -> active
            }
        }

        println("result = $result")
    }
}
