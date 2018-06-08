package problem106;

public class Main {


    public static void main(String args[]) {


        // Given an integer list where each number represents the number of hops you can make, determine whether you can reach to the last index starting at index 0.
        // For example, [2, 0, 1, 0] returns true while [1, 1, 0, 1] returns false.


        System.out.println(f(new int[]{2,0,1,0}));
        System.out.println(f(new int[]{1,1,0,1}));
    }

    private static boolean f(int [] a) {
        int pos=0;
        int target=a.length-1;
        int old = 0;

        while (pos<target) {
            pos+=a[pos];
            if (pos==old) return false;
            old = pos;
        }

        return (pos==target);
    }
}
