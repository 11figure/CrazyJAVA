package Chapter5;

/**
 * Created by Administrator on 2017/8/19.
 * 计算1 -2 +3 +-4+ 5- 6 + 7 - 8 + 9的值
 */
public class RecursiveCaculate {
    public static void main(String[] args) {
        System.out.println(proceesee(9));
    }
    private static int proceesee(int a){
        if(a==1){
            return 1;
        }
        int ca=1;
        if(a%2==0){
            ca = -1;
        }
        if(a%2==1){
            ca = 1;
        }
        return proceesee(a-1)+ca*a;
    }
}
