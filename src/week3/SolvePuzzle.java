package week3;

public class SolvePuzzle {
    public static void main(String[] args) {
        for (int i=1;i<10;i++){
            for (int j = 0; j < 10; j++) {
                for (int k = 0; k < 10; k++) {
                    for (int l = 1; l < 10; l++) {
                        if ((i*10000+j*1000+k*100+i*10+j)*i==l*100000+l*10000+l*1000+l*100+l*10+l){
                            System.out.println(""+i+j+k+i+j+"*"+i+"="+l+l+l+l+l+l);
                        }
                    }
                }
            }
        }
    }
}
