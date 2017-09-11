package Chapter7;

/**
 * @Author: LevenLiu
 * @Description:
 * @Date: Create 19:43 2017/9/10
 * @Modified By:
 */
public class HashSetTest2 {

}

class R {
    int count ;

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
        if (this == o) {
            return true;
        }
        if (!(o instanceof R)) {
            return false;
        }
        R r = (R) o;
        return count == r.count;
    }

//    @Override
//    public int hashCode() {
//        return com.google.common.base.Objects.hashCode(count);
//    }
}
