package Chapter5;

import java.io.File;

/**
 * Created by Administrator on 2017/8/17.
 */
public class RecursiveTest {
    public static void main(String[] args) {
        System.out.println(sum(10));
        //File file = new File("R:\\df");
        //deleteFile(file);
        File file1 = new File("R:\\23");
        removeFolder(file1);
    }
    private static int sum(int n){
        if(n==0){
            return 0;
        }else{
            return sum(n-1)+n;
        }
    }
    private static void deleteFile(File f){
        if(f.isFile() || f.list().length==0){
            f.delete();
        }else{
            File[] files = f.listFiles();
            for(File file:files){
                deleteFile(file);
                file.delete();
            }
        }
    }

    private static void removeFolder(File file){
        if(file.isFile() || file.list().length == 0){
            file.delete();
        }else{
            for (File f : file.listFiles()) {
                removeFolder(f);
                f.delete();
            }
            file.delete();
        }
    }
}
