package valid_parentheses

class ValidParentheses {
    fun isValid(s: String): Boolean {
        val openingChars = setOf('(', '[', '{')
        val closingChars = setOf(')', ']', '}')

        val stack = ArrayDeque<Char>()

        s.forEach { char ->
            if (openingChars.contains(char)) {
                stack.addLast(char)
            } else if (closingChars.contains(char)) {
                if (
                    stack.isEmpty() ||
                    (char == ')' && stack.last() != '(') ||
                    (char == ']' && stack.last() != '[') ||
                    (char == '}' && stack.last() != '{')
                ) {
                    return false
                }

                stack.removeLast()
            }
        }

        return stack.isEmpty()
    }
}

fun main() {
    val validParentheses = ValidParentheses()

    println("input: '()', expected: true, result: ${validParentheses.isValid("()")}")
    println("input: '()[]{}', expected: true, result: ${validParentheses.isValid("()[]{}")}")
    println("input: '(]', expected: false, result: ${validParentheses.isValid("(]")}")
    println("input: ']', expected: false, result: ${validParentheses.isValid("]")}")
}
