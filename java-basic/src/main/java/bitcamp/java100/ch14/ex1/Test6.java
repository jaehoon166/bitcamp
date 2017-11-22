package bitcamp.java100.ch14.ex1;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Date;

public class Test6 {

    public static void main(String[] args) {

        File file = new File(".");

        File[] files = file.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                if (name.startsWith("."))
                    return false;
                else
                    return true;
            }
        });

        for (File f : files) {
            System.out.printf("%s %10d %s %S\n", f.isDirectory() ? "d" : "-", f.length(),
                    new Date(f.lastModified()).toString(), f.getName());
        }
    }

}
