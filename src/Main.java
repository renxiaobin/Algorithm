import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        //System.out.println(NumberOf1Between1AndN_Solution(2048));
        Scanner in = new Scanner(System.in);
        int n, x, ans = 0;
        int max=0,sec=0,temp=0;
        n = in.nextInt();
        for (int i = 1; i <= n; i++) {
            x = in.nextInt();
            // write your code
            if(x>max){
                sec = max;
                max = x;
                if(max!=0 && sec!=0) {
                    temp = max ^ sec;
                    if (temp > ans) {
                        ans = temp;
                    }
                }
                continue;
            }
            if(x>sec){
                sec=x;
                if(max!=0 && sec!=0) {
                    temp = max ^ sec;
                    if (temp > ans) {
                        ans = temp;
                    }
                }
            }

        }

        System.out.println(ans);
    }

    public static int NumberOf1Between1AndN_Solution(int n) {
        if(n<=0)
            return 0;

        int count = 0;
        while(n>0)
        {
            String str = String.valueOf(n);
            char[] chars = str.toCharArray();
            for(int i=0; i<chars.length; i++)
            {
                if(chars[i] == '1')
                    count++;
            }
            n--;
        }
        return count;
    }
}
