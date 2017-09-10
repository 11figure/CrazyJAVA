package Chapter6.interfaceTest;

/**
 * @Author: LevenLiu
 * @Description:
 * @Date: Create 18:31 2017/9/9
 * @Modified By:
 */
public interface InterfaceA {
    int PROP_A = 5;
    void testA();
}

interface InterfaceB {
    int PROP_B = 6;
    void test();
}

interface InterfaceC extends InterfaceA, InterfaceB {
    int PROP_C = 7;
    void testC();
}

class TestInterfaceExtends {

    public static void main(String[] args) {
        System.out.println(InterfaceC.PROP_A);
        System.out.println(InterfaceC.PROP_B);
        System.out.println(InterfaceC.PROP_C);
    }

}

class TestIMPL implements InterfaceA, InterfaceB, InterfaceC {


    @Override
    public void testC() {
        System.out.println("A");
    }

    @Override
    public void testA() {
        System.out.println("B");
    }

    @Override
    public void test() {
        System.out.println("C");
    }
}
