package bitcamp.java100.ch14.ex1;

import java.io.File;

public class Test11 {

    public static void main(String[] args) throws Exception {
        File file = new File(".");
                printFiles(file);
    }

    static void printFiles(File dir) throws Exception {
        File[] files = dir.listFiles();

        for (File f : files) {
            if(f.isFile() && f.getName().endsWith(".class")) {
            System.out.println(f.getName());
            }
            if (f.isDirectory()) {
                printFiles(f);
            }
        }
    }
}
