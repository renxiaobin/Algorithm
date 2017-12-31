package week2;

import java.util.Arrays;

public class InverseCount {
    public static void main(String[] args) {
        int a[] = {2,3,8,5,6,1,20,10,7};
        int result = cal(a,0,a.length-1);
        System.out.println(result);
    }

    private static int cal(int[] a,int start, int end) {
        int count=0;
        if (start<end){
            int mid = (start+end)/2;
            count+=cal(a,start,mid);
            count+=cal(a,mid+1,end);
            count+=calMerge(a,start,mid,end+1);
        }
        return count;
    }

    private static int calMerge(int[] a, int start, int mid, int end) {

        int count = 0;

        int temp1[] = Arrays.copyOfRange(a, start, mid + 1);
        int temp2[] = Arrays.copyOfRange(a, mid + 1, end);
        Arrays.sort(temp1);
        Arrays.sort(temp2);

        int i = temp1.length - 1;
        int j = temp2.length - 1;

        while (i >= 0 && j>=0) {
            if (temp1[i] > temp2[j]) {
                count += (j + 1);
                i--;
                j = temp2.length - 1;
            }else{
                j--;
                if (j<0 && i>0){
                    i--;
                    j = temp2.length - 1;
                }
            }
        }

        return count;
    }
}
