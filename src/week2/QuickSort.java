package week2;

import java.util.Arrays;
import java.util.Stack;

public class QuickSort {
    public static void main(String[] args) {
        int a[]={1,3,2,6,5,10,9};
        sort(a,0,a.length-1);
        System.out.println( Arrays.toString(a));
        sort(a);
        System.out.println( Arrays.toString(a));
    }

    public static void sort(int a[],int start,int end){
        if (a.length<=1) return;
        if (start<end) {
            int kIndex = part(a,start,end);
            sort(a, start, kIndex - 1);
            sort(a, kIndex + 1, end);
        }
    }

    private static int part(int a[],int start,int end){
        int kIndex = end;
        if (start<end){
            int k = a[kIndex];
            for (int i = start; i < kIndex;) {
                if (a[i] > k && kIndex > i) {
                    int j1=i;
                    int j2=kIndex;
                    int temp = a[i];
                    while (j1!=j2){
                        a[j1]=a[++j1];
                    }
                    a[j2]=temp;
                    kIndex--;
                } else{
                    i++;
                }
            }
        }
        return kIndex;
    }

    public static void sort(int a[]){
        if (a.length<=1) return;
        Stack<Integer> stack = new Stack<Integer>();
        int start = 0;
        int end = a.length-1;
        if (start<end){
            int kIndex = part(a,start,end);
            if (start<kIndex-1){
                stack.push(start);
                stack.push(kIndex-1);
            }
            if (end>kIndex+1){
                stack.push(kIndex+1);
                stack.push(end);
            }

            while (!stack.isEmpty()){
                end = stack.pop();
                start = stack.pop();
                kIndex=part(a,start,end);
                if (start<kIndex-1){
                    stack.push(start);
                    stack.push(kIndex-1);
                }
                if (end>kIndex+1){
                    stack.push(kIndex+1);
                    stack.push(end);
                }
            }
        }
    }
}
