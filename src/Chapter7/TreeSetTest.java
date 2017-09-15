package Chapter7;

import java.util.TreeSet;

/**
 * @Author: LevenLiu
 * @Description:
 * @Date: Create 22:31 2017/9/13
 * @Modified By:
 */
public class TreeSetTest {

    public static void main(String[] args) {
        TreeSet numTree = new TreeSet();
        numTree.add(11);
        numTree.add(2);
        numTree.add(30);
        numTree.add(30);
        numTree.add(330);
        System.out.println(numTree.first());
        System.out.println(numTree.last());
        System.out.println(numTree.headSet(100));

        TreeSet s = new TreeSet();
        s.add(new T(100));
        s.add(new T(30));
        s.add(new T(20));
        s.add(new T(-10));
        s.add(new T(310));
        s.add(new R(2)); //TreeSet不能加不同类型的数数据？
        System.out.println(s);

        //treeset可以删除没有被修改的元素，被修改后的元素不可修改
    }
}

class T implements Comparable {
    int age;

    public T(int age) {
        this.age = age;
    }
    @Override
    public int compareTo(Object o) {
        if(o instanceof T){
            return this.age > ((T)o).age ? 1:-1;
        }
        return -1;
    }
}
