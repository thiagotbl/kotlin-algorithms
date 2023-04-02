package spells_and_potions

class SpellsAndPotions {
    fun successfulPairs(spells: IntArray, potions: IntArray, success: Long): IntArray {
        potions.sort()

        return spells.map { spell ->
            val index = firstSuccessfulIndex(spell, potions, success)

            maxOf(0, potions.size - index)
        }.toIntArray()
    }

    private fun firstSuccessfulIndex(spell: Int, potions: IntArray, success: Long): Int {
        var left = 0
        var right = potions.size - 1

        while (left <= right) {
            val mid = (left + right) / 2
            val product = spell.toLong() * potions[mid]

            if (product < success) {
                left = mid + 1
            } else {
                right = mid - 1
            }
        }

        return left
    }
}



fun main() {
    val result = SpellsAndPotions().successfulPairs(
        intArrayOf(5, 1, 3), intArrayOf(1, 2, 3, 4, 5), 7
    )

    println("result: ${result.toList()}, expected: [4, 0, 3]")
}
