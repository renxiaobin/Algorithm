package interview;

import java.util.ArrayList;
import java.util.List;

public class NumTransformer {
    public static void main(String[] args) {
        int a = 167;
        int n = 16;
        transform(a,n);
    }

    private static void transform(int num, int n) {
        List<Integer> list = new ArrayList<>();
        while (num!=0){
            int remainder = num%n;
            num/=n;
            list.add(remainder);
        }
        for (int i=list.size()-1;i>=0;i--){
            if (list.get(i)>9){
                System.out.print((char)(list.get(i)+55));
            }else{
                System.out.print(list.get(i));
            }

        }
    }
}
