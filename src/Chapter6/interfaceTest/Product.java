package Chapter6.interfaceTest;


/**
 * @Author: LevenLiu
 * @Description: 先进先出带容量的容器  相当于能打50行的打印纸
 * @Date: Create 18:39 2017/9/9
 * @Modified By:
 */
public interface Product {
    int getProducedTime();
}

interface Output {
    int MAX_CACHE_LINE = 50;
    void out();
    void getData(String msg);
}
class Printer implements  Product,Output {
    private String[] printData = new String[MAX_CACHE_LINE];
    private int dataNum = 0;

    @Override
    public int getProducedTime() {
        return 45;
    }

    @Override
    public void out() {
        //只要还有作业就继续打印
        while (dataNum > 0) {
            System.out.println("打印机在打印"+printData[0]);
            System.arraycopy(printData,1,printData,0,--dataNum);
        }
    }

    @Override
    public void getData(String msg) {
        if (dataNum >= MAX_CACHE_LINE) {
            System.out.println("输出队列已满，添加失败");
        } else {
            printData[dataNum++] = msg;
        }
    }

    /**
     * 实现接口方法时，必须使用public访问控制权限 ，因为接口里的方法都是public的，而子类（相当于实现类）重写父类方法时，
     * 访问权限只能更大或者相等；所以实现类实现接口里的方法
     * @param args
     */
    public static void main(String[] args) {
        Output o = new Printer();
        o.getData("java");
        o.getData("Python");
        o.out();//打印出最先输入的
        o.getData("设计");
        o.getData("数据");
        o.out();
        Product p  = new Printer();
        System.out.println(p.getProducedTime());
        //所有接口
    }
}



