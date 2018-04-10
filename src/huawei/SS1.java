package huawei;


import java.util.Scanner;

public class SS1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        long start = System.currentTimeMillis();
        String resut = printAscll(input);
        System.out.println(resut);
        long end = System.currentTimeMillis();
        System.out.println(end-start);
    }

    public static String printAscll(String input) {
        char[] chars = input.toCharArray();
        //Arrays.sort(chars);
        int[] numbers = new int[10];
        int[] high = new int[26];
        int[] low = new int[26];
        int level = 0;
        int index = 0;
        StringBuilder result = new StringBuilder();
        //统计
        for (char c : chars) {
            if (c >= '0' && c <= '9') {//数字
                index = c - '0';
                numbers[index] = numbers[index] + 1;
                if (numbers[index] > level) {
                    level = numbers[index];
                }
            } else if (c >= 'A' && c <= 'Z') {//大写字母
                index = c - 'A';
                high[index] = high[index] + 1;
                if (high[index] > level) {
                    level = high[index];
                }
            } else {
                index = c - 'a';
                low[index] = low[index] + 1;
                if (low[index] > level) {
                    level = low[index];
                }
            }
        }

        for (int i = 0; i < level; i++) {
            for (int j = 0; j < 9; j++) {
                if (numbers[j] > 0) {
//                    System.out.print(j);
                    result.append(j);
                    numbers[j] = numbers[j] - 1;
                }
            }
            for (int j = 0; j < 26; j++) {
                if (high[j] > 0) {
                    char temp = (char) ('A' + j);
//                    System.out.print(temp);
                    result.append(temp);
                    high[j] = high[j] - 1;
                }
            }
            for (int j = 0; j < 26; j++) {
                if (low[j] > 0) {
                    char temp = (char) ('a' + j);
//                    System.out.print(temp);
                    result.append(temp);
                    low[j] = low[j] - 1;
                }
            }
        }
        //System.out.println();
        return result.toString();
    }
}