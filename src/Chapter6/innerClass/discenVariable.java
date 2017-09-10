package Chapter6.innerClass;

/**
 * @Author: LevenLiu
 * @Description: 非静态内部类对象可以访问外部类的private成员， 但反过来就不行
 * @Date: Create 0:01 2017/9/10
 * @Modified By:
 */
public class discenVariable {

    private String prop = "外部类属性";

    /**
     * 非静态内部类对象必须寄存在外部类对象里，而外部类对象则不必一定有非静态内部类对象寄存在其中。
     * 所以 当外部类对象访问非静态内部类成员时，可能非静态普通内部类对象根本不存在。
     *
     */
    private class InClass {

        private String prop = "内部类属性";

        public void info() {
            String prop = "局部变量";
            //通过外部类类名.this.varName  访问外部类实例属性
            System.out.println(discenVariable.this.prop);
            //通过this访问内部类实例的属性
            System.out.println(this.prop);
            //直接访问局部变量
            System.out.println(prop);

            /*
            一下三个都会编译报错
             */
//            private static String name = "inClass";
//            static{
//                System.out.println("静态内部类静态代码块编译报错");
//            }
//            private static void test(){};
        }
    }

    public void test() {
        InClass in = new InClass();
        in.info();
    }

    public void accessInClassProp() {
        System.out.println("内部类prop属性值" + new InClass().prop);
    }

    public static void main(String[] args) {
        new discenVariable().test();
        //这个会编译报错
        /**
         * 根据静态成员不能访问非静态成员的规则，外部类的静态方法，静态代码块不能访问非静态内部类。
         */
//        InClass in = new InClass();
    }
}
