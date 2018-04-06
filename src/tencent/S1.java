package tencent;

import java.util.Scanner;

public class S1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long m = scanner.nextLong();
        System.out.println(cal(n, m));
    }

    private static long cal(long n, long m) {
        if (n % (2 * m) != 0) return 0;
        long num = n / (m * 2);
        long result = m * m * num;
        return result;
    }
}
