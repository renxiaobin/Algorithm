package wangyi;


import java.util.*;

/**
 * 给定数组中的各个元素值表示
 * 每个小朋友能看到与自己拥有颜色相同的糖果的人数，不包括自身
 * 计算至少有几个同学拿到了糖果
 */
public class S3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<Integer, Integer> map = new HashMap<>();
        String[] nums = null;
        nums = scanner.nextLine().split(" ");

        //使用map保存，key为小朋友看到的人数，value为看到人数相同的小朋友数量
        for (int i = 0; i < nums.length; i++) {
            int temp = Integer.valueOf(nums[i]);
            if (map.containsKey(temp)) {
                map.put(temp, map.get(temp) + 1);
            } else {
                map.put(temp, 1);
            }
        }
        System.out.println(cal(map));
    }

    /**
     * 找规律可得
     * 若看到有1个与自己颜色相同的朋友，value数量为3，则至少有2+1+1=4人
     * 若看到1的数量为4，则至少有2+2=4人
     * 若看到key的数量为value，则共有value/(key+1)组能互相看到的人，每组人数key+1
     * 剩下的value%(key+1)!=0时不足以凑成一组，但仍然至少需要key+1的人，求和即为当前key值的至少总人数啊
     * 计算每个key值的总和相加即为结果
     * @param map
     * @return
     */
    public static int cal(Map<Integer, Integer> map) {
        int sum = 0;
        Iterator iter = map.entrySet().iterator();
        if (map == null || map.size() == 0) return 0;
        while (iter.hasNext()) {
            Map.Entry<Integer, Integer> entry = (Map.Entry) iter.next();
            int key = entry.getKey();
            int count = entry.getValue();

            int m = count % (key + 1);
            int times = count / (key + 1);
            sum += (times * (key + 1));
            if (m != 0) {
                sum += (key + 1);
            }
        }
        return sum;
    }
}
