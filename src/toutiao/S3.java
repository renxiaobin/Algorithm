package toutiao;

import java.util.Scanner;

public class S3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        int q= scanner.nextInt();

        int n[] = new int[q];
        int m[] = new int[q];
        int x[] = new int[q];
        int y[] = new int[q];
        for (int i = 0; i < q; i++) {
            n[i] = scanner.nextInt();
            m[i] = scanner.nextInt();
            x[i] = scanner.nextInt();
            y[i] = scanner.nextInt();

        }
        for (int i = 0; i < q; i++) {
            System.out.println(cal(s,n[i],m[i],x[i],y[i]));
        }
    }

    private static int cal(String s, int n, int m, int x, int y) {
        int result=0;
        for(char c:s.toCharArray()){
            switch (c){
                case 'u':
                    x--;
                    break;
                case 'd':
                    x++;
                    break;
                case 'l':
                    y--;
                    break;
                case 'r':
                    y++;
                    break;
            }
            if (x<=n && x>=1 && y<=m && y>=1){
                result++;
                continue;
            }else {
                result++;
                break;
            }
        }
        return result;
    }
}
