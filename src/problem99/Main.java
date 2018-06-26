package problem99;

import java.util.*;

public class Main {


    public static void main(String[] args) {
        // Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
        // For example, given [100, 4, 200, 1, 3, 2], the longest consecutive element sequence is [1, 2, 3, 4]. Return its length: 4.
        // Your algorithm should run in O(n) complexity.


        //Approach
        //- transform array of int into a set
        //- iterate on the set, when at the start of a sequence:
        //          - keep looking for successive numbers in that sequence, updating count and max count in the process.

        System.out.println(longest_consecutive_seq(new int[]{100, 4, 200, 1, 3, 2}));
    }


    static int longest_consecutive_seq(int[] a) {

        Set<Integer> s = new HashSet<Integer>();
        for (int i = 0; i < a.length; i++) s.add(a[i]);

        int max = 0;
        for (Integer i : s) {
            int count = 1;
            if (!s.contains(i - 1)) {
                int j = i + 1;
                while (true) {
                    if (s.contains(j)) {
                        count++;
                        j++;
                        if (count > max) max = count;
                    } else break;

                }
            }

        }
        return max;
    }
}
