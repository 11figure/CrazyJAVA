package Chapter6.interfaceTest;

/**
 * @Author: LevenLiu
 * @Description:
 * @Date: Create 23:18 2017/9/9
 * @Modified By:
 */
public class Computer {
    private Output out;

    public Computer(Output out) {
        this.out= out;
    }

    public void keyIn(String msg) {
        out.getData(msg);
    }

    public void print() {
        out.out();
    }
}

