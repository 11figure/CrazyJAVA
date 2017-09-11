package Chapter7;

import java.util.HashSet;
import java.util.Objects;

/**
 * @Author: LevenLiu
 * @Description:
 * @Date: Create 19:31 2017/9/10
 * @Modified By:
 */
public class HashSetTest {

    public static void main(String[] args) {
        HashSet books = new HashSet();
        books.add(new A());
        books.add(new A());
        books.add(new B());
        books.add(new B());
        books.add(new C());
        books.add(new C());
        System.out.println(books);
    }
}

class A {

    /**
     * 类A的equals方法总是返回true，但是没有重写其hashCode() 方法；
     * @param objects
     * @return
     */
    public boolean equals(Objects objects) {
        return true;
    }
}

class B {

    /**
     * 类的hashCode()方法总是返回1，但是没有重写其equals方法
     * @return
     */
    public int hashCode() {
        return 1;
    }

}

class C {

    /**
     * 类C的hashCode() 方法总是返回2，且重写其equals方法总是返回true；所以C实例在hashSet中只能存一个；
     * @return
     */
    public int hashCode() {
        return 2;
    }

    public boolean equals(Object object) {
        return true;
    }
}

