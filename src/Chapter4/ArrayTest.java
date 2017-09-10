package Chapter4;

/**
 * Created by Administrator on 2017/7/30.
 */
public class ArrayTest {
    //    定义一个int数组类型的变量
    public static void main(String[] args) {
        //定义一个数组
        int[] intArr;
        //使用静态初始化，指定数组元素的值，不指定数组长度
        intArr = new int[]{5,6,7,8};

        //定义一个Object数组类型的比纳凉
        Object[] objArr;
        objArr = new Integer[]{1,2,3};
        objArr = new String[]{"1","2","3"};
        System.out.println(objArr[1]);
        objArr[0] = "Spring";

        //数组定义和初始化同时完成；
        int[] a = {5,6,7,8};
        int[] aa=new int[]{5,6,7,8};
        //System.out.println(Arrays.equals(a,aa));
        for (int i:a) {
            System.out.println(i);
        }

        //动态初始化
        String[] books = new String[4];
        //foreach循环
        for(String book:books){
            System.out.println(book);
        }
    }
}
