package Chapter6.LambdaTest;

import java.util.Arrays;

/**
 * @Author: LevenLiu
 * @Description:
 * @Date: Create 15:54 2017/9/10
 * @Modified By:
 */
public class LambdaArrays {

    public static void main(String[] args) {
         String[] arr1 = new String[]{"java", "fkava", "fkit", "ios", "android"};
        //用lambda表达式实现Comparator接口，根据字符串的长度来排序
        Arrays.parallelSort(arr1, ((o1, o2) -> o1.length() - o2.length()));
        System.out.println(Arrays.toString(arr1));

        int[] arr2 = new int[]{1, 23, 3, 5, 432, 231};
        Arrays.parallelPrefix(arr2,((o1,o2) -> o1*o2));
        System.out.println(Arrays.toString(arr2));
    }

}
