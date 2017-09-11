package Chapter7;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

/**
 * @Author: LevenLiu
 * @Description: java8 predicate 操作
 * @Date: Create 18:07 2017/9/10
 * @Modified By:
 */
public class TestCollection {

    public static void main(String[] args) {
        Collection c = new ArrayList();
        c.add("悟空");
        c.add("fdewe");
        c.add("轻量java");
        c.add("什么乱七八糟的什么乱七八糟的什么乱七八糟的");
        Collection books = new HashSet<>();
        books.add("轻量java");
        books.add("dd");
        c.removeAll(books);
        System.out.println("C集合的元素"+c);
        ArrayList<String> a = new ArrayList();
        a.add("asd");
        a.add("dw");
        System.out.println(a);

        Iterator e = a.iterator();
        while (e.hasNext()) {
            System.out.println(e.next());
        }

        for (Object obj :books
        ) {
            System.out.println(obj);
        }

        //java8 predicate 操作
        c.removeIf(ele -> ((String) ele).length() < 10);
        System.out.println("00000");
        System.out.println(c);
    }
}
