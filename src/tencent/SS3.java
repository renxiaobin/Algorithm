package tencent;

import java.util.*;

public class SS3 {
    public static int reward(int x, int y){
        int result = 200 * x + 3 * y;
        return result;
    }

    public static int getMax(List<Integer> list){
        int max = 0;
        int len = list.size();
        for(int i = 0; i < len; i++){
            if(list.get(i) > max){
                max = list.get(i);
            }
        }
        return max;
    }

    public static int getMaxReward(List<Map<Integer,Integer>> mask, int z, int w){

        int len = mask.size();
        int result = 0;
        int max = 0;

        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < len; i++){

            Iterator<Integer> iterator = mask.get(i).keySet().iterator();
            int x = 0;
            while(iterator.hasNext()){
                x = iterator.next();
            }
            int y = mask.get(i).get(x);

            if(x <= z && y <= w){
                result = reward(x, y);
                list.add(result);
                max = getMax(list);
                return max;
            }
        }

        return max;
    }

    public static int maxReward(List<Map<Integer,Integer>> mask,List<Map<Integer,Integer>> machine){
        int len = machine.size();
        int result = 0;
        int sum = 0;

        List<Integer> list = new ArrayList<>();

        for(int i = 0; i < len; i++){
            Iterator<Integer> iterator = mask.get(i).keySet().iterator();
            int z = 0;
            while(iterator.hasNext()){
                z = iterator.next();
            }
            int w = mask.get(i).get(z);

            result = getMaxReward(mask, z, w);
            sum += result;
            list.add(result);
        }
        System.out.println(list.get(0)+" "+sum);
        return sum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long m = scanner.nextLong();

        List<Map<Integer,Integer>> mask = new ArrayList<>();
        List<Map<Integer,Integer>> machine = new ArrayList<>();

        Map<Integer,Integer> maskMap = new HashMap<>();
        Map<Integer,Integer> machineMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int xi = scanner.nextInt();
            int yi = scanner.nextInt();
            machineMap = new HashMap<>();
            machineMap.put(xi,yi);
            machine.add(machineMap);
        }

        for (int i = 0; i < m; i++) {
            int zi = scanner.nextInt();
            int wi = scanner.nextInt();
            maskMap = new HashMap<>();
            maskMap.put(zi,wi);
            mask.add(maskMap);
        }
        maxReward(mask,machine);
        //System.out.println(maxReward(mask,machine));
    }
}
