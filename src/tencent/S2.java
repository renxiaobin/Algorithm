package tencent;


import java.util.Scanner;

public class S2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long k = scanner.nextLong();
        long num[] = new long[4];
        for (int i = 0; i < 4; i++) {
            num[i] = scanner.nextLong();
        }
        System.out.println(cal(k, num));
    }


    private static long cal(long n, long[] num) {
        long result = 0;
        long count1 = n/num[0];
        count1 = count1<num[1]?count1:num[1];

        for (long i = 0; i < count1; i++) {
            long sum2 = n-i*num[0];
            if(sum2%num[2]==0){
                result+=combine(i,num[1]);
                result+=combine(sum2/num[2],num[3]);
            }

        }

        return result % 1000000007;
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
