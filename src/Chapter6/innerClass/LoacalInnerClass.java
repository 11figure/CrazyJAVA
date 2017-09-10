package Chapter6.innerClass;

/**
 * @Author: LevenLiu
 * @Description:
 * @Date: Create 15:25 2017/9/10
 * @Modified By:
 */
public class LoacalInnerClass {

    public static void main(String[] args) {
        //定义局部内部类
        class InnerBase {

            int a;
        }
        //定义局部内部类的子类
        class InnerSub extends InnerBase {
            int b;
        }
        //创建局部内部类的对象
        InnerBase innerBase = new InnerSub();
        innerBase.a = 5;
//        innerBase.b = 6;  //编译失败
        InnerSub innerSub = new InnerSub();
        innerSub.a = 6;
        innerSub.b  = 10;
        System.out.println("InnerSub a:" + innerSub.a);
        System.out.println("InnerSub b:" + innerSub.b);
    }

}
