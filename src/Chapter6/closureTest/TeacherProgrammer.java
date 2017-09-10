package Chapter6.closureTest;

/**
 * @Author: LevenLiu
 * @Description:
 * @Date: Create 0:46 2017/9/10
 * @Modified By:
 */
public class TeacherProgrammer extends  Programmer{

    public TeacherProgrammer() {
    }

    public TeacherProgrammer(String name) {
        super(name);
    }

    //教学工作依然有TeachableProgrammer类定义
    private void teach() {
        System.out.println(getName() + "教师讲课");
    }

    private class Closure implements Teachable {
        /*
        非静态内部类回调外部类实现work方法，非静态内部类应用的作用仅仅是向
        客户类提供一个回调外部类的途径。
         */
        @Override
        public void work() {
           teach();
        }
    }

    public Teachable getCallBackReference() {
        return new Closure();
    }

}
