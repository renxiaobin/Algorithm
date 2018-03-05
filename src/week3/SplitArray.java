package week3;

public class SplitArray {
    public static void main(String[] args) {
        int a[]={1,2,3,4,5,6,7};
        int b[]={1,5,3};
        System.out.println(split(a));
        System.out.println(split(b));

        System.out.println(findPartition(b,b.length));
    }

    private static boolean split(int[] array) {

        int sum = sum(array);
        //int max = max(array);
        if (sum%2!=0) return false;
        //if (max>sum/2) return false;
        return isSubsetSum(array,array.length,sum/2);
    }

    private static boolean isSubsetSum(int[] array, int n, int halfSum) {
        if (halfSum==0)return true;
        if (n==0 && halfSum !=0) return false;
        if (array[n-1]>halfSum) return false;
        return isSubsetSum(array,n-1,halfSum) || isSubsetSum(array,n-1,halfSum-array[n-1]);
    }


    private static int sum(int[] array) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum+=array[i];
        }
        return sum;
    }

    private static int max(int[] array){
        int max=array[0];
        for (int i = 1; i < array.length; i++) {
            if (max<array[i]){
                max=array[i];
            }
        }
        return max;
    }

    /**
     * 动态规划解法
     * 时间复杂度为O(sum*n)
     * 辅助空间O(sum*n)
     * @param arr
     * @param n
     * @return
     */
    static boolean findPartition (int arr[], int n)
    {
        int sum = 0;
        int i, j;

        // Caculcate sun of all elements
        sum = sum(arr);

        if (sum%2 != 0)
            return false;

        boolean part[][]=new boolean[sum/2+1][n+1];

        // initialize top row as true
        for (i = 0; i <= n; i++)
            part[0][i] = true;

        // initialize leftmost column, except part[0][0], as 0
        for (i = 1; i <= sum/2; i++)
            part[i][0] = false;

        // Fill the partition table in botton up manner
        for (i = 1; i <= sum/2; i++)
        {
            for (j = 1; j <= n; j++)
            {
                part[i][j] = part[i][j-1];
                if (i >= arr[j-1])
                    part[i][j] = part[i][j] ||
                            part[i - arr[j-1]][j-1];
            }
        }

        /* // uncomment this part to print table
        for (i = 0; i <= sum/2; i++)
        {
            for (j = 0; j <= n; j++)
                printf ("%4d", part[i][j]);
            printf("\n");
        } */

        return part[sum/2][n];
    }
}
