package wangyi;

import java.util.Scanner;

/**
 * 根据给定的a-z字符占用宽度数组，计算给定的字符串占用了几行以及最后一行有几个字符
 * 每行宽度为100，超出需要另起一行
 */
public class S1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int letter[] = new int[26];
        for (int i = 0; i < 26; i++) {
            letter[i] = scanner.nextInt();
        }
        String string = scanner.next();
        cal(letter,string);
    }

    /**
     * 循环字符串中每个字符，如果当前行占用的宽度加上该字符锁占宽度大于100
     * 则另起一行，并将该字符至于下一行
     * @param letter
     * @param string
     */
    public static void cal(int[] letter, String string) {
        int width=0;
        int lines = 1;
        for (char c:string.toCharArray()) {
            width+=letter[(int)c-'a'];
            if(width>100){
                lines++;
                width=letter[(int)c-'a'];
            }
        }
        System.out.println(lines+" "+width);
    }
}
