package Chapter7;

import java.util.Arrays;
import java.util.function.IntBinaryOperator;

/**
 * @Author: LevenLiu
 * @Description:
 * @Date: Create 0:25 2017/9/16
 * @Modified By:
 */
public class ArrayInRam {

    public static void main(String[] args) {
        int[] a = {3, 22, 34,232,100};
        int[] b = new int[4];
        System.out.println(b.length);
        for (int bb : b) {
            System.out.println(bb);
        }
        b= a;
        System.out.println(b.length);
        System.out.println(a);
        Arrays.parallelPrefix(a, (x,y) ->x+y);

        Arrays.parallelPrefix(a, new IntBinaryOperator() {
            @Override
            public int applyAsInt(int left, int right) {
                return left + right;
            }
        });
        System.out.println(Arrays.toString(a));
        int testLoop = 1;
        do {
            testLoop++;
        } while (testLoop <10);
        System.out.println(testLoop);
    }
}
