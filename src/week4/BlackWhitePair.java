package week4;

public class BlackWhitePair {
    public static final int INF = 0x0fffffff;
    public static final double EPS = 1e-10;

    static class Point {
        double x;
        double y;

        public Point(double x1, double y1) {
            x = x1;
            y = y1;
        }
    }

    static Point[] blackPoint = new Point[]{
            new Point(10, 10),
            new Point(8, 2),
            new Point(5, 6),
            new Point(3, 3),
            new Point(12, 8),
            new Point(9, 10)};
    static Point[] whitePoint = new Point[]{
            new Point(1, 15),
            new Point(3, 4),
            new Point(7, 6),
            new Point(8, 1),
            new Point(10, 9),
            new Point(9, 11)};
    static int n = blackPoint.length;


    static double w[][] = new double[n+1][n+1];
    static double lx[] = new double[n+1], ly[] = new double[n+1], slack[] = new double[n+1];
    static int s[] = new int[n+1], t[] = new int[n+1], left[] = new int[n+1];

    public static void main(String[] args) {


        for (int i = 1; i <=n; i++) {
            for (int j = 1; j <=n; j++) {
                w[i][j] = -dist(blackPoint[i-1], whitePoint[j-1]);
            }
        }

        km();
        for(int i = 1;i <= n;i++)
            System.out.println(left[i]);

    }

    static void km()
    {
        for (int i = 1; i <= n; i++) {
            left[i] = 0;
            ly[i] = 0;
            lx[i] = -INF;
            for (int j = 1; j <= n; j++)
                lx[i] = Math.max(lx[i], w[i][j]);
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++)
                slack[j] = INF;
            while (true) {
                for (int j = 1; j <= n; j++) s[j] = t[j] = 0;
                if (match(i)==1)
                    break;
                else update();
            }
        }
    }

    static int match(int i) {
        s[i] = 1;
        for (int j = 1; j <= n; j++)
            if (t[j]==0) {

                double tmp = lx[i] + ly[j] - w[i][j];
                if (Math.abs(tmp) < EPS) {
                    t[j] = 1;
                    if (left[j]==0 || match(left[j])==1) {
                        left[j] = i;
                        return 1;
                    }
                } else slack[j] = Math.min(tmp, slack[j]);
            }
        return 0;
    }

    static void update()
    {
        double a = INF;
        for(int i = 1;i <= n;i++)
            if(s[i]!=0)
                for(int j = 1;j <= n;j++)
                    if(t[j]==0)
                        a = Math.min(a,lx[i]+ly[j]-w[i][j]);
        for(int i = 1;i <= n;i++)
        {
            if(s[i]!=0) lx[i] -= a;
            if(t[i]!=0) ly[i] += a;
        }
    }

    private static double dist(Point p1, Point p2) {
        return Math.sqrt(Math.pow(p1.x - p2.x, 2) + Math.pow(p1.y - p2.y, 2));
    }
}
