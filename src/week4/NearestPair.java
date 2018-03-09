package week4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class NearestPair {
    public static void main(String[] args) {
        double[][] arry2 = new double[][]{{10, 10}, {8, 2}, {5, 6}, {3, 3}, {12, 8}, {9, 10},{9.5,10}};
        List<double[]> list2 = Arrays.asList(arry2);
        //解法三 分治思想 二维
        List<double[]> num4 = searchLength4(list2);
        System.out.println("距离最近的两个点:(" + num4.get(0)[0] + "," + num4.get(0)[1] + ")、(" + num4.get(1)[0] + "," + num4.get(1)[1] + ")距离为:" + num4.get(2)[0]);
    }

    /*
       用double[]表示一个点
       x坐标：double[0]
       y坐标:double[1]
       返回结果List<double[]>result,其中前两个节点是两个点，第三个节点下标为0的位表示距离
       */
    private static List<double[]> searchLength4(List<double[]> list) {
        List<double[]> result = new ArrayList();
        if (list.size() <= 2) {
            if (list.size() == 2) {//只有两个点，计算两点间距离
                double des = pointsDes(list.get(0), list.get(1));
                result.add(list.get(0));
                result.add(list.get(1));
                double[] d = new double[1];
                d[0] = des;
                result.add(d);
            } else {
                result.add(list.get(0));
                result.add(list.get(0));
                double[] d = new double[1];
                d[0] = 0;
                result.add(d);
            }
            return result;
        }
        //*************************把点分成左右两部分***********************************************
        //具体分法：a.把list按照x升序排列
        //          b.选出位于中间的点 point
        list.sort(new Comparator<double[]>() {
            public int compare(double[] o1, double[] o2) {
                return (int) (o1[0] - o2[0]);
            }

        });
        int mid = list.size() / 2;
        double[] point = list.get(mid);//位于中间的点

        List<double[]> list_left = new ArrayList();
        List<double[]> list_right = new ArrayList();

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i)[0] < point[0]) {
                list_left.add(list.get(i));
            } else if (list.get(i)[0] > point[0]) {
                list_right.add(list.get(i));
            }
        }

        if (list_left.size()
                < list_right.size()) {
            list_left.add(point);
        } else {
            list_right.add(point);
        }

//***************************获取了left和right两部分的点********************************************
        List<double[]> result_left = searchLength4(list_left);
        List<double[]> result_right = searchLength4(list_right);
        System.out.println("result_left:(" + result_left.get(0)[0] + "," + result_left.get(0)[1] + ")、(" + result_left.get(1)[0] + "," + result_left.get(1)[1] + ")距离为:" + result_left.get(2)[0]);
        System.out.println("result_right:(" + result_right.get(0)[0] + "," + result_right.get(0)[1] + ")、(" + result_right.get(1)[0] + "," + result_right.get(1)[1] + ")距离为:" + result_right.get(2)[0]);
//*****************************寻找left、rignt两部分中各取一个点的组合是否距离更小**********************************
        //不用计算left.right部分全部的点的距离。只需要在有可能出现更小距离的有效区域内选取点，然后计算
        //有效区域的范围：x的取值范围(point[0]-m,point[0]+m)
        //下面开始计算有效区域并找出有效区域内的点
        //a.先判断两部分目前更小距离,来确定M的值
        double m = 0;//最小距离
        if (result_left.get(2)[0] == 0 && result_right.get(2)[0] == 0) {
            double des = pointsDes(result_left.get(0), result_right.get(1));
            result.add(result_left.get(0));
            result.add(result_right.get(1));
            double[] d = new double[1];
            d[0] = des;
            result.add(d);
            return result;

        } else {
            if (result_left.get(2)[0] == 0 && result_right.get(2)[0] > 0) {
                result.add(result_right.get(0));
                result.add(result_right.get(1));
                m = result_right.get(2)[0];
                result.add(result_right.get(2));
            } else if (result_right.get(2)[0] == 0 && result_left.get(2)[0] > 0) {
                result.add(result_left.get(0));
                result.add(result_left.get(1));
                m = result_left.get(2)[0];
                result.add(result_left.get(2));
            } else {
                if (result_left.get(2)[0] < result_right.get(2)[0]) {
                    result.add(result_left.get(0));
                    result.add(result_left.get(1));
                    m = result_left.get(2)[0];
                    result.add(result_left.get(2));
                } else {
                    result.add(result_right.get(0));
                    result.add(result_right.get(1));
                    m = result_right.get(2)[0];
                    result.add(result_right.get(2));
                }
            }
            //b.有效区域范围。计算方法:x(point[0]-m,point[0]+m)
            double x_min = point[0] - m;
            double x_max = point[0] + m;
            //c.找出有效区域内的点
            //寻找left部分x坐标在区域内的点
            List<double[]> may_list_left = new ArrayList();
            List<double[]> may_list_right = new ArrayList();
            for (int i = 0; i < list_left.size(); i++) {
                if (list_left.get(i)[0] > x_min) {
                    may_list_left.add(list_left.get(i));
                }
            }
            //寻找right部分x坐标在区域内的点
            for (int i = 0; i < list_right.size(); i++) {
                if (list_right.get(i)[0] < x_max) {
                    may_list_right.add(list_right.get(i));
                }
            }
            //****************************x坐标符合的点已经找出来了,准备开始计算,计算前还有一个筛选条件****************************
            //从left部分选出一个点pl,需要与pr进行计算的right部分的点要满足条件:pr的y坐标取值范围(pl[1]-m,pl[1]+m)
            //如果pr的y坐标超出这个范围，则pr与pl的距离大于m，则没有必要计算
            double tmp = 0;
            double[] tmp_pl = new double[2];
            double[] tmp_pr = new double[2];
            if (!may_list_left.isEmpty() && !may_list_right.isEmpty()) {
                for (int i = 0; i < may_list_left.size(); i++) {
                    double[] pl = may_list_left.get(i);
                    for (int j = 0; j < may_list_right.size(); j++) {
                        double[] pr = may_list_right.get(j);
                        if (pr[1] > (pl[1] - m) && pr[1] < (pl[1] + m)) {//只计算y坐标在可能区域内的right部分的点
                            double des = pointsDes(pl, pr);
                            if (tmp == 0 || des < tmp) {
                                tmp = des;
                                tmp_pl = pl;
                                tmp_pr = pr;
                            }
                        }
                    }
                }
            }
            //如果计算出来的距离比m小，则返回
            if (tmp > 0 && tmp < m) {
                result.set(0, tmp_pl);
                result.set(1, tmp_pr);
                result.set(2, new double[]{tmp});
            }
            return result;
        }

    }

    private static double pointsDes(double[] p1, double[] p2) {
        double des = 0;
        double x = Math.pow(Math.abs(p1[0] - p2[0]), 2);
        double y = Math.pow(Math.abs(p1[1] - p2[1]), 2);
        des = Math.sqrt(x + y);
        return des;
    }

}
