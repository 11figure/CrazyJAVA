package Chapter4;

/**
 * Created by Administrator on 2017/7/30.
 */
public class TestReferenceArray {
    public static void main(String[] args) {
        Person[] student = new Person[2];
        Person zhang = new Person();
        zhang.age = 12;
        zhang.height = 12.4f;
        Person hon = new Person();
        hon.age = 232;
        hon.height = 123.5f;
        student[0] = zhang;
        student[1] = hon;
        hon.info();
        student[1].info();
    }
}
