package Chapter6.interfaceTest;

/**
 * @Author: LevenLiu
 * @Description: 业务逻辑作为抽象方法；可以确保 业务逻辑暂时无法确定的，必须到执行该方法时才能确定。
 * @Date: Create 23:37 2017/9/9
 * @Modified By:
 */
public interface Command {
    void process(int[] target);
}

/**
 * 通过Command接口，就实现了让ProcessArray类和具体"处理行为"的分离，程序使用Command接口代表了对数组的处理行为.
 * Command也没有实现真正的处理，只有等到需要调用ProcessArray 对象的 process 方法时，才真正传入一个Command对象，才确定对数组的处理行为
 */
class ProcessArrray {

    public void process(int[] target, Command cmd) {
        cmd.process(target);
    }

}

class PrintCommand implements Command{


    @Override
    public void process(int[] target) {
        for (int item :
            target) {
            System.out.println(item);
        }
    }
}

class TestCommand {

    public static void main(String[] args) {
        ProcessArrray pa = new ProcessArrray();
        int[] target = {3, -4, 6, 4};
        //第一次处理数组，具体初始行为取决于PrintCommand；
        pa.process(target, new PrintCommand());
    }

}