import java.io.File
fun main() {
    val input = File("src/main/kotlin/day02_input.txt").readText()
    println("Part 1 answer is: " + part1(input))
    println("Part 2 answer is: " + part2(input))
}

fun part1(input: String): Int {
    return input.lineSequence()
        .map { it.get(0) to it.get(2).minus(23) }
        .map { (theirs, mine) ->
            val myScore = mine.minus('A').plus(1)
            val theirScore = when(mine.minus(theirs)) {
                -2 -> 6
                -1 -> 0
                0 -> 3
                1 -> 6
                2 -> 0
                else -> 0
            }
            myScore + theirScore
        }.sum()
}
fun part2(input: String): Int {
    return input.lineSequence()
        .map { it.get(0) to it.get(2) }
        .map { (theirs, outcome) ->
            theirs to when (outcome) {
                'X' -> 'A'.plus(theirs.minus('A').minus(1).mod(3)) // Lose
                'Y' -> theirs // Draw
                'Z' -> 'A'.plus(theirs.minus('A').plus(1).mod(3)) // Win
                else -> theirs
            }
        }
        .map { (theirs, mine) ->
            val myScore = mine.minus('A').plus(1)
            val theirScore = when(mine.minus(theirs).mod(3)) {
                -2 -> 6
                -1 -> 0
                0 -> 3
                1 -> 6
                2 -> 0
                else -> 0
            }
            myScore + theirScore
        }.sum()
}