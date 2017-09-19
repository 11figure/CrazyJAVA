package Chapter7.List_Queue;

import java.util.ArrayDeque;
import java.util.PriorityQueue;

/**
 * @Author: LevenLiu
 * @Description:
 * @Date: Create 0:44 2017/9/16
 * @Modified By:
 */
public class PriorityQueueTest {

    public static void main(String[] args) {
        PriorityQueue pq = new java.util.PriorityQueue();
        //下面代码一次同pq中加入四个元素
        pq.offer(6);
        pq.offer(-3);
        pq.offer(123);
        //自动调用compare 方法进行排序
        System.out.println(pq);

        //ArrayDequeQueue
        ArrayDeque queue = new ArrayDeque();
        queue.offer("设计");
        queue.offer("design");
        queue.offer("设计中的设计");
        System.out.println(queue);
        System.out.println(queue.peek());
        System.out.println(queue);
        System.out.println(queue.poll());
        System.out.println(queue);
    }

}
