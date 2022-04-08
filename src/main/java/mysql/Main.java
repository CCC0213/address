package mysql;

import java.io.File;
import java.io.IOException;

/**
 * Learn Java from https://www.liaoxuefeng.com/
 *
 * @author liaoxuefeng
 */
public class Main {

    public static void main(String[] args) throws IOException {
        /*File currentDir = new File("D:\\bonc\\program\\learn-java\\practices");
        listDir(currentDir.getCanonicalFile());*/
        String path="D:\\bonc\\program\\learn-java\\practices";
        findall(path);
        
    }

    static void findall(String path){
        File fs =new File(path);
        if (fs.isDirectory()) {
            File[] f =fs.listFiles();
            if (f !=null) {
                for (File a:f) {
                    if (a.isDirectory()) {
                        findall(a.getPath());
                    }else{
                        System.out.println(a.getPath());
                    }
                }
            }

        }
    }

}
