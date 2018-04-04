package wangyi;

import java.util.Scanner;

public class S4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int k=scanner.nextInt();
        int j=scanner.nextInt();

        int a[][] = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int z = 0; z < m; z++) {
                a[i][z]=scanner.nextInt();
            }
        }

        System.out.println(cal(a,n,m,k,j));
    }

    public static int cal(int[][] a,int n,int m, int k, int j) {
        if (a[k][j]==0) return 0;
        int sum=0;
        if(isLive(a,n,m,k,j)){
            for (int i = k+1; i <n ; i++) {
                if(a[i][j]==1){
                    a[k][j]=0;
                    if (!isLive(a,n,m,i,j))
                        sum++;
                }else {
                    break;
                }
            }

        }else {
            return 0;
        }

        return sum;
    }

    public static boolean isLive(int[][] a,int n,int m, int k, int j) {
        return false;
    }
}
