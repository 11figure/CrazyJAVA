package Chapter5;

/**
 * Created by Administrator on 2017/8/2.
 */
public class ConversionTest {
    public static void main(String[] args) {
        double d = 13.4;
        long l = (long)d;
        System.out.println(l);

        int in = 0;
        //boolean b =(boolean)in;

        Object a = "ddd";
        String objStr = (String) a;
        System.out.println(objStr);
        Object objPri = new Integer(6);

        if(objPri instanceof String){
            String str = (String)objPri;
        }else{
            System.out.println("不能强转");
        }
    }
}
