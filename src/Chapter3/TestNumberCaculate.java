package Chapter3;

/**
 * Created by Administrator on 2017/7/25.
 */
public class TestNumberCaculate {
    public static void main(String[] args) {
        float aff = 12.5345f;
        System.out.println(aff+"");
        double i = (int)(Math.random() * 100)/10;
        System.out.println(i);
        String st = "12.46";
        System.out.println(Double.parseDouble(st));
        char  ch= 122;
        System.out.println(ch);
        System.out.println('a' + 7 +"Hello");//104Hello
        System.out.println(7/0.0); //Infinity
        //System.out.println(7/0);    //ArithmeticException: / by zero
        double  d = 1.3;
        double dd = 0.5;
        System.out.println(d%dd); //求余未必为整数 0.30000000000000004

        int a= 1;
        int b=1;
        System.out.println("====================");
        System.out.println(a++ + 1);
        System.out.println(a);
        System.out.println(++b +1);
        System.out.println(b);
        int ad = 1;
        for (int j = 0;j<4;j++) {
            System.out.println(j+"原:"+ad);
            System.out.println(j+"次ad++:"+ad++);
            System.out.println(j+"后i:"+ad);
        }
        int ao = 1;
        System.out.println("-----------------------------");
        for (int q = 0;q<4;++q) {
            System.out.println(q+"原:"+ao);
            System.out.println(q+"次++ao:"+(++ao));
            System.out.println(q+"后i:"+ao);
        }

        byte by=1;
        //byte by2 = by +1; //因为by +1 为int
        by += 1;
        System.out.println(by);

        System.out.println(new Integer(2) == new Integer(2));

        System.out.println("====================");
        String aStr = "Hello";
        String bStr = "Hello";
        System.out.println(aStr == bStr);
    }
    static final Integer[] cache = new Integer[-(-128)+ 127 +1];
    static {
        //执行初始化，创建-128到127的Integer实例，并放入cache数组中
        for(int i=0;i<cache.length;i++)
            cache[i]  = new Integer(i-128);
    }
}
