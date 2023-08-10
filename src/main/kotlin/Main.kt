import days.*
import kotlin.time.measureTime

fun main(args: Array<String>) {
    val time = measureTime {
        val day = args[0].toInt()
        val part = args[1].toInt()

        when (day) {
            1 -> day1(part)
            2 -> day2(part)
            3 -> day3(part)
            4 -> day4(part)
            5 -> day5(part)
            6 -> day6(part)
            7 -> day7(part)
            8 -> day8(part)
            9 -> day9(part)
            10 -> day10(part)
            11 -> day11(part)
            12 -> day12(part)
            13 -> day13(part)
            14 -> day14(part)
            15 -> day15(part)
            16 -> day16(part)
            17 -> day17(part)
            18 -> day18(part)
            19 -> day19(part)
            20 -> day20(part)
            21 -> day21(part)
            22 -> day22(part)
            23 -> day23(part)
            24 -> day24(part)
            25 -> day25(part)
            else -> throw Exception("Unknown day $day")
        }
    }

    println("Total duration (including fetching input data): $time")
}