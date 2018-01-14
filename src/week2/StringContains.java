package week2;

import java.util.HashMap;

public class StringContains {
    public static void main(String[] args) {
        String s1="abdzc";
        String s2="ahgfhbsscd";

        System.out.println(isContains(s1,s2));
    }

    private static boolean isContains(String s1, String s2) {
        char a1[]=s1.toCharArray();
        char a2[]=s2.toCharArray();

        HashMap map = new HashMap(26);
        int num=0;

        for (int i = 0; i < a1.length; i++) {
            if (!map.containsKey(a1[i])) {
                map.put(a1[i], 1);
                num++;
            }
        }
        for (int i = 0; i < a2.length; i++) {
            if (map.containsKey(a2[i])){
                num--;
            }
        }
        return num==0?true:false;

    }
}
