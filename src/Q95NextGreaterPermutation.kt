import java.util.Arrays

object Q95NextGreaterPermutation {
    @JvmStatic
    fun main(args: Array<String>) {
        /*
        Given a number represented by a list of digits, find the next greater permutation of a number, in terms of lexicographic ordering.
        If there is not greater permutation possible, return the permutation with the lowest value/ordering.

        For example,
        the list [1,2,3] should return [1,3,2].
        The list [1,3,2] should return [2,1,3].
        The list [3,2,1] should return [1,2,3].

        Can you perform the operation without allocating extra memory (disregarding the input memory)?

         Approach:
         https://en.wikipedia.org/wiki/Permutation#Generation_in_lexicographic_order
        */

        var a = intArrayOf(1, 2, 3)
        lexicographic_permutation(a)
        println(Arrays.toString(a))

        a = intArrayOf(1, 3, 2)
        lexicographic_permutation(a)
        println(Arrays.toString(a))

        a = intArrayOf(3, 2, 1)
        lexicographic_permutation(a)
        println(Arrays.toString(a))
    }


    private fun lexicographic_permutation(a: IntArray) {

        //Find the largest index k such that a[k] < a[k + 1].
        var k = -1
        for (i in 0 until a.size - 1) {
            if (a[i] < a[i + 1]) k = i
        }

        //If no such index exists, the permutation is the last permutation.
        if (k == -1) {
            //If there is not greater permutation possible, return the permutation with the lowest value/ordering.
            Arrays.sort(a)
            return
        }

        //Find the largest index l greater than k such that a[k] < a[l].
        var l = -1
        for (i in a.indices) {
            if (a[k] < a[i]) l = i
        }

        //Swap the value of a[k] with that of a[l].
        val tmp = a[l]
        a[l] = a[k]
        a[k] = tmp


        //Reverse the sequence from a[k + 1] up to and including the final element a[n].
        for (i in k + 1 until a.size / 2) {
            val temp = a[i]
            a[i] = a[a.size - i - 1]
            a[a.size - i - 1] = temp
        }
    }


}
