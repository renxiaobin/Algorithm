package wangyi;

import java.util.*;

/**
 * 从数组中取数字，要求取得的数字和最大
 * 规则：若取了元素值为k，则数组中的元素值为k-1和k+1需要被删除，才能继续取
 */
public class S2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        String[] nums = null;
        nums = scanner.nextLine().split(" ");
        //用map的key保存数组中的元素，value保存该元素在数组中的总和=出现次数*元素值
        for (int i = 0; i < nums.length; i++) {
            int temp = Integer.valueOf(nums[i]);
            if (map.containsKey(temp)) {
                map.put(temp, map.get(temp) + temp);
            } else {
                map.put(temp, temp);
            }
        }
        System.out.println(cal(map));
    }

    /**
     * 先取map中value最大的元素，即数组中总和最大的单个元素
     * 然后从map去掉该元素以及相应的元素k-1和k+1，再递归调用计算取得的数字总和
     * @param map
     * @return
     */
    public static int cal(Map<Integer, Integer> map) {
        Iterator iter = map.entrySet().iterator();
        int maxKey = Integer.MIN_VALUE;
        int maxSum = Integer.MIN_VALUE;
        int sum=0;
        if (map==null || map.size()==0) return 0;
        while (iter.hasNext()) {
            Map.Entry<Integer,Integer> entry = (Map.Entry) iter.next();
            if (maxSum<entry.getValue()){
                maxKey = entry.getKey();
                maxSum = entry.getValue();
            }
        }
        sum+=maxSum;
        map.remove(maxKey+1);
        map.remove(maxKey-1);
        map.remove(maxKey);
        map = new HashMap<>(map);
        return sum+cal(map);
    }
}
