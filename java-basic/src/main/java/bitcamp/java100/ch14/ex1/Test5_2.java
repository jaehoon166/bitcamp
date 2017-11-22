package bitcamp.java100.ch14.ex1;

import java.io.File;
import java.io.FilenameFilter;

public class Test5_2 {

    static class MyFilenameFilter implements FilenameFilter {

        @Override
        public boolean accept(File dir, String name) {
            File file = new File(dir, name);
            if (file.isDirectory())
                return false;
            else
                return true;
        }

    }

    public static void main(String[] args) {
        File file = new File(".");

        String[] filenames = file.list(new MyFilenameFilter());

        for (String name : filenames) {
            System.out.println(name);
        }
    }

}
