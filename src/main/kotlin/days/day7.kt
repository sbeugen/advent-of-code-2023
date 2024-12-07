package days

import java.math.BigDecimal

private data class CalibrationLine(val testResult: BigDecimal, val inputValues: List<BigDecimal>) {
    private fun doCalibration(acc: BigDecimal, value: BigDecimal, calibrationMethod: CalibrationMethods): BigDecimal {
        return when (calibrationMethod) {
            CalibrationMethods.SUM -> acc + value
            CalibrationMethods.MULTIPLY -> acc * value
            CalibrationMethods.CONCATENATE -> (acc.toPlainString() + value.toPlainString()).toBigDecimal()
        }
    }

    fun isValidCalibration(possibleCalibrations: List<List<CalibrationMethods>>): Boolean {
        for (calibration in possibleCalibrations) {
            val result = inputValues.reduceIndexed { index, acc, value ->
                doCalibration(acc, value, calibration[index - 1])
            }

            if (result == testResult) {
                return true
            }
        }
        return false
    }
}

enum class CalibrationMethods {
    SUM, MULTIPLY, CONCATENATE
}

class Day7(data: String) {
    private val numberRegex = Regex("\\d+")
    private val calibrationLines: List<CalibrationLine> = data.trim().lines().map { line ->
        val splitLine = line.split(":")
        CalibrationLine(
            testResult = splitLine.first().toBigDecimal(),
            inputValues = numberRegex.findAll(splitLine.last()).toList()
                .map { it.value }
                .map { it.toBigDecimal() }
        )
    }


    fun execute(part: Int) {
        when (part) {
            1 -> part1()
            2 -> part2()
            else -> throw Exception("Unknown part $part")
        }
    }

    private fun part1() {
        val result = calibrationLines
            .filter {
                it.isValidCalibration(
                    generatePermutations(
                        it.inputValues.size - 1,
                        listOf(CalibrationMethods.SUM, CalibrationMethods.MULTIPLY)
                    )
                )
            }
            .sumOf { it.testResult }

        println("result = ${result.toPlainString()}")
    }

    private fun part2() {
        val result = calibrationLines
            .filter {
                it.isValidCalibration(
                    generatePermutations(
                        it.inputValues.size - 1,
                        CalibrationMethods.entries
                    )
                )
            }
            .sumOf { it.testResult }

        println("result = ${result.toPlainString()}")
    }
}

private fun List<BigDecimal>.multiply(): BigDecimal {
    return this.reduce { acc, current ->
        acc * current
    }
}

private fun generatePermutations(
    size: Int,
    calibrationMethods: List<CalibrationMethods>
): List<List<CalibrationMethods>> {
    val result = mutableListOf<List<CalibrationMethods>>()

    fun backtrack(current: MutableList<CalibrationMethods>) {
        if (current.size == size) {
            result.add(current.toList())
            return
        }

        for (calibrationMethod in calibrationMethods) {
            current.add(calibrationMethod)
            backtrack(current)
            current.removeAt(current.lastIndex)
        }
    }

    backtrack(mutableListOf())
    return result
}