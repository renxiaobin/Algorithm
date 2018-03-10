package week5;

public class FakeCoin {
    public static void main(String[] args) {
        float a[]={1,1,1,1,1,1,1,1,1,1,1,0.6f,1,1,1};
        System.out.println("硬币个数为："+a.length);
        System.out.println("硬币总重量为："+weight(a,0,a.length-1));
        System.out.println("假币在数组中的下标为："+find3(a,0,a.length-1));
    }
    //三分法找假币
    /**
     * left表示所要查找的数组中第一个元素在n个硬币中的数组下标
     * right表示所要查找的数组中最后一个元素在n个硬币中的数组下标
     * 输入：硬币数组a[]
     * 输出：假币在数组中对应的下标
     *
     */
    static int find3(float a[],int left,int right){
        int n=right-left+1;//硬币个数
        int m1=left+upint(n)-1;//第一堆硬币的最后一个硬币在n个硬币中对应的下标
        int m2=left+2*upint(n)-1;//第二堆硬币的最后一个硬币在n个硬币中对应的下标

        //前两堆硬币等重，则在第三堆中找假币
        if (weight(a,left,m1)==weight(a,m1+1,m2)) {
            System.out.println("左右相等！");
            System.out.print("left="+left+"  ");
            System.out.print("right="+right+"  ");
            System.out.print("m1="+m1+"  ");
            System.out.println("m2="+m2+"  ");
            if ((right - m2) == 1)
                return right;
            else {
                left = m2 + 1;
                return find3(a, left, right);

            }
        }

        //第一堆比第二堆重，则在第二堆中找假币
        if (weight(a,left,m1)>weight(a,m1+1,m2)) {
            System.out.println("左大于右！");
            System.out.print("left="+left+"  ");
            System.out.print("right="+right+"  ");
            System.out.print("m1="+m1+"  ");
            System.out.println("m2="+m2+"  ");
            if ((m2 - m1) == 1)
                return m2;
            else {
                left = m1 + 1;
                right = m2;
                return find3(a, left, right);
            }
        }

        //第二堆比第一堆重，则在第一堆中找假币
        if (weight(a,left,m1)<weight(a,m1+1,m2)){
            System.out.println("左小于右！");
            System.out.print("left="+left+"  ");
            System.out.print("right="+right+"  ");
            System.out.print("m1="+m1+"  ");
            System.out.println("m2="+m2+"  ");
            if(m1==left){
                return left;
            } else {
                right=m1;
                return find3(a,left,right);
            }
        }
        return 0;


    }
    //计算硬币重量，即数组元素和
    static float weight(float a[],int left,int right){
        float sum=0;
        for(int i=left;i<=right;i++){
            sum+=a[i];
        }
        return sum;
    }

    //对 n/3 的值向上取整
    static int upint(int n){
        if((n%3)==0)
            return n/3;
        else return n/3+1;
    }

}
