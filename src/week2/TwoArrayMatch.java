package week2;

import java.util.Arrays;

public class TwoArrayMatch {
    public static void main(String[] args) {
        int a[] = {11, 8, 10, 36, 98, 100, 1, 3, 2};
        int b[] = {8, 10, 1, 11, 3, 2, 36, 98, 100};

        QuickSort.sort(a);
        QuickSort.sort(b,0,b.length-1);
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(b));
    }

}
