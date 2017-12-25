package week1;

import static java.lang.Double.max;
import static java.lang.Double.min;

public class CrossValidation {

    public static void main(String[] args) {
        Point p1 = new Point(1,1);
        Point p2 = new Point(3,4);
        Point p3 = new Point(0,2);
        Point p4 = new Point(1,1);

        boolean isCross = cal(p1,p2,p3,p4);
        if (isCross){
            System.out.println("The two segment have point of cross");
        }else{
            System.out.println("not cross");
        }
    }

    private static boolean cal(Point p1, Point p2, Point p3, Point p4) {
        if ( max(p1.x, p2.x)<min(p3.x, p4.x) )
        {
            return false;
        }
        if ( max(p1.y, p2.y)<min(p3.y, p4.y) )
        {
            return false;
        }
        if ( max(p3.x, p4.x)<min(p1.x, p2.x) )
        {
            return false;
        }
        if ( max(p3.y, p4.y)<min(p1.y, p2.y) )
        {
            return false;
        }
        if ( xMutil(p3, p2, p1)*xMutil(p2, p4, p1)<0 )
        {
            return false;
        }
        if ( xMutil(p1, p4, p3)*xMutil(p4, p2, p3)<0 )
        {
            return false;
        }
        return true;
    }

    static double xMutil(Point p1,Point p2,Point p0){
        return (p1.x-p0.x)*(p2.y-p0.y)-(p2.x-p0.x)*(p1.y-p0.y);
    }

    static class Point{
        double x;
        double y;

        Point(double x1, double y1){
            x=x1;
            y=y1;
        }
    }
}
