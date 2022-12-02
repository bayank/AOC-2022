import java.io.File

fun main() {
    fun parseInput(input: String) = input.split("\n\n").map { elf ->
            elf.lines().map { it.toInt() }
        }

    fun part1(input: String): Int{
        val data = parseInput(input)
        return data.maxOf { it.sum() }
    }

    fun part2(input: String) : Int {
        val data = parseInput(input)
        return data
            .map { it.sum() }
            .sortedDescending()
            .take(3)
            .sum()
    }

    val input = File("src/main/kotlin/input.txt").readText()
    println(part1(input))
    println(part2(input))
}