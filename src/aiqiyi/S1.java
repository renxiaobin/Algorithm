package aiqiyi;

import java.util.*;

public class S1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int a[] = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        long start = System.currentTimeMillis();
        System.out.println(cal(a));
        long end = System.currentTimeMillis();
        System.out.println(end-start);

        long start1 = System.currentTimeMillis();
        System.out.println(cal2(a));
        long end1 = System.currentTimeMillis();
        System.out.println(end1-start1);
    }

    private static int cal(int[] a) {
        int temp=a[0];
        int i;
        for (i = 1; i < a.length; i++) {
            if((temp^a[i])!=0){
                break;
            }
        }
        if(i==1 && a[2]==temp){
            return 2;
        }else if(i==1 && a[1]==a[2]){
            return 1;
        }
        return i+1;
    }

    private static int cal2(int[] a) {
        int temp=a[0];
        int i;
        for (i = 1; i < a.length; i++) {
            if(temp==a[i]){
                continue;
            }else {
                break;
            }
        }
        if(i==1 && a[2]==temp){
            return 2;
        }else if(i==1 && a[1]==a[2]){
            return 1;
        }
        return i+1;
    }


}
