import java.util.Scanner;

public class Test {

    private static final int maxn = 1000 + 5;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();

        int w[] = new int[maxn];
        int a[] = new int[maxn];
        int b[] = new int[maxn];
        for (int i = 0; i < n; i++) {
            w[i] = in.nextInt();
            a[i] = in.nextInt();
            b[i] = in.nextInt();
            //write your code

        }

        int result=0;
        int i=maxValue(w,a,b);
        while(m>0 && m>=w[i]){
            int count = m/w[i];
            m = m-count*w[i];
            result = result+count*a[i]+b[i];
            w[i] = w[i]*10000;
            i = maxValue(w,a,b);
        }
        System.out.println(result);
    }

    public static int maxValue(int w[],int a[],int b[]){
        int result=0, temp=0;
        for (int i = 0; i < w.length; i++) {
            if(i==0) {
                temp = w[i] / (a[i] + b[i]);
                result = 0;
            }
            if(a[i] !=0 && temp >= w[i]/(a[i]+b[i])){
                temp = w[i] / (a[i] + b[i]);
                result = i;
            }
        }
        return result;
    }
}
