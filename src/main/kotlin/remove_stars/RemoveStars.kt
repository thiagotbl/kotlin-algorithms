package remove_stars

class RemoveStars {
    fun removeStars(s: String): String {
        val result = StringBuilder()

        var stars = 0
        for (c in s.reversed()) {
            if (c == '*') {
                stars++
            } else if (stars > 0) {
                stars -= 1
            } else {
                result.append(c)
            }
        }

        return result.reversed().toString()
    }
}

fun main() {
    val removeStars = RemoveStars()

    println("input: leet**cod*e, expected: lecoe, output: ${removeStars.removeStars("leet**cod*e")}")
    println("input: erase*****, expected: '', output: ${removeStars.removeStars("erase*****")}")
}
