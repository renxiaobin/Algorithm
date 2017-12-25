package week1;

import java.util.Stack;

public class HanNuo {
    public static void main(String[] args) {
        int n=4;
        char a='A',b='B',c='C';
        //hanNuo1(n,a,b,c);
        hanNuo2(n,a,b,c);

        System.out.println("move count is "+(Math.pow(2,n)-1));
    }

    static Stack<Integer> stack[] = new Stack[]{new Stack(),new Stack(),new Stack(),new Stack()};
    private static void hanNuo2(int n,char a,char b,char c) {

        for (int i = n; i >0 ; i--) {
            stack[1].push(i);
        }

        if(n%2==1){
            b='C';
            c='B';
        }

        int count=0;
        while(true){
            move2(count%3+1,(count+1)%3+1);
            if (!move2(count%3+1,(count+2)%3+1))
                if (!move2((count+2)%3+1,count%3+1))
                    break;
            count++;
        }

    }

    private static boolean move2(int from,int to){
        if (stack[from].empty()) return false;
        if (!stack[to].empty()){
            if ((stack[to].peek()-stack[from].peek())<0){
                return false;
            }
        }

        stack[to].push(stack[from].pop());

        System.out.println("move disk form " + from + " to " + to);
        return true;
    }

    private static void hanNuo1(int n,char a,char b,char c) {
        if (n==1){
            move1(1,a,c);
        }else {
            hanNuo1(n - 1, a, c, b);
            move1(n, a, c);
            hanNuo1(n - 1, b, a, c);
        }
    }

    private static void move1(int disk,char a, char b){
        System.out.println("move disk [" + disk + "] form " + a + " to " + b);
    }
}
