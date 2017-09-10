package Chapter4;


import java.util.Arrays;
import java.util.function.IntBinaryOperator;

/**
 * Created by Administrator on 2017/7/26.
 */
public class ArraysTest2 {
    public static void main(String[] args) {
        int[] arr1 = new int[]{3, -4, 25,16,30,18};
        //对数组进行并发排序
        Arrays.parallelSort(arr1);
        System.out.println(Arrays.toString(arr1));
        int[] arr2 = new int[]{3, -4, 25,16,30,18};
        Arrays.parallelPrefix(arr2, new IntBinaryOperator() {
            //left代表数组中前一个索引处的元素，计算呢第一个元素时，left为1
            //right代表数组当前索引处的元素。
            @Override
            public int applyAsInt(int left, int right) {
                return left * right;
            }
        });
        System.out.println(Arrays.toString(arr2));
        System.out.println(arr2.getClass().toString());

        //Todo 如何转为lamda
        //Arrays.parallelPrefix(
        //        (IntBinaryOperator a) -> {return (int)1*2;},
        //        arr2
        //);
        for (int i = 22; i >= 0; i--) {
            System.out.println(i);
        }
    }
}
