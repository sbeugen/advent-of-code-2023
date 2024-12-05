package days

class Day4(private val data: String) {
    private val grid: List<List<String>> = data.trim().lines().map {
        val splitLine = it.split("")
        splitLine.subList(1, splitLine.size - 1)
    }


    fun execute(part: Int) {
        when (part) {
            1 -> part1()
            2 -> part2()
            else -> throw Exception("Unknown part $part")
        }
    }

    private fun part1() {
        val maxRowIndex = grid.size - 1
        val maxColumnIndex = grid.first().size - 1

        val result = grid.foldIndexed(0) { rowIndex, xmasCount, line ->
            var tempXmasCount = xmasCount

            line.forEachIndexed { columnIndex, letter ->
                if (letter == "X") {
                    // check up
                    if (rowIndex >= 3 && grid[rowIndex - 1][columnIndex] == "M" && grid[rowIndex - 2][columnIndex] == "A" && grid[rowIndex - 3][columnIndex] == "S") {
                        tempXmasCount++
                    }

                    // check right
                    if (columnIndex <= maxColumnIndex - 3 && grid[rowIndex][columnIndex + 1] == "M" && grid[rowIndex][columnIndex + 2] == "A" && grid[rowIndex][columnIndex + 3] == "S") {
                        tempXmasCount++
                    }

                    // check down
                    if (rowIndex <= maxRowIndex - 3 && grid[rowIndex + 1][columnIndex] == "M" && grid[rowIndex + 2][columnIndex] == "A" && grid[rowIndex + 3][columnIndex] == "S") {
                        tempXmasCount++
                    }

                    // check left
                    if (columnIndex >= 3 && grid[rowIndex][columnIndex - 1] == "M" && grid[rowIndex][columnIndex - 2] == "A" && grid[rowIndex][columnIndex - 3] == "S") {
                        tempXmasCount++
                    }

                    // check up right
                    if (rowIndex >= 3 && columnIndex <= maxColumnIndex - 3 && grid[rowIndex - 1][columnIndex + 1] == "M" && grid[rowIndex - 2][columnIndex + 2] == "A" && grid[rowIndex - 3][columnIndex + 3] == "S") {
                        tempXmasCount++
                    }

                    // check up left
                    if (rowIndex >= 3 && columnIndex >= 3 && grid[rowIndex - 1][columnIndex - 1] == "M" && grid[rowIndex - 2][columnIndex - 2] == "A" && grid[rowIndex - 3][columnIndex - 3] == "S") {
                        tempXmasCount++
                    }

                    // check down right
                    if (rowIndex <= maxRowIndex - 3 && columnIndex <= maxColumnIndex - 3 && grid[rowIndex + 1][columnIndex + 1] == "M" && grid[rowIndex + 2][columnIndex + 2] == "A" && grid[rowIndex + 3][columnIndex + 3] == "S") {
                        tempXmasCount++
                    }

                    // check down left
                    if (rowIndex <= maxRowIndex - 3 && columnIndex >= 3 && grid[rowIndex + 1][columnIndex - 1] == "M" && grid[rowIndex + 2][columnIndex - 2] == "A" && grid[rowIndex + 3][columnIndex - 3] == "S") {
                        tempXmasCount++
                    }
                }
            }
            tempXmasCount
        }
        println("result = $result")
    }

    private fun part2() {
        val maxRowIndex = grid.size - 1
        val maxColumnIndex = grid.first().size - 1

        val result = grid.foldIndexed(0) { rowIndex, xmasCount, line ->
            var tempXmasCount = xmasCount

            line.forEachIndexed { columnIndex, letter ->
                if (letter == "A") {
                    if (rowIndex in 1..<maxRowIndex && columnIndex in 1..<maxColumnIndex &&
                        (
                                (grid[rowIndex + 1][columnIndex + 1] == "M" && grid[rowIndex - 1][columnIndex + 1] == "M" && grid[rowIndex + 1][columnIndex - 1] == "S" && grid[rowIndex - 1][columnIndex - 1] == "S") ||
                                        (grid[rowIndex - 1][columnIndex - 1] == "M" && grid[rowIndex - 1][columnIndex + 1] == "M" && grid[rowIndex + 1][columnIndex + 1] == "S" && grid[rowIndex + 1][columnIndex - 1] == "S") ||
                                        (grid[rowIndex + 1][columnIndex - 1] == "M" && grid[rowIndex - 1][columnIndex - 1] == "M" && grid[rowIndex - 1][columnIndex + 1] == "S" && grid[rowIndex + 1][columnIndex + 1] == "S") ||
                                        (grid[rowIndex + 1][columnIndex + 1] == "M" && grid[rowIndex + 1][columnIndex - 1] == "M" && grid[rowIndex - 1][columnIndex - 1] == "S" && grid[rowIndex - 1][columnIndex + 1] == "S")
                                )
                    ) {
                        tempXmasCount++
                    }
                }
            }
            tempXmasCount
        }
        println("result = $result")
    }
}
