package huawei;

import java.util.*;

public class S1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String s = scanner.nextLine();
        long start = System.currentTimeMillis();
        System.out.println(cal(s));
        long end = System.currentTimeMillis();
        System.out.println(end-start);
    }

    private static String cal(String s) {
        String result = "";
        Map<Character, Integer> map = new TreeMap<>();
        char a[] = s.toCharArray();
        for (int i = 0; i < a.length; i++) {
            if (map.get(a[i]) == null) {
                map.put(a[i], 1);
            } else {
                map.put(a[i], map.get(a[i]) + 1);
            }
        }
        while (map.size() != 0) {
            Iterator<Map.Entry<Character, Integer>> it = map.entrySet().iterator();
            while(it.hasNext()){
                Map.Entry<Character, Integer> entry = it.next();
                result += entry.getKey();
                map.put(entry.getKey(),entry.getValue()-1);
                if (entry.getValue() <= 0)
                    it.remove();
            }

        }

        return result;
    }
}
