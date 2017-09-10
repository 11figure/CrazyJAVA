package Chapter6.closureTest;

/**
 * @Author: LevenLiu
 * @Description:
 * @Date: Create 0:52 2017/9/10
 * @Modified By:
 */
public class TestClosure {

    public static void main(String[] args) {
        TeacherProgrammer tp = new TeacherProgrammer("李刚");
//        直接调用TeacherProgrammer 类从Programmer 类继承到work方法;
        tp.work();
        //表面上调用的是Closure 的work方法，实际上是调用TeacherProgrammer的Teach方法
        tp.getCallBackReference();
    }

}
