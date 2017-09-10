package Chapter6.interfaceTest;

/**
 * @Author: LevenLiu
 * @Description:
 * @Date: Create 23:24 2017/9/9
 * @Modified By:
 */
public class BetterPrinter extends Printer{
    private String[] printData = new String[MAX_CACHE_LINE * 2];
    private int dataNum = 0;
    @Override
    public void out() {
        while (dataNum > 0) {
            System.out.println("高速打印机正在打印" + printData[0]);
            System.arraycopy(printData,1,printData,0,--dataNum);
        }
    }

    @Override
    public void getData(String msg) {
        if (dataNum >= MAX_CACHE_LINE * 2) {
            System.out.println("输出队列已满，添加失败");
        } else {
            // 把打印数据添加到队列中，已保存数据的数量加1；
            printData[dataNum++] = msg;
        }
    }
}
