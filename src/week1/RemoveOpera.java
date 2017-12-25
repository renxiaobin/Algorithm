package week1;

public class RemoveOpera {
    public static void main(String[] args) {
        int a[] = {1,2,3,4,5,6};
        //removeIndex1(a,3);
        removeIndex2(a,3);
    }

    public static void removeIndex1(int[] a, int i){
        a[i] = a[a.length-1];
        for (int j = 0; j < a.length-1; j++) {
            System.out.println("a[" + j + "]= [" + a[j] + "]");
        }
    }

    public static void removeIndex2(int[] a,int i){
        int markIndex = i;
        for (int j = 0; j < a.length; j++) {
            if (j!=3) {
                System.out.println("a[" + j + "]= [" + a[j] + "]");
            }
        }
    }
}
