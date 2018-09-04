object Q101PrimeNumberEqualityTest {

    @JvmStatic
    fun main(args: Array<String>) {
        //Given an even number (greater than 2), return two prime numbers whose sum will be equal to the given number.
        //  A solution will always exist. See Goldbach’s conjecture.

        //Approach
        //calculate all primes between 0 and the given number,
        //then iterate on all 2 numbers which sum is the given number, stopping when these 2 numbers are both prime

        var r = two_primes(34)
        println(r[0].toString() + " " + r[1])

        r = two_primes(55)
        println(r[0].toString() + " " + r[1])
    }


    internal fun two_primes(a: Int): IntArray {

        val arr = IntArray(a + 1)
        arr[0] = -1
        arr[1] = -1
        sieve(arr, a)

        for (i in 0 until a) {
            if (arr[i] == 0 && arr[a - i] == 0) {
                return intArrayOf(i, a - i)
            }
        }
        throw RuntimeException("algo error")
    }

    internal fun sieve(p: IntArray, a: Int) {
        for (j in 2 until p.size) {
            if (p[j] == 0) {
                var i = j + j
                while (i < a) {
                    p[i] = -1
                    i += j
                }
            }
        }
    }
}
