package files;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author lh
 */
public class PathInfo {
    static void show(String id,Object p) {
        System.out.println(id + ": " + p);
    }

    static void info(Path p){
        show("toString",p);
        show("Exists", Files.exists(p));
        show("RegularFile",Files.isRegularFile(p));
        show("Directory",Files.isDirectory(p));
        show("Absolute",p.isAbsolute());
        show("FileName",p.getFileName());
        show("Parent",p.getParent());
        show("Root",p.getRoot());
        System.out.println("********************");
    }

    public static void main(String[] args) {
        System.out.println(System.getProperty("os.name"));
        info(Paths.get("NoFile.txt"));
        Path ap =Paths.get("java-base","book","on-java","src","main","java","files","PathInfo.java");
        info(ap);
        info(ap.getParent());
        try {
            info(ap.toRealPath());
        } catch (IOException e) {
            System.out.println(e);
        }

        URI u = ap.toUri();
        System.out.println("URI: " + u);

        Path puri = Paths.get(u);
        System.out.println(Files.exists(puri));
        File f = ap.toFile();
    }
}
