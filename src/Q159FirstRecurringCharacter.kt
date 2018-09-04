//Given a string, return the first recurring character in it, or null if there is no recurring character.
//For example, given the string "acbbac", return "b". Given the string "abcdef", return null.

object Q159FirstRecurringCharacter {
    @JvmStatic
    fun main(args: Array<String>) {
        println(findfirst("acbbac"))
        println(findfirst("abcdef"))
    }

    fun findfirst(s: String): Char? {

        var last: Char = '\u0000'
        for (c in s) {
            if (c == last) return c;
            last = c
        }
        return null
    }

}