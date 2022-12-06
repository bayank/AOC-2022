import kotlin.io.readLines
import java.io.File

fun main() {

// Get the rucksacks from the puzzle input
    // Path to the text file
    val filePath = "src/main/kotlin/day03_input.txt"

// Read the lines of the text file
    val lines = File(filePath).readLines()

// Store the lines of the text file in a list
    val rucksacks = mutableListOf<String>()
    rucksacks.addAll(lines)

// Initialize the sum of priorities to 0
    var sumOfPriorities = 0

// Go through each rucksack
    for (rucksack in rucksacks) {
        // Get the length of the rucksack
        val n = rucksack.length

        // Get the items in the first compartment of the rucksack
        val firstCompartment = rucksack.substring(0, n / 2).toSet()

        // Get the items in the second compartment of the rucksack
        val secondCompartment = rucksack.substring(n / 2).toSet()

        // Get the items that appear in both compartments of the rucksack
        val commonItems = firstCompartment.intersect(secondCompartment)

        // There should be exactly one item that appears in both compartments
        // of the rucksack, so get the first item from the set of common items
        val item = commonItems.first()

        // Compute the priority of the item
        // Lowercase letters have priorities 1 through 26,
        // and uppercase letters have priorities 27 through 52
        val priority = if (item.isLowerCase()) {
            item.toInt() - 'a'.toInt() + 1
        } else {
            item.toInt() - 'A'.toInt() + 27
        }

        // Add the priority of the item to the sum of priorities
        sumOfPriorities += priority
    }

// Print the sum of priorities
    println("Part one: " + sumOfPriorities)

// split the list of rucksacks into groups of three
    val groups = rucksacks.chunked(3)

// for each group, find the badge item type and convert it to a priority
    val badgePriorities = groups.map { group ->
        // for each rucksack in the group, create a set of the unique item types in that rucksack
        val itemSets = group.map { rucksack -> rucksack.toSet() }

        // find the badge item type by taking the intersection of the sets of unique item types
        val badge = itemSets.reduce { set1, set2 -> set1 intersect set2 }.single()

        // convert the badge item type to a priority
        val priority = if (badge.isLowerCase()) {
            badge - 'a' + 1
        } else {
            badge - 'A' + 27
        }

        // return the priority
        priority
    }

// find the sum of the badge priorities
    val sum = badgePriorities.sum()
    println("Part 2: " + sum) // 70

}




