package Chapter7.jvmTest;

/**
 * @Author: LevenLiu
 * @Description:
 * @Date: Create 22:28 2017/9/11
 * @Modified By:
 */
public class StringIntern {

    public static void main(String[] args) {
        String str = "1";
        String str1 = new String("1");
        String str2 = new String("1");

        System.out.println(str == str1);
        System.out.println(str == str2);
        System.out.println("========================");

        str1.intern();
        str2 = str2.intern();
        System.out.println(str == str1);
        System.out.println(str == str1.intern());
        System.out.println(str == str2);
    }

}
