package interview;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int ans = 0, x;
        int a[][] = new int[2*n][4];
        for (int i = 0; i < n * 2; i++) {
            for (int j = 0; j < 4; j++) {
                x = sc.nextInt();
                a[i][j]= x;
            }
        }

        for (int i = 0; i < 2*n; i+=2) {
            Point p[] = new Point[4];
            for (int j = 0; j < 4; j++) {
                Point point = new Point();
                point.x=a[i][j];
                point.y=a[i+1][j];
                p[j]=point;
            }
            System.out.println(testRun(p));
        }

    }

    public static boolean testRun(Point p[]) {
        for (int i = 0; i < 4; i++) {
            for (int j = i + 1; j < 4; j++)
                if (p[i].x == p[j].x && p[i].y == p[j].y)
                    return false;
        }
        if (dis(p[0], p[1]) == dis(p[2], p[3]) && mid(p[0], p[1], p[2], p[3]) && dis(p[0], p[2]) == dis(p[0], p[3]))
            return true;
        if (dis(p[0], p[2]) == dis(p[1], p[3]) && mid(p[0], p[2], p[1], p[3]) && dis(p[0], p[1]) == dis(p[0], p[3]))
            return true;
        if (dis(p[0], p[3]) == dis(p[1], p[2]) && mid(p[0], p[3], p[1], p[2]) && dis(p[0], p[1]) == dis(p[0], p[2]))
            return true;
        return false;
    }

    public static int dis(Point a, Point b) {
        return (a.x - b.x) * (a.x - b.x) + (a.y - b.y) * (a.y - b.y);
    }

    public static boolean mid(Point a, Point b, Point c, Point d) {
        if (a.x + b.x == c.x + d.x && a.y + b.y == c.y + d.y) return true;
        return false;
    }

    static class Point {
        int x;
        int y;

        public Point(){
            x=0;
            y=0;
        }
    }
}
