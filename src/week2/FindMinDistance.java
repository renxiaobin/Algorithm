package week2;

public class FindMinDistance {
    public static void main(String[] args) {
        int a[] = {11,8,10,36,98,100,1,3,2};
        cal(a);

        QuickSort.sort(a);
        presortCal(a);
    }

    private static void presortCal(int[] a) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < a.length-1; i++) {
            int temp = Math.abs(a[i+1]-a[i]);
            if (temp<min){
                min=temp;
            }
        }
        System.out.println(min);
    }

    private static void cal(int[] a) {
        int min=Integer.MAX_VALUE;
        for (int i = 0; i < a.length-1; i++) {
            for (int j = i+1; j < a.length; j++) {
                int temp = Math.abs(a[j]-a[i]);
                if (temp<min){
                    min=temp;
                }
            }
        }
        System.out.println(min);
    }
}
