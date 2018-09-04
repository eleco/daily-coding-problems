import java.util.HashSet

object Q99LongestConsecutiveSequence {


    @JvmStatic
    fun main(args: Array<String>) {
        // Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
        // For example, given [100, 4, 200, 1, 3, 2], the longest consecutive element sequence is [1, 2, 3, 4]. Return its length: 4.
        // Your algorithm should run in O(n) complexity.


        //Approach
        //- transform array of int into a set
        //- iterate on the set, when at the start of a sequence:
        //          - keep looking for successive numbers in that sequence, updating count and max count in the process.

        println(longest_consecutive_seq(intArrayOf(100, 4, 200, 1, 3, 2)))
    }


    internal fun longest_consecutive_seq(a: IntArray): Int {

        val s = HashSet<Int>()
        for (i in a.indices) s.add(a[i])

        var max = 0
        for (i in s) {
            var count = 1
            if (!s.contains(i - 1)) {
                var j = i + 1
                while (true) {
                    if (s.contains(j)) {
                        count++
                        j++
                        if (count > max) max = count
                    } else
                        break

                }
            }

        }
        return max
    }
}
