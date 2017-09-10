package Chapter6.interfaceTest;

/**
 * @Author: LevenLiu
 * @Description:  定义接口属性而不是实现类属性的好处：
 *                我们把所有生成Output对象的逻辑在工厂类中管理， 而所有需要使用Output对象的类只需与Output接口耦合，而不是与具体实现类耦合。
 * @Date: Create 23:18 2017/9/9
 * @Modified By:
 */
public class OutputFactory {

    public Output getOutput() {
//        return new Printer();
        return new BetterPrinter();
    }

    public static void main(String[] args) {
        Computer computer = new Computer(new OutputFactory().getOutput());
        computer.keyIn("Java");
        computer.keyIn("Python");
        computer.print();
    }
}
