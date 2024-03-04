package com.example.dojodemo

fun minimumTotal(triangle: List<List<Int>>): Int {
    val size = triangle.size
    val minimumSumByRow = IntArray(size)

    // Initialize minimumSumByRow array with the bottom row of the triangle
    for (i in 0 until size) {
        minimumSumByRow[i] = triangle[size - 1][i]
    }

    // Build the minimumSumByRow array from bottom to top
    for (i in size - 2 downTo 0) {
        for (j in 0..i) {
            minimumSumByRow[j] = triangle[i][j] + minOf(minimumSumByRow[j], minimumSumByRow[j + 1])
        }
    }

    // The final result is stored in minimumSumByRow[0]
    return minimumSumByRow[0]
}

fun main() {
    val triangle = listOf(
        listOf(2),
        listOf(3, 4),
        listOf(6, 5, 7),
        listOf(4, 1, 8, 3)
    )

    val result = minimumTotal(triangle)
    println("The minimum path sum from top to bottom is: $result")

    val triangle2 = listOf(
        listOf(4),
        listOf(5, 4),
        listOf(1, 5, 7),
        listOf(9, 1, 2, 3),
        listOf(6, 8, 6, 9, 2)
    )

    val result2 = minimumTotal(triangle2)
    println("The minimum path sum from top to bottom is: $result2")
}