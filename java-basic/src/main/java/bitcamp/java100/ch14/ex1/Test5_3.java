package bitcamp.java100.ch14.ex1;

import java.io.File;
import java.io.FilenameFilter;

public class Test5_3 {

    public static void main(String[] args) {

        class MyFilenameFilter implements FilenameFilter {

            @Override
            public boolean accept(File dir, String name) {
                if (name.startsWith("."))
                    return false;
                else
                    return true;
            }

        }

        File file = new File(".");

        String[] filenames = file.list(new MyFilenameFilter());

        for (String name : filenames) {
            System.out.println(name);
        }
    }

}
