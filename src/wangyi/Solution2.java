package wangyi;

import java.util.Scanner;

/**
 * 找出x，y都不大于n，且x除以y的余数大于k的所有数对
 */
public class Solution2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        long start1 = System.currentTimeMillis();
        System.out.println(cal(n, k));
        long end1 = System.currentTimeMillis();
        System.out.println(end1-start1);

        long start2 = System.currentTimeMillis();
        System.out.println(cal2(n, k));
        long end2 = System.currentTimeMillis();
        System.out.println(end2-start2);
    }

    /**
     * 从y开始考虑，y必须大于余数k
     * 然后根据倍数以及计算剩余的数是否满足情况计算y对应的x的数量
     * 时间复杂O(n)
     * @param n
     * @param k
     * @return
     */
    private static int cal2(int n, int k) {
        int count = 0;
        for (int y = k + 1; y <= n; y++) {
            int mult = n / y;
            count += mult * (y - k);
            int temp = n - k - mult * y + 1;
            if (temp > 0)
                count += temp;
        }

        return count;
    }

    /**
     * 蛮力法O(n^2)太慢
     * @param n
     * @param k
     * @return
     */
    private static int cal(int n, int k) {
        int count = 0;
        for (int i = 0; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if ((i % j) >= k)
                    count++;
            }
        }
        return count;
    }


}
