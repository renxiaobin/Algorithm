package interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ShuLie {
    public static void main(String[] args) {
        int a[] = {2,3,4,5,6,7,8,9};
        int b[] = {0,2,4,6,8};
        int b1[] = {0,2,4,6};
        int c[] = {0,1,2,3,4};
        int d[] = {2,4,6,8};
        int e[] = {0,3,6,9};
        int f[] = {1,2,3};
        int h[] = {1,2,3,4,5,6};
        cal(c);

        int z[] = {0,1,2,3,4,5,6,7,8,9};//result is [6,2,1,0,0,0,1,0,0,0]
        int z1[] = {9,8,7,6,5,4,3,2,1,0};
        int z2[] = {0,2,4,6,8,10,12,14,16};
        cal(z);
    }

    private static void cal(int[] a) {
        List list = new ArrayList();
        int n = a.length;
        //int temp[] = new int[n];
        int result[] = new int[n];//current status
        for (int i = 0; i < result.length; i++) {
            result[i]=a[0];
        }
        //System.out.println(temp[0]);
        while (true){
            int temp[]=new int[n];


            for (int i = 0; i < n; i++) {

                if (valid(result,a)) {
                    System.out.println(Arrays.toString(result));
                    return;
                }else{
                    if(contains(list,result)){
                        System.out.println("no result!");
                        return;
                    }
                }
                temp = Arrays.copyOfRange(result,0,result.length);

                adjust(a,result,temp,i);
                if (!Arrays.equals(temp,result)){
                    list.add(temp);
                }
            }

        }

    }

    private static boolean contains(List list, int[] result) {
        if (list==null || list.size()==0) return false;
        for(int i=0;i<list.size();i++){
            int temp[] = (int[])list.get(i);
            if (Arrays.equals(temp,result))
                return true;
        }
        return false;
    }

    private static boolean valid(int[] result, int[] a) {
        for (int i = 0; i < result.length; i++) {
            if (result[i]!= countArray(result,a[i]))
                return false;
        }
        return true;
    }

    private static int countArray(int a[], int key){
        int count=0;
        for (int i = 0; i < a.length; i++) {
            if (a[i]==key)
                count++;
        }
        return count;
    }

    private static void adjust(int a[],int result[],int temp[],int index){
        if (result[index]== countArray(temp,a[index]))
            return;
        else
            result[index]= countArray(temp,a[index]);
    }
}
