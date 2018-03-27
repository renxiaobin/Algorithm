package toutiao;

import java.util.Arrays;
import java.util.Scanner;

public class Solution4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n=scanner.nextInt();
        int m=scanner.nextInt();
        int a[] = new int[n];
        int b[] = new int[m];
        for (int i = 0; i < n; i++) {
            a[i]=scanner.nextInt();
        }
        for (int i = 0; i < m; i++) {
            b[i]=scanner.nextInt();
        }

        System.out.println(magic(a,b));
    }

    public static int magic(int[] a, int[] b) {
        Arrays.sort(a);
        Arrays.sort(b);
        int sum_a=0,sum_b=0;
        double avg_a=0,avg_b=0;
        for (int i = 0; i < a.length; i++) {
            sum_a+=a[i];
        }
        for (int i = 0; i < b.length; i++) {
            sum_b+=b[i];
        }
        avg_a=sum_a/a.length;
        avg_b=sum_b/b.length;

        int times=0;
        if (avg_a<avg_b){

        }
        return 0;
    }
}
