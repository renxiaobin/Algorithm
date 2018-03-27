package interview;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class FindCoin {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        int k = findKfor2(n);
        if (k <= 0) {
            System.out.println(0);
            return;
        }
        //System.out.println(Math.pow(2,k));
        ArrayList<List> list = new ArrayList();
        for (int i = k; i > 0; i--) {
            long temp = n - (long) Math.pow(2, k);
            List result = new LinkedList();
            result.add(k);
            boolean tag = true;
            while (temp > 0) {
                if (findKfor2(temp) >= k) {
                    if (result.contains(k) && result.indexOf(k) != result.lastIndexOf(k)) {
                        k = k - 1;
                    }
                } else {
                    k = findKfor2(temp);
                }
                temp = temp - (long) Math.pow(2, k);

                if (result.contains(k) && result.indexOf(k) != result.lastIndexOf(k)) {
                    tag = false;
                    break;
                } else {
                    result.add(k);
                }

            }
            if (tag) {
                list.add(result);
            }
        }

        System.out.println(list.size());

    }

    private static int findKfor2(long n) {
        int k = 0;

        while (n != 0) {
            n = n >> 1;
            k++;
        }
        return k - 1;
    }


}
