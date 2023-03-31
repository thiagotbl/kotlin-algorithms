package url_encode_decode

class Codec {
    private val shortIdSize = 6
    private val baseDomain = "http://tinyurl.com"

    private val urls = mutableMapOf<String, String>()

    fun encode(longUrl: String): String {
        val id = randomId()

        urls[id] = longUrl

        return "$baseDomain/$id"
    }

    fun decode(shortUrl: String): String? {
        val id = parseRandomId(shortUrl)

        return urls[id]
    }

    private fun randomId(): String {
        val range = ('a'..'z') + ('A'..'Z') + ('0'..'9')

        return (1..shortIdSize).map { range.random() }.joinToString("")
    }

    private fun parseRandomId(shortUrl: String): String {
        return shortUrl.split("/").last()
    }
}
