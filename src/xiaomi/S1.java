package xiaomi;

public class S1 {
    public static void main(String[] args) {
        int a[] = {4, 5, 6, 7, 8, 9, 1, 2, 3};
        int start = 0;
        int end = a.length - 1;
        int mid = 0;
        while (start < end) {
            mid = (start + end) / 2;
            if (a[mid] > a[end]) {
                start = mid + 1;
            } else if (a[mid] < a[start]) {
                end = mid;
            }
        }
        System.out.println(start);
    }
}
