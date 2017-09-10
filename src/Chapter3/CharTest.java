package Chapter3;

/**
 * 字符类型
 * Created by Administrator on 2017/7/23.
 */
public class CharTest {
        public static void main(String[] args) {

            /*
            * 字符常量必须用单引号括起来，Java语言用Unicode编码（16位）作为编码方式。
            * \b 退格符    \u0008
            * \n 换行符    \u000a
            * \r  回车符   \u000d
            * \t 制表符    \u0009
            * 字符常量可以通过单个字符来制定字符常量，转义字符来指定，直接用Unicode编码法
            * */
            //直接单个字符作为字符常量
            char aChar = 'a';
            //使用转义字符
            char enterChar = '\r';
            //直接用0 ～65535之间的数值 16位的无符号整数
            char ch = '\u9999';
            System.out.println(ch);
            //直接将一个char变量当成int类型变量使用
            char zhong = '中';
            int zhongValue = zhong;
            System.out.println(zhongValue);


        }
}
