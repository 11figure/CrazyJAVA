package Chapter3;

/**
 * Created by Administrator on 2017/7/23.
 */
public class TestNumLength {
    public static void main(String[] args) {
        /*
        *  基本类型 :
        *  整数类型：byte short int long
        *  字符类型:char
        *  浮点类型:float double
        *  布尔类型:boolean
        */
        // char
        Short a = -128;
        System.out.println(a-1);
        byte byte1 = -128;
        System.out.println("最小byte-1 =最大byte" + (byte)(byte1-1));
        double short1 = -32768;
        double short2 = -32767;
        Short Short1 = new Short("1");
        System.out.println(Short1.MAX_VALUE);
        System.out.println("最大的short="+short1);
        System.out.println("(short)(short1+1)= " + (short)(short1+1));
        System.out.println("最小的short=" +short2);
        System.out.println("最小short-1 ：" +"(short)(short2 - 1) = " +(short)(short2 - 1));
        long big = 123;
        System.out.println(big);
        //8进制的整数常量以0开头
        int  octalValue = 013;
        System.out.println(new Integer(octalValue).toString());
        //16进制整数以0X或者0x开头
        int hexValue1 = 0x13;
        System.out.println(hexValue1);
        int hexValue2 = 0xaF;
        System.out.println(hexValue2);

    //    double 类型
        float af = 5.32255152f;
        double ad = 0.0;
        double c=Double.POSITIVE_INFINITY;
        double d = Float.POSITIVE_INFINITY;
        System.out.println(c==d);
        System.out.println(ad/ad);
        System.out.println(ad/ad == Float.NaN);
        System.out.println(6.0/ad == 4/ad);
        System.out.println(-8/ad);
        System.out.println(ad/ad);
    }

}
