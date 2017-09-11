package Chapter7;

import java.util.stream.IntStream;

/**
 * @Author: LevenLiu
 * @Description:
 * @Date: Create 18:38 2017/9/10
 * @Modified By:
 */

public class IntStreamTest {

    public static void main(String[] args) {
        IntStream intStream = IntStream.builder()
            .add(20)
            .add(30)
            .add(23)
            .add(389)
            .build();
        //下面调用集聚方法的代码每次只能执行一次
        System.out.println("intStream 所有元素的最大值" + intStream.max().getAsInt());
        System.out.println("intStream 所有元素的最小值" + intStream.min().getAsInt());
        System.out.println("intstream  所有元素的综合" + intStream.sum());
        System.out.println("intstream  所有元素的平均值" + intStream.average());
        System.out.println("intstream  所有元素的平方和是否都大于20" + intStream.allMatch(ele -> ele * ele > 20));
        System.out
            .println("intstream  是否包含任意元素的平方大于20" + intStream.anyMatch(ele -> ele * ele > 20));
        IntStream newIs = intStream.map(ele -> ele * 2 + 1);
        newIs.forEach(System.out::println);
    }
}
