package wangyi;

import java.util.Scanner;

public class Solution1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int x1[] = new int[n];
        int y1[] = new int[n];
        int x2[] = new int[n];
        int y2[] = new int[n];
        for (int i = 0; i < n; i++) {
            x1[i]=scanner.nextInt();
        }
        for (int i = 0; i < n; i++) {
            y1[i]=scanner.nextInt();
        }
        for (int i = 0; i < n; i++) {
            x2[i]=scanner.nextInt();
        }
        for (int i = 0; i < n; i++) {
            y2[i]=scanner.nextInt();
        }

        int result=1;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                if (x2[i]>x1[j] && y2[i]>y1[j] && x1[i]<x2[j] && y1[i]<y2[j])
                    result++;
            }
        }
        System.out.println(result);
    }
}
