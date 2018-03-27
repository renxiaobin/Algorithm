package toutiao;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * n个元素的数组中找到差值为k的数字对去重之后的个数
 */
public class Solution1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int a[] = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        System.out.println(findPairs1(a,k));
        System.out.println(findPairs2(a,k));
    }

    /**
     * 先对数组排序，然后从头和尾两指针开始遍历查找，并根据情况移动指针
     * 时间复杂度O(nlogn)空间O(1)
     * @param nums
     * @param k
     * @return
     */
    public static int findPairs1(int[] nums, int k) {
        if(k<0 || nums.length<=1){
            return 0;
        }

        Arrays.sort(nums);
        int count = 0;
        int left = 0;
        int right = 1;

        while(right<nums.length){
            int firNum = nums[left];
            int secNum = nums[right];
            if(secNum-firNum<k)
                right++;
            else if(secNum - firNum>k)
                left++;
            else{
                count++;
                while(left<nums.length && nums[left]==firNum){
                    left++;
                }
                while(right<nums.length && nums[right]==secNum){
                    right++;
                }

            }
            if(right==left){
                right++;
            }
        }
        return count;
    }

    /**
     * 使用map作为字典
     * 时间复杂度为O(n)空间为O(n)
     * @param a
     * @param k
     * @return
     */
    public static int findPairs2(int a[],int k){
        if (a == null || a.length == 0 || k < 0)
            return 0;
        Map<Integer, Integer> map = new HashMap<>();
        int i = 0;
        //以数组元素为key，位置为value，如果有同样的元素则只保存最后一个的位置
        for (int num : a)
            map.put(num, i++);
        int res = 0;
        for (i = 0; i < a.length; i++) {
            //查找差值为k的元素是否在字典中，且该元素的位置不能和当前元素相同
            if (map.containsKey(a[i] + k) && map.get(a[i] + k) != i) {
                map.remove(a[i] + k);
                res++;
            }
        }
        //System.out.println(res);
        return res;
    }
}
