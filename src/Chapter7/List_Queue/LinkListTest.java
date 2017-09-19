package Chapter7.List_Queue;

import java.util.LinkedList;

/**
 * @Author: LevenLiu
 * @Description:
 * @Date: Create 1:55 2017/9/16
 * @Modified By:
 */
public class LinkListTest {

    public static void main(String[] args) {
        //用
        LinkedList linkedList = new LinkedList();
//        将字符串加入尾部
        linkedList.add("233");
        linkedList.add("wew");
        linkedList.add("llzo");
        System.out.println(linkedList);
        //将字符串加入头部 模拟入栈
        linkedList.push("zzzzz");
        System.out.println(linkedList);
        //将字符串从头部删除；  模拟堆出栈
        System.out.println(linkedList.pop());
        System.out.println(linkedList);

        System.out.println( linkedList.peekFirst());
        System.out.println( linkedList.peekLast());
    }
}
