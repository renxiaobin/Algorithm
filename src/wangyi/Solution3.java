package wangyi;

import java.util.Scanner;

public class Solution3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();//works
        int m = scanner.nextInt();//friends
        int di[] = new int[n];//work difficulty
        int pi[] = new int[n];//pay
        int ai[] = new int[m];//ability

        for (int i = 0; i < n; i++) {
            di[i]=scanner.nextInt();
            pi[i]=scanner.nextInt();
        }
        for (int i = 0; i < m; i++) {
            ai[i]=scanner.nextInt();
        }

        for (int i = 0; i < m; i++) {

            int index=n/2;
            while (index!=0){
                if (ai[i]>=di[index]){
                    if (ai[i]<=di[index+1]){
                        break;
                    }else {
                        index=index+index/2+1;
                    }
                }else {
                    index=index-index/2-1;
                }
            }
            if(ai[i]>=di[n-1]){
                index=n-1;
            }
            System.out.println(pi[index]);

        }
    }
}
