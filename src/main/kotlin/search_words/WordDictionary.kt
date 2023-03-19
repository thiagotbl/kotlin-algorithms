package search_words

class WordDictionary {
    private val root = TrieNode()

    fun addWord(word: String) {
        var node = root

        for (char in word) {
            node = node.children.getOrPut(char) { TrieNode() }
        }

        node.isWord = true

        println(root)
    }

    fun search(word: String): Boolean {
        return search(word, 0, root)
    }

    private fun search(word: String, index: Int, node: TrieNode?): Boolean {
        if (node == null) return false
        if (index == word.length) return node.isWord

        val char = word[index]

        return if (char == '.') {
            node.children.values.any { search(word, index + 1, it) }
        } else {
            search(word, index + 1, node.children[char])
        }
    }

    private data class TrieNode(
        val children: MutableMap<Char, TrieNode> = mutableMapOf(),
        var isWord: Boolean = false
    )
}
