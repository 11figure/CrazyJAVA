package Chapter6.innerClass;

/**
 * @Author: LevenLiu
 * @Description:
 * @Date: Create 0:22 2017/9/10
 * @Modified By:
 */
public  class TestStaticInnerClass {
    private int prop1 = 5;
    private static int prop2 = 9;
    static class StaticInnerClass{
        private static int age;
        private String name;
        public StaticInnerClass(String name) {
            this.name = name;
        }
    }

}
