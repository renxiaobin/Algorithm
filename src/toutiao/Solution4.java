package toutiao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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

        if(a.length>b.length){
            int temp[] = a;
            a=b;
            b=temp;
        }

        System.out.println(magic(a,b));

    }

    public static int magic(int[] a, int[] b) {
        Arrays.sort(a);
        Arrays.sort(b);

        List<Integer> alist = new ArrayList(Arrays.asList(a));
        int n=a.length,m=b.length;
        int sum_a=0,sum_b=0;
        double avg_a=0,avg_b=0;

        for (int i = 0; i < a.length; i++) {
            sum_a+=a[i];
        }
        for (int i = 0; i < b.length; i++) {
            sum_b+=b[i];
        }
        avg_a=(double)sum_a/(double)a.length;
        avg_b=(double)sum_b/(double)b.length;

        int times=0;

        for (int i = 0; i <m-1; i++) {
            if (b[i]>avg_a && b[i]<avg_b && !alist.contains(b[i])) {
                times++;
                avg_a=(double)(avg_a*alist.size()+b[i])/(double)(alist.size()+1);

                avg_b=(double)(avg_b*m-b[i])/(double)(m-1);
                m=m-1;
            }else {
                continue;
            }
        }

        //System.out.println(avg_a);
        //System.out.println(avg_b);

        return times;
    }
}