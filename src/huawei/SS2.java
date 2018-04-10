package huawei;

import java.util.Scanner;

import static java.lang.Math.min;

public class SS2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int a[] = new int[n];
        int dp[] = new int[n];
        for (int i = 0; i < n; i++) {
            a[i]=scanner.nextInt();
            dp[i]=Integer.MAX_VALUE;
        }
        int j=0;
        dp[0]=0;
        for(int i = 0; i < n; ++i){
            for(j = 1; j <= a[i] && i + j < n; ++j){
                dp[i + j] = min(dp[i + j], dp[i] + 1);
            }
        }
        System.out.println(dp[n-1]);
    }
}
