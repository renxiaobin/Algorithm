package week2;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int a[] = {2,1, 3, 9, 7, 5, 6, 10,100};
        mergeSort(a);
        System.out.println(Arrays.toString(a));

        dgSort(a,0,a.length-1);
        System.out.println(Arrays.toString(a));
    }

    private static void dgSort(int[] a,int start,int end) {
        if (start<end){
            int mid = (start+end)/2;
            dgSort(a,start,mid);
            dgSort(a,mid+1,end);
            merge(a,start,mid,end);
        }
    }

    public static void mergeSort(int a[]) {
        int len = 1;
        while (len <= a.length) {
            for (int i = 0; len + i <= a.length; i += len * 2) {
                int start = i, mid = i + len - 1, end = i + 2 * len - 1;
                if (end > a.length - 1) {
                    end = a.length - 1;
                }
                merge(a, start, mid, end);
            }
            len *= 2;
        }
    }

    private static void merge(int[] a, int start, int mid, int end) {
        int leftIndex = start;
        int rightIndex = mid + 1;
        int tempArray[] = new int[a.length];
        int tempIndex = start;

        while (leftIndex <= mid && rightIndex <= end) {
            if (a[leftIndex] <= a[rightIndex]) {
                tempArray[tempIndex++] = a[leftIndex++];
            } else {
                tempArray[tempIndex++] = a[rightIndex++];
            }
        }
        while (leftIndex <= mid) {
            tempArray[tempIndex++] = a[leftIndex++];
        }
        while (rightIndex <= end) {
            tempArray[tempIndex++] = a[rightIndex++];
        }
        while (start <= end) {
            a[start] = tempArray[start++];
        }
    }
}
