package week2;

import java.util.HashMap;

public class DistributionSort {
    public static void main(String[] args) {
        char a[]={'b','c','d','c','b','a','a','c'};
        psort(a);
    }

    private static void psort(char[] a) {
        HashMap<Character,Integer> hashMap = new HashMap<>();
        hashMap.put('a',0);
        hashMap.put('b',0);
        hashMap.put('c',0);
        hashMap.put('d',0);

        for (int i = 0; i < a.length; i++) {
            if(hashMap.containsKey(a[i])){
                hashMap.put(a[i],hashMap.get(a[i])+1);
            }
        }

        char key ='a';
        int count=0;
        while(hashMap.get(key)!=null && (count=hashMap.get(key))!=0){
            for (int i=0;i<count;i++){
                System.out.print(key+" ");
            }
            key=++key;
        }
    }
}
