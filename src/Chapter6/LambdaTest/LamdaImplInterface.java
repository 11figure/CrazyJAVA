package Chapter6.LambdaTest;

/**
 * @Author: LevenLiu
 * @Description:
 * @Date: Create 17:23 2017/9/10
 * @Modified By:
 */
public class LamdaImplInterface {


}

interface InterfaceTest {
    String out();
//    String cry();
}

class printer {


    public static void main(String[] args) {
        System.out.println(new InterfaceTest(){
            public String out(){
                System.out.println("匿名内部类实现接口实例");
                return "KK";
            }
        }.out());
        //默认的
        InterfaceTest interfaceTest = () -> "使用Lamda 表达式实现接口实例";
        System.out.println(interfaceTest.out());
    }
}