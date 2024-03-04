package com.example.dojodemo

fun tripletSum(nInt: IntArray): List<List<Int>> {
    val result: MutableList<List<Int>> = mutableListOf()

    // Sort the array
    nInt.sort()

    for (i in 0 until nInt.size - 2) {
        // Skip duplicates for the first element of the triplet
        if (i > 0 && nInt[i] == nInt[i - 1]) continue

        // Set the directions
        var left = i + 1
        var right = nInt.size - 1

        while (left < right) {
            val sum = nInt[i] + nInt[left] + nInt[right]

            when {
                sum == 0 -> {
                    result.add(listOf(nInt[i], nInt[left], nInt[right]))

                    // Skip duplicates for the second element of the triplet
                    while (left < right && nInt[left] == nInt[left + 1]) left++
                    // Skip duplicates for the third element of the triplet
                    while (left < right && nInt[right] == nInt[right - 1]) right--

                    left++
                    right--
                }
                // Move to left
                sum < 0 -> left++
                // Move to Right
                else -> right--
            }
        }
    }

    return result
}

fun main() {
    val integers = intArrayOf(-1, 0, 1, 2, -1, -4)
    val result = tripletSum(integers)
    println("Unique triplets that sum to zero: $result")

    val integers2 = intArrayOf(-1, 2, 1, 2, -1, -4)
    val result2 = tripletSum(integers2)
    println("Unique triplets that sum to zero: $result2")
}