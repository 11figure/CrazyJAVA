package Chapter4;

import java.util.Scanner;

/**
 * Created by Administrator on 2017/7/31.
 */
public class MathDraw {
    public static void main(String[] args) {
        System.out.println("请输入元的半径");
        Scanner sc =new Scanner(System.in);
        int radius = 0;
        while ((radius = sc.nextInt())>0) {
            paint(radius);
            System.out.println("请输入元的半径(输入0结束）");
        }
    }
    private static void paint(int r){
        //假定园心坐标(r,r)
        int x= 0;
        int y =0;
        int c =0;
        //每行递减，调节屏幕横纵比
        int z = 2;
        for (int i = 0; i < r*2; i+=z) {
            //或与画"*"点的坐标
            x = getX(r,y);
            //1.画y值上左边的点
            System.out.println(getSpace(x) + "*");
            //2.再画圆内的空格；
            c = (r - x) * 2;
            System.out.println(getSpace(c));
            System.out.println("*");
            //每画完一行，y值递增
            y += z;
        }

    }

    /*
    * 根据圆的半径和某点的纵坐标值来改点的横坐标值
    * @param  r圆的半径
    * @param y 圆上某点的纵坐标y
    * @return 返回改点的横坐标x
    * */
    private static int getX(int r,int y) {
        //求指教三角形的长边的长
        int h = y - r;
        //求指教三角形短边的长
        double l = Math.sqrt(r*r - h*h);
        //取x值，用round方法返回最接近的整数；
        return (int)Math.round(r-l);
    }

    /*
    * @param 空格的个数
    * @return 返回i个空格的字符串
    *
    * */
    private static String getSpace(int i) {
        String s = "";
        for (int j = 0; j < i; j++) {
            s += " ";
        }
        return s;
    }

}
