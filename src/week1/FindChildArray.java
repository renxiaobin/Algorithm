package week1;

import java.util.LinkedList;

public class FindChildArray {
    public static void main(String[] args) {
        int a[] = {1,3,4,23,36,50,2,8,9};
        int m=3;
        find(a,m);
        findOn(a,m);
    }

    private static void findOn(int[] a, int m) {
        int count=0;
        int left=0,right=0;
        LinkedList<Integer> qmin = new LinkedList();
        LinkedList<Integer> qmax = new LinkedList();
        while (left<a.length) {
            while (right < a.length) {
                while (!qmin.isEmpty() && a[qmin.peekLast()] >= a[right]) {
                    qmin.pollLast();
                }
                qmin.add(right);
                while (!qmax.isEmpty() && a[qmax.peekLast()] <= a[right]) {
                    qmax.pollLast();
                }
                qmax.add(right);
                if (a[qmax.peekFirst()]-a[qmin.peekFirst()]>m){
                    break;
                }
                right++;
            }
            if (left==qmin.peekFirst()){
                qmin.pollFirst();
            }
            if (left==qmax.peekFirst()){
                qmax.pollFirst();
            }
            count+=(right-left);
            left++;
        }

        System.out.println("count: "+count);
    }

    private static void find(int[] a,int m) {
        int count=0;
        for (int i = 0; i < a.length; i++) {
            for (int j = i; j < a.length; j++) {
                if (getMaxMinMinus(a,i,j)<=m){
                    count++;
                }
            }
        }

        System.out.println("The count of child arrays is "+count);
    }

    private static int getMaxMinMinus(int[] a, int i, int j) {
        int max=a[i],min=a[i];
        for (int k = i+1; k <=j ; k++) {
            if (a[k]>max){
                max=a[k];
            }
            if (a[k]<min){
                min=a[k];
            }
        }
        return max-min;
    }
}
