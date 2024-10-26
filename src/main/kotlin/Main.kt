import api.DataProvider
import days.*
import kotlin.time.measureTime

fun main(args: Array<String>) {
    val day = args[0].toInt()
    val part = args[1].toInt()

    val dataProvider = DataProvider()
    val data = dataProvider.fetchData(day)

    val time = measureTime {
        when (day) {
            1 -> Day1(data).execute(part)
            2 -> Day2(data).execute(part)
            3 -> Day3(data).execute(part)
            4 -> Day4(data).execute(part)
            5 -> Day5(data).execute(part)
            6 -> Day6(data).execute(part)
            7 -> Day7(data).execute(part)
            8 -> Day8(data).execute(part)
            9 -> Day9(data).execute(part)
            10 -> Day10(data).execute(part)
            11 -> Day11(data).execute(part)
            12 -> Day12(data).execute(part)
            13 -> Day13(data).execute(part)
            14 -> Day14(data).execute(part)
            15 -> Day15(data).execute(part)
            16 -> Day16(data).execute(part)
            17 -> Day17(data).execute(part)
            18 -> Day18(data).execute(part)
            19 -> Day19(data).execute(part)
            20 -> Day20(data).execute(part)
            21 -> Day21(data).execute(part)
            22 -> Day22(data).execute(part)
            23 -> Day23(data).execute(part)
            24 -> Day24(data).execute(part)
            25 -> Day25(data).execute(part)
            else -> throw Exception("Unknown day $day")
        }
    }

    println("Total duration: $time")
}