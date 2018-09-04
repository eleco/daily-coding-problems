object Q106MinimumNumberOfHops {


    @JvmStatic
    fun main(args: Array<String>) {


        // Given an integer list where each number represents the number of hops you can make, determine whether you can reach to the last index starting at index 0.
        // For example, [2, 0, 1, 0] returns true while [1, 1, 0, 1] returns false.


        println(f(intArrayOf(2, 0, 1, 0)))
        println(f(intArrayOf(1, 1, 0, 1)))
    }

    private fun f(a: IntArray): Boolean {
        var pos = 0
        val target = a.size - 1
        var old = 0

        while (pos < target) {
            pos += a[pos]
            if (pos == old) return false
            old = pos
        }

        return pos == target
    }
}
