package tencent;


import java.util.Scanner;

public class SS2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int K = scanner.nextInt();
        int A = scanner.nextInt();
        int X = scanner.nextInt();
        int B = scanner.nextInt();
        int Y = scanner.nextInt();

        long result = 0;

        for (int i = 0; i <= X; i++) {
            if (i * A > K) {
                break;
            } else {
                int sum2 = K - i * A;
                int count2 = sum2 / B;
                if (sum2 % B == 0 && count2 <= Y) {
                    result += c(X, i) * c(Y, count2);
                }

            }
        }

        System.out.println(result % 1000000007);
    }

    private static long c(int n, int m) {
        long result = 1;

        if (n == 0)
            return result;
        if (m == 1)
            return n;

        for (int i = 1; i <= m; i++) {
            result = result * n / i;
            n--;
        }

        return result;
    }
}