package problem96;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        //Given a number in the form of a list of digits, return all possible permutations.
        //For example, given [1,2,3], return [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]].

        //Approach
        //recursively swap first and last item of the list, decreasing the index of the last item at each recursion

        int [] c = new int[] {1,2,3};
        List<int []> permutations = new ArrayList<>();
        permut(c.length,c, permutations);
        permutations.forEach(x->System.out.println(Arrays.toString(x)));
    }

    static void permut( int n, int[]c,  List<int []> permutations ) {

        if (n==1) {
            permutations.add(Arrays.copyOf(c, c.length));
        } else {
            for (int i = 0; i < n; i++) {
                swap(c, i, n - 1);
                permut(n - 1, c, permutations);
                swap(c, i, n - 1);
            }
        }
    }

    private static void swap(int []a, int b, int c){
        int tmp = a[b];
        a[b]=a[c];
        a[c]=tmp;
    }
}

