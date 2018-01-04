package week4;


import java.util.ArrayList;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class NPointPair {
    /**
     * 最近点问题
     *
     * @param S
     */
    public static Point[] closestPoint(Point[] S) {

        Point[] result = new Point[2];
        /**
         * 0.首先，解决该问题的边界，当数组长度在一定范围内时直接求出最近点，蛮力求解
         */
        double dmin = Double.POSITIVE_INFINITY;
        double tmpmin = 0;
        if (S.length <= 20) {
            for (int i = 0; i < S.length; i++) {
                for (int j = i + 1; j < S.length; j++) {
                    tmpmin = Math.sqrt(Math.pow(S[i].getX() - S[j].getX(), 2)) + Math.pow(S[i].getY() - S[j].getY(), 2);
                    if (tmpmin < dmin) {
                        dmin = tmpmin;
                        result[0] = S[i];
                        result[1] = S[j];
                    }
                }
            }
            return result;
        }

        /**
         *1.求所有点在X坐标的中位数
         */
        int minX = (int) Double.POSITIVE_INFINITY;        //保证假设的初始最小值足够大
        int maxX = (int) Double.NEGATIVE_INFINITY;        //保证假设的初始最大值足够小
        for (int i = 0; i < S.length; i++) {
            if (S[i].getX() < minX)
                minX = S[i].getX();
            if (S[i].getX() > maxX)
                maxX = S[i].getX();
        }
        int midX = (minX + maxX) / 2;

        /**
         * 2.以midX为界将所有点分成两组分别存放在两个表中
         */
        ArrayList T1 = new ArrayList();
        ArrayList T2 = new ArrayList();
        for (int i = 0; i < S.length; i++) {
            if (S[i].getX() <= midX)        //是否要=号？
                T1.add(S[i]);
            if (S[i].getX() > midX)
                T2.add(S[i]);
        }

        /**
         * 3.将两张表转化为数组类型，并分别按X坐标升序排列
         */
        Point[] S1 = new Point[T1.size()];
        Point[] S2 = new Point[T2.size()];

        T1.toArray(S1);
        T2.toArray(S2);

        mergeSort(S1, "x");        //按X坐标升序排列
        mergeSort(S2, "x");        //按X坐标升序排列

        /**
         * 4.求S1中的最近距离的两个点
         */
        Point[] result1 = new Point[2];
        result1 = closestPoint(S1);

        /**
         * 5.求S2中的最近距离的两个点
         */
        Point[] result2 = new Point[2];
        result2 = closestPoint(S2);

        /**
         * 6.求两最近距离的最小值
         */
        double d1 = Math.sqrt(Math.min(Math.pow(result1[0].getX() - result1[1].getX(), 2) + Math.pow(result1[0].getY() - result1[1].getY(), 2),
                Math.pow(result2[0].getX() - result2[1].getX(), 2) + Math.pow(result2[0].getY() - result2[1].getY(), 2)));

        if (Math.pow(result1[0].getX() - result1[1].getX(), 2) + Math.pow(result1[0].getY() - result1[1].getY(), 2) <
                Math.pow(result2[0].getX() - result2[1].getX(), 2) + Math.pow(result2[0].getY() - result2[1].getY(), 2))
            result = result1;
        else
            result = result2;

        /**
         * 7.在S1、S2中收集距离中线小于d1的点，分别存放于两个表中
         */
        ArrayList T3 = new ArrayList();
        ArrayList T4 = new ArrayList();
        for (int i = 0; i < S1.length; i++) {
            if (midX - S1[i].getX() < d1)
                T3.add(S1[i]);
        }
        for (int i = 0; i < S2.length; i++) {
            if (S2[i].getX() - midX < d1) {
                T4.add(S2[i]);
            }
        }

        /**
         * 8.分别将表T3、T4转换为数组类型的S3、S4，并将其分别按Y坐标升序排列
         */
        Point[] S3 = new Point[T3.size()];
        Point[] S4 = new Point[T4.size()];
        T3.toArray(S3);
        T4.toArray(S4);

        mergeSort(S3, "y");
        mergeSort(S4, "y");

        /**
         * 求解S3、S4两者之间可能的更近（相比于d1）距离 , 以及构成该距离的点
         */
        double d = Double.POSITIVE_INFINITY;
        for (int i = 0; i < S3.length; i++) {
            for (int j = 0; j < S4.length; j++) {
                if (Math.abs(S3[i].getY() - S4[j].getY()) < d1) {
                    double tmp = Math.sqrt(Math.pow(S3[i].getX() - S4[j].getX(), 2) + Math.pow(S3[i].getY() - S4[j].getY(), 2));
                    if (tmp < d) {
                        d = tmp;
                        result[0] = S3[i];
                        result[1] = S4[j];
                    }
                }
            }
        }

        return result;
    }

    private static void mergeSort(Point[] a, String property) {
        Point[] tempArray = new Point[a.length];
        mergeSort(a, tempArray, 0, a.length - 1, property);
    }

    private static void mergeSort(Point[] a, Point[] tempArray, int left, int right, String property) {
        if (left < right) {
            int center = (left + right) >> 1;
            //分治
            mergeSort(a, tempArray, left, center, property);
            mergeSort(a, tempArray, center + 1, right, property);
            //合并
            merge(a, tempArray, left, center + 1, right, property);
        }
    }

    private static void merge(Point[] a, Point[] tempArray, int leftPos, int rightPos, int rightEnd, String property) {
        int leftEnd = rightPos - 1;
        int numOfElements = rightEnd - leftPos + 1;

        int tmpPos = leftPos;        //游标变量, 另两个游标变量分别是leftPos 和 rightPos

        while (leftPos <= leftEnd && rightPos <= rightEnd) {
            if (property.equals("x")) {
                if (a[leftPos].getX() <= a[rightPos].getX())
                    tempArray[tmpPos++] = a[leftPos++];
                else
                    tempArray[tmpPos++] = a[rightPos++];
            } else if (property.equals("y")) {
                if (a[leftPos].getY() <= a[rightPos].getY())
                    tempArray[tmpPos++] = a[leftPos++];
                else
                    tempArray[tmpPos++] = a[rightPos++];
            } else
                throw new RuntimeException();
        }

        while (leftPos <= leftEnd)
            tempArray[tmpPos++] = a[leftPos++];
        while (rightPos <= rightEnd)
            tempArray[tmpPos++] = a[rightPos++];

        //将排好序的段落拷贝到原数组中
        System.arraycopy(tempArray, rightEnd - numOfElements + 1, a, rightEnd - numOfElements + 1, numOfElements);
    }

    public static void main(String[] args) {

        Set<Point> testData = new TreeSet<Point>();

        Random random = new Random();

        int x = 0;
        int y = 0;

        for (int i = 0; i < 50; i++) {
            x = random.nextInt(500);
            y = random.nextInt(500);
            System.out.println("x:" + x + "  y:" + y);
            testData.add(new Point(x, y));
        }

        Point[] S = new Point[testData.size()];
        S = (Point[]) testData.toArray(S);

        for (int i = 0; i < S.length; i++) {
            System.out.println("(" + S[i].getX() + ", " + S[i].getY() + ")");
        }

        System.out.println(testData.size());

        Point[] result = new Point[2];

        result = closestPoint(S);

        System.out.println("最近的两点分别是(" + result[0].getX() + ", " + result[0].getY()
                + ") 和 (" + result[1].getX() + ", " + result[1].getY() + "), 最近距离为："
                + Math.sqrt(Math.pow(result[0].getX() - result[1].getX(), 2) + Math.pow(result[0].getY() - result[1].getY(), 2)));

    }

    static class Point implements Cloneable, Comparable<Point> {
        public Point() {
            x = 0;
            y = 0;
        }

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public void setX(int x) {
            this.x = x;
        }

        public void setY(int y) {
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        private int x;
        private int y;

        @Override
        public int compareTo(Point o) {
            if (x == o.getX() && y == o.getY())
                return 0;
            else
                return 1;
        }
    }
}
