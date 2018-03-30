package toutiao;

import java.util.*;

/**
 * 跳板问题
 * n个高度不同的跳板，初始高度为0，每次跳跃可以选择与自己高度绝对值小于等于h的跳板,跳跃过后到达以跳板为轴的镜像位置
 * 即跳跃之后的高度=当前高度+（跳板高度-当前高度）*2
 * 跳k次最高能多高
 *
 */
public class Solution5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int h = scanner.nextInt();

        int ti[] = new int[n];
        Map<Integer,Integer> map = new HashMap();
        for (int i = 0; i < n; i++) {
            ti[i]=scanner.nextInt();
            map.put(ti[i],1);
        }

        //Arrays.sort(ti);
        System.out.println(cal(ti,k,h,map));
    }

    /**
     * 使用BFS
     * 问题来了，咋写
     * @param ti
     * @param k
     * @param h
     * @param map
     * @return
     */
    private static int cal(int[] ti, int k, int h,Map<Integer,Integer> map) {
        int init = 0;
        boolean vis[] = new boolean[1000];
        List<int[]> list = new LinkedList();
        list.add(new int[]{0,0});
        while (!list.isEmpty()){
            int temp[] = list.get(0);
            list.remove(0);
            if (temp[1]>k) break;
            init = Math.max(init,temp[0]);
            for (int i = 1; i <= h; i++) {
                if (map.get(temp[0] + i)!=null && !vis[temp[0] + 2 * i])
                {
                    vis[temp[0] + 2 * i] = true;
                    list.add(new int[]{temp[0], temp[1] + 1});
                }
                if (temp[0] - 2 * i > 0 && map.get(temp[0] - i)!=null && !vis[temp[0] - 2 * i])
                {
                    vis[temp[0] - 2 * i] = true;
                    list.add(new int[]{temp[0] - 2 * i, temp[1] + 1});
                }
            }
        }
        return init;
    }
}
