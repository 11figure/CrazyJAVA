package Chapter4;

import java.util.Arrays;

/**
 * Created by Administrator on 2017/7/25.
 */
public class ArraysTest {
    public static void main(String[] args) {
        int[] a = new int[]{3,4,5,6};
        int[] a2 =new int[]{3,4,5,6};
        //a数组和a2数组的长度相等，每个元素一次项等，将输出true；
        System.out.println(Arrays.equals(a,a2));
        //通过复制a数组，生成一个新的b数组长度为6
        int[] b= Arrays.copyOf(a,6);
        System.out.println(Arrays.equals(a,b));
        int[] c = Arrays.copyOf(a,4);
        System.out.println(Arrays.equals(a,c));
        System.out.println(c.toString());
        //Array的输出方式:
        System.out.println(Arrays.toString(c));
        //将b数组的的第三元素到第五元素赋值为1
        System.out.println(Arrays.toString(b));
        Arrays.fill(b,2,4,1);
        //[3, 4, 1, 1, 0, 0]
        System.out.println(Arrays.toString(b));
        //对数组进行排序
        //Arrays.sort(b);//[0, 0, 1, 1, 3, 4]

        //从下标到下一个下标之间的元素排序
        Arrays.sort(b,1,4);//[3, 1, 1, 4, 0, 0]
        System.out.println(Arrays.toString(b));
        String somealadjal = "diwoele";
        System.out.println(somealadjal);
    }
}
