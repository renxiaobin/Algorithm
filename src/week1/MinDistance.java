package week1;

public class MinDistance {

    public static void main(String[] args) {
        int a[] = {1,5,8,11,29,30,60,100};
        cal(a);
    }

    private static void cal(int[] a) {
        int dmin=Integer.MAX_VALUE;
        for (int i = 0; i < a.length; i++) {
            for (int j = i+1; j < a.length; j++) {
                int temp = Math.abs(a[j]-a[i]);
                if (temp <dmin){
                    dmin = temp;
                }
            }
        }
        System.out.println("The min distance of array = [" + dmin + "]");
    }
}
