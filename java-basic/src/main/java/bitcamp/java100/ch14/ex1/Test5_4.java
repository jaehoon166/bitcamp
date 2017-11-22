package bitcamp.java100.ch14.ex1;

import java.io.File;
import java.io.FilenameFilter;

public class Test5_4 {

    public static void main(String[] args) {

        FilenameFilter filter = new FilenameFilter() {

            @Override
            public boolean accept(File dir, String name) {
                if (name.startsWith("."))
                    return true;
                else
                    return false;
            }

        };

        File file = new File(".");

        String[] filenames = file.list(filter);

        for (String name : filenames) {
            System.out.println(name);
        }
    }

}
