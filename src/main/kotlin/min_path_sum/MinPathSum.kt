package min_path_sum

import kotlin.math.min

class MinPathSum {
    private val memo = mutableMapOf<String, Int>()

    fun minPathSum(grid: Array<IntArray>): Int {
        return minPath(grid, 0, 0)
    }

    private fun minPath(grid: Array<IntArray>, i: Int, j: Int): Int {
        if (i >= grid.size || j >= grid[i].size) {
            return Int.MAX_VALUE
        }

        if (i == grid.size - 1 && j == grid[i].size - 1) {
            return grid[i][j]
        }

        return memo.getOrPut("$i,$j") {
            grid[i][j] + min(
                minPath(grid, i + 1, j),
                minPath(grid, i, j + 1)
            )
        }
    }
}

fun main() {
    val grid = arrayOf(
        intArrayOf(1, 3, 1),
        intArrayOf(1, 5, 1),
        intArrayOf(4, 2, 1)
    )

    val minPath = MinPathSum().minPathSum(grid)

    println(minPath)
}
