package week1;

public class FindMax {
    public static void main(String[] args) {
        int a[] = {1,22,33,12,43,53,100,22};
        System.out.println(findMax(a));

        System.out.println(isUnique(a));
    }

    private static boolean isUnique(int[] a) {
        for (int i = 0; i <a.length-1 ; i++) {
            for (int j = i+1; j <a.length ; j++) {
                if(a[i]==a[j]){
                    return false;
                }
            }
        }
        return true;
    }

    private static int findMax(int[] a) {
        int max = a[0];
        for (int i = 1; i <a.length ; i++) {
            if (a[i]>max){
                max = a[i];
            }
        }
        return max;
    }


}
