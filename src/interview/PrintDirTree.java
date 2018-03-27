package interview;

import java.io.File;

public class PrintDirTree {
    public static void main(String[] args) {
        File file = new File("/Users/renxiaobin/Documents");
        printTree(file,0);
    }

    private static void printTree(File file, int level) {
        String pre = "";
        for (int i = 0; i < level; i++) {
            pre+="  ";
        }
        System.out.println(pre+file.getName());
        if (file.isDirectory()){
            File childFile[] = file.listFiles();
            for (File f:childFile) {
                if (f.isDirectory())
                    printTree(f,level+1);
            }
        }
    }
}
