package week1;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Checker {
    public static void main(String[] args) {
        String s1 = "1244 21";
        String s2 = "4241 12";
        check(s1,s2);
    }

    private static void check(String s1, String s2) {
        char[] a1 = s1.toCharArray();
        Arrays.sort(a1);
        char[] a2 = s2.toCharArray();
        Arrays.sort(a2);

        if (new String(a1).equals(new String(a2))){
            System.out.println("The two words are transfered");
        }else{
            System.out.println("not");
        }
    }
}
