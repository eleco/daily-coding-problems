package problem101;

public class Main {

    public static void main(String[] args) {
        //Given an even number (greater than 2), return two prime numbers whose sum will be equal to the given number.
        //  A solution will always exist. See Goldbach’s conjecture.

        int[] r= two_primes(34);
        System.out.println(r[0] + " " + r[1]);

        r= two_primes(55);
        System.out.println(r[0] + " " + r[1]);
    }


    static int [] two_primes(int a) {

        int[]arr = new int[a+1];
        arr[0]=-1;
        arr[1]=-1;
        sieve(arr,a);

        for (int i=0;i<a;i++) {
            if (arr[i]==0 && arr[a-i]==0) {
                return new int[]{i, a-i};
            }
        }
        throw new RuntimeException("algo error");
    }

    static void sieve(int p[], int a) {
        for (int j=2; j<p.length;j++) {
            if (p[j]==0) {
                for (int i=j+j;i<a;i+=j) p[i]=-1;
            }
        }
    }
}
