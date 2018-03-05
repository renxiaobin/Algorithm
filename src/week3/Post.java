package week3;

public class Post {
    public static void main(String[] args) {
        int villige[] = {1,3,5,7,8};
        int n = villige.length;
        int postNum = 1;
        int dis[][] = new int[n][n];
        int dp[][] = new int[n][postNum];

        for (int i = 0; i <=n-2 ; i++) {
            for (int j = i+1; j <= n-1; j++) {
                dis[i][j]=dis[i][j-1]+villige[j]-villige[(i+j)/2];
            }
        }
        for (int i = 0; i <=n-1 ; i++) {
            dp[i][0] = dis[0][i];
        }
        for (int i = 1; i < postNum; i++) {
            for (int j = i; j <=n-1 ; j++) {
                for (int k = i-1; k <=j-1 ; k++) {
                    dp[j][i]=Math.min(dp[j][i],dp[k][i-1]+dis[k+1][j]);
                }
            }
        }
        System.out.println(dp[n-1][postNum-1]);
    }
}
