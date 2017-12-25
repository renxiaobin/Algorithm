package week1;

public class MaxMatrix {
    public static void main(String[] args) {
        int a[][] = {
                {0,1,1,0,1},
                {0,1,1,0,1},
                {0,1,1,1,1},
                {0,1,1,1,0}
        };
        findMaxMatrix(a);
    }

    private static void findMaxMatrix(int[][] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j <a[0].length ; j++) {
                if (a[i][j]==1){
                    a[i][j] = a[i][j-1]+1;
                }
            }
        }

        int area = 0,maxArea = 0,k;
        for (int i = 0; i <a.length ; i++) {
            for (int j = 0; j <a[0].length ; j++) {
                if (a[i][j]==0)
                    continue;
                for (k=i-1,area=a[i][j];k>=0 && a[k][j]>=a[i][j];k--){
                    area+=a[i][j];
                }
                for (k = i+1; k <a.length&& a[k][j]>=a[i][j]; k++) {
                    area+=a[i][j];
                }
                if (area>maxArea)
                    maxArea = area;
            }
        }

        System.out.println("The element count of max matrix is "+maxArea);
    }
}
