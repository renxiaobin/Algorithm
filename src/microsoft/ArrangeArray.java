package microsoft;

import java.util.Arrays;

/**
 * 判断字符串数组中的字符是否能按照顺序相接，并且顺序是字母排列顺序
 * abc和cde可以相接，abc和cdg不可以
 */
public class ArrangeArray {
    public static void main(String[] args) {
        String arr[] = new String[]{"abc","cde","efgh","hijkl"};
        String arr1[] = new String[]{"efgh","hijkl","abc","cde"};
        String arr2[] = new String[]{"abc","cde","efgh","hijlk"};
        System.out.println(checkArrange(arr));
        System.out.println(checkArrange(arr1));
        System.out.println(checkArrange(arr2));
    }

    /**
     * 先把数组中的字符根据首字符排序，然后拼接
     * 再逐个判断字符是否顺序排列
     * @param arr
     * @return
     */
    public static boolean checkArrange(String[] arr) {
        Arrays.sort(arr);
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
        }
        String ss = sb.toString();
        char a[] = ss.toCharArray();
        for(int i=0;i<a.length-1;i++){
            if (a[i+1]==(char)a[i]+1 || a[i]==a[i+1]){
                continue;
            }else {
                return false;
            }
        }

        return true;
    }
}
