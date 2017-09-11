package Chapter7;

import java.io.IOException;

/**
 * @Author: LevenLiu
 * @Description:
 * @Date: Create 17:41 2017/9/10
 * @Modified By:
 */
public class ExecTest {

    public static void main(String[] args) {
        Runtime rt = Runtime.getRuntime();
        try {
            rt.exec("java -version");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
