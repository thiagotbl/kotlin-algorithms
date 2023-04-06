package number_of_closed_islands

class NumberClosedIslands {
    fun closedIsland(grid: Array<IntArray>): Int {
        var count = 0

        for (i in grid.indices) {
            for (j in grid[i].indices) {
                if (!isGround(grid, i, j) || !isClosed(grid, i, j)) {
                    continue
                }

                count++
            }
        }

        return count
    }

    private fun isClosed(grid: Array<IntArray>, i: Int, j: Int): Boolean {
        if (isOutOfBounds(grid, i, j) || isOpenIsland(grid, i, j)) {
            return false
        }

        if (isGround(grid, i, j) && isOnEdge(grid, i, j)) {
            chartAsOpenIsland(grid, i, j)

            return false
        }

        if (isWater(grid, i, j) || wasVisited(grid, i , j)) {
            return true
        }

        visit(grid, i, j)

        return isClosed(grid, i + 1, j) &&
                isClosed(grid, i - 1, j) &&
                isClosed(grid, i, j + 1) &&
                isClosed(grid, i, j - 1)
    }

    private fun isOutOfBounds(grid: Array<IntArray>, i: Int, j: Int): Boolean {
        return i < 0 || i >= grid.size || j < 0 || j >= grid[i].size
    }

    private fun isGround(grid: Array<IntArray>, i: Int, j: Int): Boolean {
        return grid[i][j] == 0
    }

    private fun isWater(grid: Array<IntArray>, i: Int, j: Int): Boolean {
        return grid[i][j] == 1
    }

    private fun wasVisited(grid: Array<IntArray>, i: Int, j: Int): Boolean {
        return grid[i][j] == 2
    }

    private fun isOnEdge(grid: Array<IntArray>, i: Int, j: Int): Boolean {
        return i == 0 || i == grid.size - 1 || j == 0 || j == grid[0].size - 1
    }

    private fun visit(grid: Array<IntArray>, i: Int, j: Int) {
        grid[i][j] = 2
    }

    private fun chartAsOpenIsland(grid: Array<IntArray>, i: Int, j: Int) {
        if (isOutOfBounds(grid, i, j) || isWater(grid, i, j) || isOpenIsland(grid, i, j)) {
            return
        }

        setAsOpen(grid, i, j)

        chartAsOpenIsland(grid, i + 1, j)
        chartAsOpenIsland(grid, i - 1, j)
        chartAsOpenIsland(grid, i, j + 1)
        chartAsOpenIsland(grid, i, j - 1)
    }

    private fun setAsOpen(grid: Array<IntArray>, i: Int, j: Int) {
        grid[i][j] = 3
    }

    private fun isOpenIsland(grid: Array<IntArray>, i: Int, j: Int): Boolean {
        return grid[i][j] == 3
    }
}
