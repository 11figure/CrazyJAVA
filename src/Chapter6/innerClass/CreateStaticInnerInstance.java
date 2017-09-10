package Chapter6.innerClass;

/**
 * @Author: LevenLiu
 * @Description: 在外部类以外使用静态内部类
 * @Date: Create 15:18 2017/9/10
 * @Modified By:
 */
class StaticOut {
    //定义一个静态内部类，不是用访问控制符，即同一个包中的其他类可访问该内部类。
    static class StaticIn {
        public StaticIn() {
            System.out.println("静态内部类的构造器");
        }
    }
}

public class CreateStaticInnerInstance {

    public static void main(String[] args) {
        StaticOut.StaticIn in  = new StaticOut.StaticIn();
//      静态内部类不能直接实例化必须通过外部类.出来。一下编译报错
//        StaticIn in2 = new StaticIn();
        System.out.println("-----------------");
        StaticOut.StaticIn in1;
        in = new StaticOut.StaticIn();
    }
}
