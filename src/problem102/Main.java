package problem102;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // Given a list of integers and a number K, return which contiguous elements of the list sum to K.
        // For example, if the list is [1, 2, 3, 4, 5] and K is 9, then it should return [2, 3, 4].

        //Approach
        //- brute force; for each element of the array, add to all other elements until sum is K
        //- optimized: add each element of the array to the sum, is sum exceeds K then remove the earliest added element from the sum

        System.out.println(window_brute(new int[]{1, 2, 3, 4, 5}, 9));
        System.out.println(window_optimized(new int[]{1, 2, 3, 4, 5}, 9));
    }

    static List<Integer> window_optimized(int[] arr, int k) {

        List<Integer> ret = new ArrayList<Integer>();
        int sum = 0;
        int trailerIdx = 0;
        for (int anArr : arr) {
            sum += anArr;
            ret.add(anArr);
            if (sum > k) {
                sum -= arr[trailerIdx++];
                ret.remove(0);
            }
            if (sum == k) {
                return ret;
            }
        }
        return Collections.emptyList();
    }


    static List<Integer> window_brute(int[] arr, int k) {

        List<Integer> ret = new ArrayList<Integer>();
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            ret.add(arr[i]);
            if (sum == k) return ret;

            for (int j = i + 1; j < arr.length; j++) {
                sum += arr[j];
                ret.add(arr[j]);
                if (sum == k) return ret;
            }
            sum = 0;
            ret.clear();
        }
        return ret;
    }
}
