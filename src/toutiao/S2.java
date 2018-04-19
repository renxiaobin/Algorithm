package toutiao;

import java.util.Scanner;

public class S2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n1 = scanner.nextInt();
        int n2 = scanner.nextInt();
        int m = scanner.nextInt();

        int a[] = new int[n1];
        int b[] = new int[n2];

        for (int i = 0; i < n1; i++) {
            a[i]=scanner.nextInt();
        }
        for (int i = 0; i < n2; i++) {
            b[i]=scanner.nextInt();
        }

        System.out.println(cal(a,b,m));
    }

    private static long cal(int[] a, int[] b, int m) {
        long result = 0;

        return result%1000000007;
    }

    static long combine(long n, long m) {
        long result = 1;

        if(n==0)
            return result;

        for (long i = 1; i <= m; i++) {
            result = result * n / i;
            n--;
        }

        return result;
    }
}
