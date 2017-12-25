package week1;

public class CalEqualition {

    public static void cal(double a,double b,double c){
        double m = b*b-4*a*c;
        if (m==0){
            System.out.println("x1=x2=" + (-b/2*a));
        }else if(m>0){
            System.out.println("x1 = " + (-b+Math.sqrt(m))/2*a + ", x2 = " + (-b-Math.sqrt(m))/2*a );
        }else{
            System.out.println("no real number resolution");
        }
    }

    public static void main(String[] args) {
        int a=1,b=-3,c=2;
        cal(a,b,c);

        cal(1,2,1);
    }
}