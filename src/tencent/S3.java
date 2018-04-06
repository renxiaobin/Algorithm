package tencent;

import java.util.*;

public class S3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long m = scanner.nextLong();

        List<int[]> mask = new ArrayList<>();
        List<int[]> machine = new ArrayList<>();



        for (int i = 0; i < n; i++) {
            int xi = scanner.nextInt();
            int yi = scanner.nextInt();

            machine.add(new int[]{xi,yi});
        }

        for (int i = 0; i < m; i++) {
            int zi = scanner.nextInt();
            int wi = scanner.nextInt();

            mask.add(new int[]{zi,wi});
        }

        cal(machine,mask);

    }

    private static void cal(List<int[]> machine, List<int[]> mask) {

    }
}
