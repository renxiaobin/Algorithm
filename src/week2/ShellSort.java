package week2;

import java.util.Arrays;

public class ShellSort {
    public static void main(String[] args) {
        int a[] = {11, 8, 10, 36, 98, 100, 1, 3, 2};
        sort(a);
        System.out.println(Arrays.toString(a));
    }

    public static void sort(int a[]) {
        int d = a.length / 2;
        while (d != 0) {
            for (int i = d + 1; i <= a.length; i += d) {
                int temp = a[i - 1];
                int j = i;

                while (j > d && temp < a[j - d - 1]) {
                    a[j - 1] = a[j - d - 1];
                    j = j - d;
                }
                a[j-1] = temp;

            }
            d /= 2;
        }
    }
}
