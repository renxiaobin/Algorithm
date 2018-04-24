package microsoft;

public class Divide {
    public static void main(String[] args) {
        int a=-Integer.MAX_VALUE;
        int b=12000;
        System.out.println(divide(a,b));
    }

    private static int divide(int a, int b) {
        if (b==0)
            throw new RuntimeException("b is not allowed 0");
        if (b==1)
            return a;
        if(b==2)
            return a>>1;
        boolean flag = false;
        int temp_a=a,temp_b=b;
        if(a<0 || b<0){
            if((a>0 && b<0) || (a<0 && b>0))
                flag=true;
            try {
                temp_a=a<0?-a:a;
                temp_b=b<0?-b:b;
                if(temp_a==Integer.MIN_VALUE || temp_b==Integer.MIN_VALUE) {
                    throw new RuntimeException();
                }
            }catch (Exception e){
                System.out.println("out of bounds");
                return 0;
            }
        }
        int count=0;
        while (temp_b<=temp_a){
            int temp=temp_b;
            for (int i = 1; temp_a >= temp; i <<= 1, temp <<= 1)
            {
                temp_a -= temp;
                count += i;
            }
        }
        if(flag)
            count=-count;
        return count;
    }
}
