package Chapter4;

/**
 * Created by Administrator on 2017/7/25.
 */
public class ArrayInRam {
    public static void main(String[] args) {
        int[] a = {3,7,20};
        int[] b = new int[4];
        //输出的长度
        System.out.println( a.length);
        for(int bb:b) {
            System.out.println(bb);
        }
        b = a ;
        System.out.println(b.length);
    }
}
