package aiqiyi;

import java.util.Scanner;

public class S2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int X = scanner.nextInt();
        int Y = scanner.nextInt();
        int Z = scanner.nextInt();

        int max = Math.max(X,Math.max(Y,Z));
        int min = Math.min(X,Math.min(Y,Z));
        System.out.println(cal(min,X+Y+Z-max-min,max));
    }

    private static int cal(int x, int y, int z) {
        int count=0;
        if ((z-x)%2==(z-y)%2){
            count=(z-y)+(y-x)/2;
        }else{
            count=(z-y)+(y-x)/2+2;
        }
        return count;
    }
}
