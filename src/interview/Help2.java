package interview;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Help2 {



    public static void main(String[] args) {

        Scanner scanner=new Scanner(System.in);
        long n=scanner.nextLong();
        if (n<=2){
            System.out.println(n);
            return;
        }
        Set<Long> countset=new HashSet<>();
        long stop=n/2;

        for(int i=1;i<=stop;i++) {
            long result=(i)^(n-i);
            //System.out.println(Long.toBinaryString(result));
            countset.add(result);
        }
        System.out.println(countset.size());
        main(n);
    }

    static long dfs(long n)
    {
        if(n == 1 || n == 2) return 1;
        if(n % 2 == 0) return dfs(n / 2);
        else return dfs(n/2) + dfs(n/2 + 1);
    }

    static int main(long n)
    {

        System.out.println(dfs(n + 1) );
        return 0;
    }

}