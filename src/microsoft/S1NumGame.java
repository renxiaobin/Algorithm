package microsoft;

import java.util.ArrayList;
import java.util.List;

/**
 * 多人围圈报数问题
 * n个人编号0 - n-1，报号1-m，每逢报到m的出局，求最后一人的编号
 *
 */
public class S1NumGame {
    public static void main(String[] args) {
        int n=5;
        int m=2;
        System.out.println(cal(5,2));
    }

    private static int cal(int n, int m) {
        int result = 0;
        for (int i = 2; i <=n; i++) {
            result=(result+m)%i;
        }
        return result+1;
    }

    public static int cal2(int n,int m){
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        int start=0;
        int index=0;
        while(list.size()>1){
            index = index+m-1;
            list.remove(m);
        }
        return 0;
    }
}
