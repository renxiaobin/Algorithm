package microsoft;

/**
 * 检查一个数是否是完全数
 * 即它的所有真因子之和等于它本身
 */
public class PerfectNum {
    public static void main(String[] args) {
        int n=28;
        int n1=11;
        int n2=100000;
        System.out.println(checkPerfectNum(n));
        System.out.println(checkPerfectNum(n1));
        System.out.println(checkPerfectNum(n2));
    }

    /**
     * 若i是因子，则n/i也是
     * 从2遍历到sqrt(n)
     * @param n
     * @return
     */
    public static boolean checkPerfectNum(int n) {
        if (n==1) return false;
        int sum=1;
        for (int i = 2; i*i <=n ; i++) {
            if (n%i==0) {
                sum += i;
                sum+=i*i==n?0:n/i;
            }
        }
        return sum==n;
    }
}
