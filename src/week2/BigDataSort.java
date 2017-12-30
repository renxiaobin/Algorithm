package week2;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BigDataSort {
    public static void main(String[] args) throws IOException {
        String path = "data.txt";
        //generate(path);
        bigSort(path);
    }

    private static void bigSort(String path) throws IOException {
        ArrayList list = new ArrayList();

        File file = new File(path);
        BufferedReader br = new BufferedReader(new FileReader(file));

        StringBuffer buffer = new StringBuffer();
        String line;
        int splitCount = 50000;
        int i=0;
        while ((line=br.readLine())!=null){
            buffer.append(line+" ");
            i++;
            if (i%splitCount==0){
                List<Integer> tempList = Arrays.stream(sortBuffer(buffer)).boxed().collect(Collectors.toList());
                //pretend to write in filesystem as small file
                list.add(tempList);
                buffer.setLength(0);
            }
        }
        br.close();

        System.out.println("split sort completed");
        mergedSorted(list);
    }

    private static void mergedSorted(List<List<Integer>> list) throws IOException {
        File file = new File("result.txt");
        BufferedWriter br = new BufferedWriter(new FileWriter(file));

        int minNum[] = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            minNum[i]=list.get(i).get(0);
            list.get(i).remove(0);
        }

        System.out.println("start merge");
        while(true){
            int minIndex = min(minNum);
            br.write(minNum[minIndex]+"\n");
            if (list.get(minIndex).size()!=0) {
                minNum[minIndex] = list.get(minIndex).get(0);
                list.get(minIndex).remove(0);
            }else{
                minNum[minIndex]=Integer.MAX_VALUE;
            }
            boolean tag=false;
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).size()!=0){
                    tag=true;
                    break;
                }
            }
            if (!tag){
                Arrays.sort(minNum);
                for (int i = 0; i < minNum.length; i++) {
                    if (minNum[i]!=Integer.MAX_VALUE){
                        br.write(minNum[i]+"\n");
                    }
                }
                break;
            }

        }
        br.flush();
        br.close();
    }

    private static int min(int[] minNum) {
        int temp = minNum[0];
        int index=0;
        for (int i = 1; i < minNum.length; i++) {
            if (minNum[i]<temp){
                temp=minNum[i];
                index=i;
            }
        }
        return index;
    }

    private static int[] sortBuffer(StringBuffer buffer) {
        String[] numberTexts = buffer.toString().split(" ");
        buffer.setLength(0);
        int[] numbers = new int[numberTexts.length];
        for (int i = 0; i < numberTexts.length; i++) {
            numbers[i] = Integer.parseInt(numberTexts[i]);
        }

        Arrays.sort(numbers);
        return numbers;
//        for (int i = 0; i < numbers.length; i++) {
//            buffer.append(numbers[i] + "\n");
//        }

    }

    private static void generate(String path) throws IOException {
        File file = new File(path);
        if (file.exists()){
            file.delete();
        }
        BufferedWriter bw = new BufferedWriter(new FileWriter(file));

        for (int i = 1000000; i >0 ; i--) {
            bw.write(i+"\n");
            if (i%1000==0){
                System.out.println(i);
            }
        }
        bw.flush();
        bw.close();
    }

}
