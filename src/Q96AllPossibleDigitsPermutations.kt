import java.util.ArrayList
import java.util.Arrays

object Q96AllPossibleDigitsPermutations {
    @JvmStatic
    fun main(args: Array<String>) {
        //Given a number in the form of a list of digits, return all possible permutations.
        //For example, given [1,2,3], return [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]].

        //Approach
        //recursively swap first and last item of the list, decreasing the index of the last item at each recursion

        val c = intArrayOf(1, 2, 3)
        val permutations = ArrayList<IntArray>()
        permut(c.size, c, permutations)
        permutations.forEach { x -> println(Arrays.toString(x)) }
    }

    internal fun permut(n: Int, c: IntArray, permutations: MutableList<IntArray>) {

        if (n == 1) {
            permutations.add(Arrays.copyOf(c, c.size))
        } else {
            for (i in 0 until n) {
                swap(c, i, n - 1)
                permut(n - 1, c, permutations)
                swap(c, i, n - 1)
            }
        }
    }

    private fun swap(a: IntArray, b: Int, c: Int) {
        val tmp = a[b]
        a[b] = a[c]
        a[c] = tmp
    }
}

