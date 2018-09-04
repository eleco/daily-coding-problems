import java.util.ArrayList
import java.util.Collections

object Q102ContinuousElementsSum {

    @JvmStatic
    fun main(args: Array<String>) {
        // Given a list of integers and a number K, return which contiguous elements of the list sum to K.
        // For example, if the list is [1, 2, 3, 4, 5] and K is 9, then it should return [2, 3, 4].

        //Approach
        //- brute force; for each element of the array, add to all other elements until sum is K
        //- optimized: add each element of the array to the sum, is sum exceeds K then remove the earliest added element from the sum

        println(window_brute(intArrayOf(1, 2, 3, 4, 5), 9))
        println(window_optimized(intArrayOf(1, 2, 3, 4, 5), 9))
    }

    internal fun window_optimized(arr: IntArray, k: Int): List<Int> {

        val ret = ArrayList<Int>()
        var sum = 0
        var trailerIdx = 0
        for (anArr in arr) {
            sum += anArr
            ret.add(anArr)
            if (sum > k) {
                sum -= arr[trailerIdx++]
                ret.removeAt(0)
            }
            if (sum == k) {
                return ret
            }
        }
        return emptyList()
    }


    internal fun window_brute(arr: IntArray, k: Int): List<Int> {

        val ret = ArrayList<Int>()
        var sum = 0
        for (i in arr.indices) {
            sum += arr[i]
            ret.add(arr[i])
            if (sum == k) return ret

            for (j in i + 1 until arr.size) {
                sum += arr[j]
                ret.add(arr[j])
                if (sum == k) return ret
            }
            sum = 0
            ret.clear()
        }
        return ret
    }
}
