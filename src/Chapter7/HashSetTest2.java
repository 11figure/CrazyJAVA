package Chapter7;

import java.util.HashSet;
import java.util.Iterator;

/**
 * @Author: LevenLiu
 * @Description:
 * @Date: Create 19:43 2017/9/10
 * @Modified By:
 */
public class HashSetTest2 {

}

class R implements Comparable{
    int count ;

    public int getCount() {
        return count;
    }

    public R(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "R{" +
            "count=" + count +
            '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof R) {
            return this.count == ((R)o).count;
        }
        return false;
    }

    //    @Override

    /**
     * 不同类型的属性取得hashcode的方式：
     * boolean     hashCode = (f?0:1)
     * 整数类型(byte.short.int.long)    hashcode = (int)(f^(f>>>32));
     * long     hashCode = (int)(f^f(>>>32));
     *
     * @return
     */

    public int hashCode() {
        return this.count;
//        return com.google.common.base.Objects.hashCode(count);
    }

    public static void main(String[] args) {
        R a = new R(100);
        R b = new R(50);
        boolean check = a.equals(b);
        System.out.println(check);

        HashSet<R> hs = new HashSet<>();
        hs.add(new R(10));
        hs.add(new R(23));
        hs.add(new R(23));
        hs.add(new R(-33));
        System.out.println(hs);
        Iterator it = hs.iterator();
        R a1 = (R) it.next();
        hs.add(a1);
        it = hs.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
        hs.remove(a1);
        System.out.println(hs);
    }


    @Override
    public int compareTo(Object o) {
        return 1;
    }
}
