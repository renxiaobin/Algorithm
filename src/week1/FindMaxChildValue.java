package week1;


public class FindMaxChildValue {
    public static void main(String[] args) {
        int a[] = {2,-3,12,-9,10,6,11,-21};
        int result = findSubMax(a,0,a.length-1);
        System.out.println("result = [" + result + "]");

        find(a);
    }

    private static void find(int[] a) {
        int curSum = a[0];
        int maxSum = a[0];
        for (int i = 1; i < a.length - 1; i++) {
            if (curSum<0){
                curSum=0;
            }
            curSum+=a[i];
            if (curSum>maxSum){
                maxSum=curSum;
            }
        }
        System.out.println("maxSum "+maxSum);
    }

    private static int findSubMax(int[] a,int left,int right) {
        if (left<right){
            int mid = (left+right)/2;
            int leftMax = findSubMax(a,left,mid);
            int rightMax = findSubMax(a,mid+1,right);

            int maxL=a[mid],maxR=a[mid+1];
            int sumL=a[mid],sumR=a[mid+1];
            for (int i = mid-1; i >=left ; i--) {
                sumL+=a[i];
                if (sumL>=maxL){
                    maxL=sumL;
                }
            }
            for (int i = mid+2; i < right; i++) {
                sumR+=a[i];
                if (sumR>=maxR){
                    maxR=sumR;
                }
            }
            int midMax = maxL+maxR;
            return Math.max(Math.max(leftMax,rightMax),midMax);
        }else{
            return a[left];
        }
    }
}
