package jzoffer;
import java.util.*;
public class S1 {
    public static void reOrderArray(int [] array) {
        int start = 0;
        int end = array.length-1;

        List<Integer> list1 = new ArrayList();
        List<Integer> list2 = new ArrayList();
        for(int i=0;i<array.length;i++){
            if(array[i]%2==0)
                list2.add(array[i]);
            else
                list1.add(array[i]);
        }
        list1.addAll(list2);
        System.out.println(list1.toArray());
    }

    public static void main(String[] args) {
        int a[] = {1,2,3,4,5,6,7};
        reOrderArray(a);
    }
}