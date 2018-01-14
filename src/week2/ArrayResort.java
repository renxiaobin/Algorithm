package week2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayResort {
    public static void main(String[] args) {
        int a[]={1,-3,6,9,15,-18,2};
        resort(a);
    }

    private static void resort(int[] a) {
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < a.length; i++) {
            if (a[i]<0){
                list.add(a[i]);
                a[i]=0;
            }
        }

        for (int i = 0; i < a.length; i++) {
            if (a[i]>0){
                list.add(a[i]);
                a[i]=0;
            }
        }
        for (int i = 0; i < list.size(); i++) {
            a[i]=list.get(i);
        }

        System.out.println(Arrays.toString(a));
    }
}
