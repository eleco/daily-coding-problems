
/*
Given a collection of intervals, find the minimum number of intervals you need to remove to make the rest of the intervals non-overlapping.

Intervals can "touch", such as [0, 1] and [1, 2], but they won't be considered overlapping.

For example, given the intervals (7, 9), (2, 4), (5, 8), return 1 as the last interval can be removed and the first two won't overlap.

The intervals are not necessarily sorted in any order.
*/


/*

Approach : iterate on the intervals sorted by end(right) position, increment number of overlaps when start of current position is less than the latest previous end position.

 */

object Q191FindMinimumNumberOfIntervals  {

    @JvmStatic
    fun main(args: Array<String>) {
        val a: Array<IntArray> = arrayOf(intArrayOf(7,9),intArrayOf(2, 4),intArrayOf(5, 8))
        check(minInterval(a)==1)

        val b: Array<IntArray> = arrayOf(intArrayOf(7,9),intArrayOf(2, 4),intArrayOf(2, 4),intArrayOf(5, 8))
        check(minInterval(b)==2)

        val c: Array<IntArray> = arrayOf(intArrayOf(2,9),intArrayOf(2, 4),intArrayOf(5, 6),intArrayOf(2, 8))
        check(minInterval(c)==2)

        val d: Array<IntArray> = arrayOf(intArrayOf(7,9),intArrayOf(2, 4),intArrayOf(1, 4),intArrayOf(2, 3))
        check(minInterval(d)==2)

    }


    fun minInterval(a: Array<IntArray>) :Int {


        var sortedListOfIntervals = a.sortedWith(compareBy({ it[1]}))

        var overlap = 0;
        var latestRightEdge=0;

        for (interval in sortedListOfIntervals) {
            if (latestRightEdge!=0) {
                if (interval[0]<latestRightEdge) overlap++;
            }
            latestRightEdge = interval[1]

        }
        return overlap;
    }



}