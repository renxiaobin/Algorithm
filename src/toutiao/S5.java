package toutiao;

import java.util.Scanner;

public class S5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        long a[] = new long[n];
        long b[] = new long[n];
        long c[] = new long[n];

        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextLong();
            b[i] = scanner.nextLong();
            c[i] = scanner.nextLong();
        }

        for (int i = 0; i < n; i++) {
            System.out.println(cal(a[i],b[i],c[i]));
        }
    }

    private static int cal(long a, long b, long c) {
        int result=0;
        if (c>a && c>b) return 0;

        return result;
    }
}
