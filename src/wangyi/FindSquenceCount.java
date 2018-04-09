package wangyi;

import java.util.ArrayList;
import java.util.List;

public class FindSquenceCount {
    public static void main(String[] args) {
        String s = "aaaafecdccccbbbbb123243bsdddccbbbasdasdcadasdads";
        System.out.println(cal(s));
    }

    private static int cal(String s) {
        List<Integer> alist = new ArrayList<>();
        List<Integer> blist = new ArrayList<>();
        List<Integer> clist = new ArrayList<>();
        List<Integer> dlist = new ArrayList<>();
        char[] a = s.toCharArray();
        for(int i=0;i<a.length;i++){
            if (a[i]=='a'){
                alist.add(i);
            }else if (a[i]=='b'){
                blist.add(i);
            }else if (a[i]=='c'){
                clist.add(i);
            }else if(a[i]=='d'){
                dlist.add(i);
            }
        }
        int count=0;
        for (int i=dlist.size()-1;i>=0;i--){
            int dindex = dlist.get(i);
            int cindex=clist.size()-1;
            while (cindex>=0){
                if (clist.get(cindex)>=dindex){
                    clist.remove(cindex);
                }else{
                    break;
                }
                cindex--;
            }
            if (cindex<0 || clist.size()==0) break;

            int bindex=blist.size()-1;
            while (bindex>=0){
                if (blist.get(bindex)>=clist.get(cindex)){
                    blist.remove(bindex);
                }else{
                    break;
                }
                bindex--;
            }
            if (bindex<0 || blist.size()==0) break;

            int aindex=alist.size()-1;
            while (aindex>=0){
                if (alist.get(aindex)>=blist.get(bindex)){
                    alist.remove(aindex);
                }else{
                    break;
                }
                aindex--;
            }
            if (aindex<0 || alist.size()==0) {
                break;
            }else {
                clist.remove(cindex);
                blist.remove(bindex);
                alist.remove(aindex);
                count++;
            }
        }
        return count;
    }
}
