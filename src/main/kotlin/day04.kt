import kotlin.io.readLines
import java.io.File

fun main() {

// Path to the text file
    val filePath = "src/main/kotlin/day04_input.txt"

    // Read the lines of the text file
    val input = File(filePath).readLines()
    // Check if the input list is empty
    if (input.isEmpty()) {
        // Print an error message
        println("Error: The input file is empty.")

        // Skip the rest of the code and exit the program
        return
    }
    // list of section assignment pairs
    try {
        val pairs = input.map { line ->
            val (range1, range2) = line.split(",")
            val (start1, end1) = range1.split("-").map { it.toInt() }
            val (start2, end2) = range2.split("-").map { it.toInt() }
            (start1..end1).toList() to (start2..end2).toList()
        }
        // count the number of pairs where one range fully contains the other
        val count = pairs.count { (range1, range2) ->
            range1.containsAll(range2) || range2.containsAll(range1)
        }
        println("Part one: $count")

        // Iterate over the list of pairs and check if they overlap
        var count2 = 0
        for ((range1, range2) in pairs) {
            // Check if the two ranges overlap
            if (range1.any { it in range2 }) {
                count2++
            }
        }

// Return the number of overlapping pairs
        println("Part two: $count2")

    } catch (e: IndexOutOfBoundsException) {
        // Print an error message
        println("Error: The input list does not have enough elements.")

        // Skip the map function and move on to the next step in the program
        return
    }
}







