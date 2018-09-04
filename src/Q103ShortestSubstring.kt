import java.util.HashMap
import java.util.function.BiFunction

object Q103ShortestSubstring {

    //Given a string and a set of characters, return the shortest substring containing all the characters in the set.
    //For example, given the string "figehaeci" and the set of characters {a, e, i}, you should return "aeci".

    //Approach
    //1. create and populate a map of characters to occurrences, for the pattern searched for 'histoPattern'
    //
    //2. iterate over the input string and for each character in the string:
    //  - add to another map of characters to occurences 'histoInput'
    //  -until we reach a point where all the characters in the pattern searched have been populated in 'histoInput'
    //  - at which point we remove all expendable characters from the start of the string i.e characters not in pattern, or in pattern but in too high a number


    @JvmStatic
    fun main(args: Array<String>) {
        println(shortestSubstring("figehaeci", "aei"))
    }

    private fun shortestSubstring(input: String, pattern: String): String {

        var minLength = input.length
        var ret = input

        val histoPattern = mutableMapOf<Char, Int>()
        for (i in 0 until pattern.length) {
            histoPattern.merge(pattern[i], 1, { i, i1 -> Integer.sum(i, i1) })
        }

        val histoInput = mutableMapOf<Char, Int>()

        var start = 0
        for (i in 0 until input.length) {

            histoInput.merge(input[i], 1, { i, i1 -> Integer.sum(i, i1) })

            val patternMatch = histoPattern.entries.stream().allMatch { x -> histoInput[x.key] != null && x.value <= histoInput[x.key]!! }

            if (patternMatch) {

                while (histoPattern[input[start]] == null || histoInput[input[start]]!! > histoPattern[input[start]]!!) {

                    val r = input[start]
                    if (histoInput[r] != null && histoPattern[r] != null && histoInput[r]!! > histoPattern[r]!!) {
                        histoInput.merge(r, -1, { i, i1 -> Integer.sum(i, i1) })
                    }
                    start++
                }

                if (i - start + 1 < minLength) {
                    ret = input.substring(start, i + 1)
                    minLength = i - start + 1
                }
            }
        }
        return ret
    }
}
