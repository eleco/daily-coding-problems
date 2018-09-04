object Q100InfiniteGridSteps {

    @JvmStatic
    fun main(args: Array<String>) {
        /*You are in an infinite 2D grid where you can move in any of the 8 directions:

        (x,y) to
        (x+1, y),
        (x - 1, y),
        (x, y+1),
        (x, y-1),
        (x-1, y-1),
        (x+1,y+1),
        (x-1,y+1),
        (x+1,y-1)
        You are given a sequence of points and the order in which you need to cover the points. Give the minimum number of steps in which you can achieve it. You start from the first point.

        Example:

        Input: [(0, 0), (1, 1), (1, 2)]
        Output: 2
        It takes 1 step to move from (0, 0) to (1, 1). It takes one more step to move from (1, 1) to (1, 2).
        */

        //Approach
        //iterate over the sequence of points. for each point calculate the distance from the prevous and add to number of steps.

        println(steps(arrayOf(intArrayOf(0, 0), intArrayOf(1, 1), intArrayOf(1, 2))))

    }


    private fun steps(a: Array<IntArray>): Int {

        var ox = 0
        var oy = 0
        var steps = 0

        for (anA in a) {

            val px = anA[0]
            val py = anA[1]

            val dy = Math.abs(py - oy)
            val dx = Math.abs(px - ox)
            steps += Math.max(dy, dx)

            ox = px
            oy = py
        }

        return steps
    }


}
