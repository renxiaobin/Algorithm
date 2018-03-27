package toutiao;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 求两种操作拼接字符串长度至n的最小操作步骤
 */
public class Solution2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(cal(n));
        System.out.println(cal2(n));
    }

    /**
     * 由于两种操作都会使得s成为m的倍数，所以n一定为m的倍数长度，则将n质数因子分解
     * n为质数时，m只能为1，故需要n-1次第二种操作
     * n为非质数，分解成质数因子后，m等于n/最小因子，共需要各因子减一再求和的操作次数
     * @param n
     * @return
     */
    public static int cal(int n) {
        List<Integer> result = decom(n);
        int count=0;
        for (int i = 0; i < result.size(); i++) {
            count+=(result.get(i)-1);
        }
        return count;
    }

    /**
     * 获取质数因子的分解方法
     * @param n
     * @return
     */
    public static List<Integer> decom(int n){
        List<Integer> list = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            while (n%i==0){
                list.add(i);
                n/=i;
            }
        }
        return list;
    }

    /**
     * 方法二
     */
    static int result=Integer.MAX_VALUE;
    public static int cal2(int n){

        dfs("a","a",0,n);
        return result;
    }

    /**
     * 深度优先搜索
     * 找出每一种拼接到n的方法，取最小的操作次数
     * @param s
     * @param m
     * @param step
     * @param n
     */
    private static void dfs(String s,String m,int step,int n) {
        if (s.length()>=n){
            if (s.length()==n)
                result=step<result?step:result;
        }else {
            dfs(s+s,s,step+1,n);
            dfs(s+m,m,step+1,n);
        }
    }
}
