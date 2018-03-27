package interview;

public class StringPermutation {
    public static void main(String[] args) {
        String a = "abb";
        permutation(0,a.toCharArray());
    }

    private static void permutation(int n,char a[]) {
        if (n==a.length-1){
            System.out.println(new String(a));
        }else{
            for (int i = n; i < a.length; i++) {
                if (isSwap(a,i,n)) {
                    swap(n, a, i);
                    permutation(n + 1, a);
                    swap(n, a, i);
                }
            }
        }

    }

    private static boolean isSwap(char[] a, int n, int i) {
        for (int j = i; j < n; j++) {
            if (a[j]==a[n])
                return false;
        }
        return true;
    }

    private static void swap(int n, char[] a, int i) {
        char temp;
        temp = a[i];
        a[i]=a[n];
        a[n]=temp;
    }
}
