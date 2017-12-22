package week1;

import java.util.Arrays;

public class LockerDoor {

    public static void cal(int n) {
        int i=1;
        while(i*i<=n){
            System.out.println("The door's number = [" + i*i + "] is open");
            i++;
        }
    }

    public static void val(int n){
        int[] array = new int [n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < array.length; j++) {
                if ((j+1)%(i+1)==0)
                    array[j] = (array[j]==0?1:0);
            }
        }

        System.out.println("array = [" + Arrays.toString(array) + "]");

        for (int k = 0; k < array.length; k++) {
            if (array[k]==1)
                System.out.println("The door number = [" + (k+1) + "] is open");
        }

    }

    public static void main(String[] args) {
        cal(111);
        val(111);
    }
}
