package toutiao;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class S1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int n = scanner.nextInt();
            List<Integer> a = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                a.add(scanner.nextInt());
            }
            list.add(a);
        }

        for (List<Integer> arr:list){
            System.out.println(cal(arr));
        }

    }

    private static int cal(List<Integer> arr) {
        int T=1;
        int len = arr.size()-1;

        int i=1;
        while (i < len) {
            int temp = arr.get(i);
            if (temp-T>=arr.get(0) && temp+T<=arr.get(len)){
                if (arr.contains(temp-T) && arr.contains(temp+T)){
                    if (i==len-1){
                        return T;
                    }else {
                        i++;
                        continue;
                    }
                }else{
                    T++;
                    i=1;
                }
            }else if(temp-T<arr.get(0) && temp+T>arr.get(len)){
                if (!arr.contains(temp-T) && !arr.contains(temp+T)){
                    if (i==len-1){
                        return T;
                    }else {
                        i++;
                        continue;
                    }
                }else{
                    T++;
                    i=1;
                }
            }else{
                T++;
                i=1;
            }

        }
        return T;
    }
}
