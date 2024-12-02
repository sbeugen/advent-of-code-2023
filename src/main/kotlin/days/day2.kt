package days

class Day2(data: String) {
    private val rows: List<List<Int>>
    private val numberMatcherRegex = Regex("(\\d+)")

    init {
        rows = data.trim().lines()
            .map {
                numberMatcherRegex.findAll(it).toList().map { matchResult -> matchResult.value.toInt() }
            }
    }

    fun execute(part: Int) {
        when (part) {
            1 -> part1()
            2 -> part2()
            else -> throw Exception("Unknown part $part")
        }
    }

    private fun part1() {
        val result = rows.count { it.isSafeReport() }
        println("result = $result")
    }

    private fun part2() {
        val result = rows.count { it.isSafeReport2() }
        println("result = $result")
    }
}

enum class Order {
    ASC, DESC
}

fun List<Int>.isSafeReport(): Boolean {
    var order: Order? = null

    for (index in 0..<(this.size - 1)) {
        if (order == null) {
            order = if (this[index] > this[index + 1]) {
                Order.DESC
            } else if (this[index] < this[index + 1]) {
                Order.ASC
            } else {
                return false
            }
        }

        if (order == Order.ASC && (this[index] >= this[index + 1] || (this[index + 1] - this[index]) > 3)) {
            return false
        }

        if (order == Order.DESC && (this[index] <= this[index + 1] || (this[index] - this[index + 1]) > 3)) {
            return false
        }
    }

    return true
}

fun List<Int>.isSafeReport2(): Boolean {
    var order: Order? = null

    for (index in 0..<(this.size - 1)) {
        if (order == null) {
            order = if (this[index] > this[index + 1]) {
                Order.DESC
            } else if (this[index] < this[index + 1]) {
                Order.ASC
            } else {
                return this.indices.any { i ->
                    this.toMutableList().apply { removeAt(i) }.isSafeReport()
                }
            }
        }

        if (order == Order.ASC && (this[index] >= this[index + 1] || (this[index + 1] - this[index]) > 3)) {
            return this.indices.any { i ->
                this.toMutableList().apply { removeAt(i) }.isSafeReport()
            }
        }

        if (order == Order.DESC && (this[index] <= this[index + 1] || (this[index] - this[index + 1]) > 3)) {
            return this.indices.any { i ->
                this.toMutableList().apply { removeAt(i) }.isSafeReport()
            }
        }
    }

    return true
}