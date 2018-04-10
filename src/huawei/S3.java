package huawei;

import java.util.Scanner;

public class S3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s1 = scanner.nextLine();
        String s2 = scanner.nextLine();
        System.out.println(multi(s1,s2));
    }

    private static String multi(String a, String b) {
        char aChar[] = a.toCharArray();
        char bChar[] = b.toCharArray();

        int aInt[] = new int[aChar.length];
        int bInt[] = new int[bChar.length];
        int result[] = new int[aChar.length+bChar.length];

        for (int i = 0; i < aInt.length; i++) {
            aInt[i]=aChar[i]-'0';
        }
        for (int i = 0; i < bInt.length; i++) {
            bInt[i]=bChar[i]-'0';
        }
        for (int i = 0; i < aInt.length; i++) {
            for (int j = 0; j < bInt.length; j++) {
                result[i+j+1]+=aInt[i]*bInt[j];
            }
        }
        for (int i = result.length-1; i >0; i--) {
            result[i-1]+=result[i]/10;
            result[i]%=10;
        }
        String resultString ="";
        for (int i = 0; i < result.length; i++) {
            if (i==0&&result[i]==0) continue;
            resultString=resultString+result[i];
        }
        return resultString;
    }
}
