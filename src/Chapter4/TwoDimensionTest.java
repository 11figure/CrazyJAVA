package Chapter4;

/**
 * Created by Administrator on 2017/7/25.
 */
public class TwoDimensionTest {
    public static void main(String[] args) {
        int[][] a;
        a = new int[4][];
        for(int i= 0,len= a.length; i<len;i++) {
            System.out.println(a[i]);
        }
        //初始化数组的第一个元素
        a[0] = new int[2];
        //访问a数组的第一个元素是一位数组，遍历这个一维数组；
        a[0][1] = 6;

        //同时初始化二维数组的两个维度
        int[][] b= new int[3][4];
        //遍历二维数组并输出
        for(int[] i :b){
            for (int j:i){
                System.out.print(j +"");
            }
            System.out.println("");
        }
        //使用静态初始化语法来初始化一个二维数组
        String[][] str1 = new String[][]{new String[3],new String[]{"helloWOrld"}};
        //使用简单的静态初始化语法来初始化二微数组；
        String[][] str2 = {
                new String[3],new String[]{"hello"}
        };

    }
    //
}
