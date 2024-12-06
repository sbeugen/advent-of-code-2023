package days

class Day6(private val data: String) {
    private var grid = initGrid()

    private fun initGrid(): List<MutableList<String>> {
        return data.trim().lines().map {
            val splitLine = it.split("")
            splitLine.filter { entry -> entry != "" }.toMutableList()
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
        val startRowIndex =
            grid.indexOfFirst { it.contains("^") || it.contains(">") || it.contains("<") || it.contains("v") }
        val startColumnIndex =
            grid[startRowIndex].indexOfFirst { it == "^" || it == ">" || it == "<" || it == "v" }

        val startDirection = getDirection(grid[startRowIndex][startColumnIndex])
        walk(grid, startDirection, startRowIndex, startColumnIndex)

        val result = grid.sumOf { it.count { entry -> entry == "X" } }

        println("result = $result")
    }

    private fun part2() {
        val startRowIndex =
            grid.indexOfFirst { it.contains("^") || it.contains(">") || it.contains("<") || it.contains("v") }
        val startColumnIndex =
            grid[startRowIndex].indexOfFirst { it == "^" || it == ">" || it == "<" || it == "v" }

        val startDirection = getDirection(grid[startRowIndex][startColumnIndex])

        var result = 0
        for (row in grid.indices) {
            for (column in grid.first().indices) {
                if (grid[row][column] != "#") {
                    grid[row][column] = "#"
                    if (isLoop(grid, startDirection, startRowIndex, startColumnIndex, 0)) {
                        result++
                    }
                }
                grid = initGrid()
            }
        }

        println("result = $result")
    }
}

private enum class Direction {
    UP, RIGHT, DOWN, LEFT
}

private fun getDirection(symbol: String): Direction {
    return when (symbol) {
        "^" -> Direction.UP
        ">" -> Direction.RIGHT
        "v" -> Direction.DOWN
        "<" -> Direction.LEFT
        else -> throw Exception("Unknown direction symbol")
    }
}

private fun walk(grid: List<MutableList<String>>, direction: Direction, rowIndex: Int, columnIndex: Int) {
    val maxRowIndex = grid.size - 1
    val maxColumnIndex = grid.first().size - 1

    grid[rowIndex][columnIndex] = "X"

    if (direction == Direction.UP) {
        if (rowIndex - 1 >= 0 && grid[rowIndex - 1][columnIndex] != "#") {
            walk(grid, Direction.UP, rowIndex - 1, columnIndex)
        } else if (rowIndex - 1 >= 0 && grid[rowIndex - 1][columnIndex] == "#") {
            walk(grid, Direction.RIGHT, rowIndex, columnIndex)
        }
    } else if (direction == Direction.RIGHT) {
        if (columnIndex + 1 <= maxColumnIndex && grid[rowIndex][columnIndex + 1] != "#") {
            walk(grid, Direction.RIGHT, rowIndex, columnIndex + 1)
        } else if (columnIndex + 1 <= maxColumnIndex && grid[rowIndex][columnIndex + 1] == "#") {
            walk(grid, Direction.DOWN, rowIndex, columnIndex)
        }
    } else if (direction == Direction.DOWN) {
        if (rowIndex + 1 <= maxRowIndex && grid[rowIndex + 1][columnIndex] != "#") {
            walk(grid, Direction.DOWN, rowIndex + 1, columnIndex)
        } else if (rowIndex + 1 <= maxRowIndex && grid[rowIndex + 1][columnIndex] == "#") {
            walk(grid, Direction.LEFT, rowIndex, columnIndex)
        }
    } else if (direction == Direction.LEFT) {
        if (columnIndex - 1 >= 0 && grid[rowIndex][columnIndex - 1] != "#") {
            walk(grid, Direction.LEFT, rowIndex, columnIndex - 1)
        } else if (columnIndex - 1 >= 0 && grid[rowIndex][columnIndex - 1] == "#") {
            walk(grid, Direction.UP, rowIndex, columnIndex)
        }
    }
}

private fun isLoop(
    grid: List<MutableList<String>>,
    direction: Direction,
    rowIndex: Int,
    columnIndex: Int,
    repeatedFieldCount: Int
): Boolean {
    val maxRowIndex = grid.size - 1
    val maxColumnIndex = grid.first().size - 1

    var tempRepeatedFieldCount = repeatedFieldCount

    if (tempRepeatedFieldCount == 100) {
        return true
    }

    grid[rowIndex][columnIndex] = "X"

    if (direction == Direction.UP) {
        return if (rowIndex - 1 >= 0 && grid[rowIndex - 1][columnIndex] != "#") {
            if (grid[rowIndex - 1][columnIndex] == "X") {
                tempRepeatedFieldCount++
            } else {
                tempRepeatedFieldCount = 0
            }

            isLoop(grid, Direction.UP, rowIndex - 1, columnIndex, tempRepeatedFieldCount)
        } else if (rowIndex - 1 >= 0 && grid[rowIndex - 1][columnIndex] == "#") {
            isLoop(grid, Direction.RIGHT, rowIndex, columnIndex, tempRepeatedFieldCount)
        } else {
            false
        }
    } else if (direction == Direction.RIGHT) {
        return if (columnIndex + 1 <= maxColumnIndex && grid[rowIndex][columnIndex + 1] != "#") {
            if (grid[rowIndex][columnIndex + 1] == "X") {
                tempRepeatedFieldCount++
            } else {
                tempRepeatedFieldCount = 0
            }

            isLoop(grid, Direction.RIGHT, rowIndex, columnIndex + 1, tempRepeatedFieldCount)
        } else if (columnIndex + 1 <= maxColumnIndex && grid[rowIndex][columnIndex + 1] == "#") {
            isLoop(grid, Direction.DOWN, rowIndex, columnIndex, tempRepeatedFieldCount)
        } else {
            false
        }
    } else if (direction == Direction.DOWN) {
        return if (rowIndex + 1 <= maxRowIndex && grid[rowIndex + 1][columnIndex] != "#") {
            if (grid[rowIndex + 1][columnIndex] == "X") {
                tempRepeatedFieldCount++
            } else {
                tempRepeatedFieldCount = 0
            }

            isLoop(grid, Direction.DOWN, rowIndex + 1, columnIndex, tempRepeatedFieldCount)
        } else if (rowIndex + 1 <= maxRowIndex && grid[rowIndex + 1][columnIndex] == "#") {
            isLoop(grid, Direction.LEFT, rowIndex, columnIndex, tempRepeatedFieldCount)
        } else {
            false
        }
    } else if (direction == Direction.LEFT) {
        return if (columnIndex - 1 >= 0 && grid[rowIndex][columnIndex - 1] != "#") {
            if (grid[rowIndex][columnIndex - 1] == "X") {
                tempRepeatedFieldCount++
            } else {
                tempRepeatedFieldCount = 0
            }

            isLoop(grid, Direction.LEFT, rowIndex, columnIndex - 1, tempRepeatedFieldCount)
        } else if (columnIndex - 1 >= 0 && grid[rowIndex][columnIndex - 1] == "#") {
            isLoop(grid, Direction.UP, rowIndex, columnIndex, tempRepeatedFieldCount)
        } else {
            false
        }
    }

    return false
}