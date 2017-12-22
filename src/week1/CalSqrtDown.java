package week1;

public class CalSqrtDown {

    public static void calSqrtDown(int n){
        if (n<0) {
            System.out.println("n must more than 0");
            return;
        }
        int i=0;
        while (i*i<=n){
            i++;
        }
        i--;

        System.out.println("sqrt(n) down value = [" + i + "]");
    }

    public static void main(String[] args) {
        int n=10;
        calSqrtDown(n);
    }
}
