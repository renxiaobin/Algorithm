package week2;

public class FIndMidForTwoArray {
    public static void main(String[] args) {
        int a[] = {3,11,18,19,36,98};
        int b[] = {1,2,4,6,8,10};
        int k=2;
        System.out.println(findKth(a,b,0,0,k));
        int result = findMid(a,b);
        System.out.println(result);
    }

    private static int findKth(int[] a, int[] b,int a_start,int b_start,int k) {
        if (a_start>a.length-1) return b[b_start+k-1];
        if (b_start>b.length-1) return a[a_start+k-1];

        if (k==1){
            return a[a_start]>b[b_start]?b[b_start]:a[a_start];
        }
        int a_mid = Integer.MAX_VALUE;
        int b_mid = Integer.MAX_VALUE;
        if (a_start+k/2-1<a.length){
            a_mid=a[a_start+k/2-1];
        }
        if (b_start+k/2-1<b.length){
            b_mid=b[b_start+k/2-1];
        }

        if (a_mid<b_mid){
            return findKth(a,b,a_start+k/2,b_start,k-k/2);
        }else{
            return findKth(a,b,a_start,b_start+k/2,k-k/2);
        }
    }

    public static int findMid(int a[],int b[]){
        int len1 = a.length;
        int len2 = b.length;

        if ((len1+len2)%2!=0){
            return findKth(a,b,0,0,(len1+len2)/2+1);
        }else{
            return (findKth(a,b,0,0,(len1+len2)/2)+findKth(a,b,0,0,(len1+len2)/2+1))/2;
        }
    }
}
