package toutiao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * 定义magic操作，使得从一个数组移动一个元素到另一个数组后，两个数组的均值都增加
 * 不能移动数组已包含的元素
 */
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
        avg_a=(double)sum_a/(double)a.length;
        avg_b=(double)sum_b/(double)b.length;
        //从均值大的数组移动到均值小的
        if(avg_a>avg_b){
            int temp[] = a;
            a=b;
            b=temp;
        }

        System.out.println(magic(a,b,avg_a,avg_b));

    }

    /**
     * 只移动数组b中比均值小的，且比a的均值大的元素到数组a中
     * 每移动一次，求一次新的均值
     * @param a
     * @param b
     * @return
     */
    public static int magic(int[] a, int[] b,double avg_a,double avg_b) {

        List<Integer> alist = new ArrayList(Arrays.asList(a));
        int n=a.length,m=b.length;

        int times=0;

        for (int i = 0; i <m-1; i++) {
            if (b[i]>avg_a && b[i]<avg_b && !alist.contains(b[i])) {
                times++;
                avg_a=(double)(avg_a*alist.size()+b[i])/(double)(alist.size()+1);
                alist.add(b[i]);
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
