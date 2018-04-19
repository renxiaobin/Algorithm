import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class SortListCompare {
    public static void main(String[] args) {
        List<Integer> arraylist = new ArrayList<>();
        List<Integer> linkedlist = new LinkedList<>();
        arraylist.add(1);
        arraylist.add(3);
        arraylist.add(5);
        arraylist.add(7);
        arraylist.add(9);
        linkedlist.add(1);
        linkedlist.add(3);
        linkedlist.add(5);
        linkedlist.add(7);
        linkedlist.add(9);

        int count = 100000;
        long start1 = System.currentTimeMillis();
        for (int i = 0; i < count; i++) {
            Collections.sort(arraylist);
        }
        long end1 = System.currentTimeMillis();
        System.out.println(arraylist.toString());
        System.out.println("sort ArrayList: " + (end1 - start1));

        long start2 = System.currentTimeMillis();
        for (int i = 0; i < count; i++) {
            Collections.sort(arraylist);
        }
        long end2 = System.currentTimeMillis();
        System.out.println(linkedlist.toString());
        System.out.println("sort LinkedList: " + (end2 - start2));
    }
}
