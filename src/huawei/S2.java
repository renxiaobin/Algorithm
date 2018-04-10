package huawei;

import java.util.Scanner;

public class S2 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int a[] = new int[n];
        for (int i = 0; i < n; i++) {
            a[i]=scanner.nextInt();
        }
        System.out.println(cal(a,a.length-1));
    }

    static int count=0;
    private static int cal(int[] a,int len) {
        if(a.length==0 || len<=0) return 0;
        int i = len-1;
        for (; i >=0; i--) {
            if (a[i]>=len-i){
                continue;
            }else {
                i++;
                break;
            }
        }
        return Math.min(cal(a,i)+1,cal(a,len-1)+1);

    }
}
