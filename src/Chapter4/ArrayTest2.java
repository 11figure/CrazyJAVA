package Chapter4;

/**
 * Created by Administrator on 2017/7/30.
 */
public class ArrayTest2 {
    public static void main(String[] args) {
        int[] a = {1, 3, 5};
        int[] b = {2, 4, 6, 7};
        int length = b.length;
        System.out.println(length);
        //由于两个数组元素类型相同 所以可以将a 的值付给b
        //也就是让b引用指向a引用的数组
        b = a;
        //再次输出b数组的长度。
        System.out.println("b数组的长度为:" + length);
    }
}
