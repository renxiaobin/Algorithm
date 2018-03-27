package toutiao;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Scanner;

/**
 * 输入n个表达式，用字符画打印出表达式结果
 */
public class Solution3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n=scanner.nextInt();
        String string[] = new String[n];
        for (int i = 0; i < n; i++) {
            string[i] = scanner.next();
        }

        for (String input:string) {
            long result = calResult(input);
            printResult(result);
        }

    }

    /**
     * 将结果打印为字符画
     * @param result
     */
    public static void printResult(long result){
        BufferedImage bi = new BufferedImage(100, 10, BufferedImage.TYPE_3BYTE_BGR);
        Graphics g = bi.getGraphics();
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, bi.getWidth(), bi.getHeight());
        g.setColor(Color.BLACK);
        //g.setFont(new Font("Courier", Font.BOLD, 12)); //设置字型
        g.drawString(""+result, 0, 10);

        int r = g.getColor().getRGB();

        for(int y =0;y<bi.getHeight();y++) {
            for(int x=0;x<bi.getWidth();x++) {
                int rgb = bi.getRGB(x, y);
                if(rgb != r) {
                    System.out.print(".");
                } else {
                    System.out.print("6");
                }
            }
            System.out.println();
        }
    }

    /**
     * 计算输入的一个表达式的值
     * @param input
     * @return
     */
    public static long calResult(String input){
        String[] xyStr = input.split("[+-/*]");
        long x = Long.parseLong(xyStr[0]);
        long y = Long.parseLong(xyStr[1]);
        long r = 0;
        char opt = '+';
        if(input.contains("+")){
            opt = '+';
            r = x + y;
        }else if(input.contains("-")){
            opt = '-';
            r = x - y;
        }else if(input.contains("*")){
            opt = '*';
            r = x * y;
        }else if(input.contains("/")){
            opt = '/';
            r = x / y;
        }
        System.out.println(x+""+opt+y+"="+r);
        return r;
    }
}
