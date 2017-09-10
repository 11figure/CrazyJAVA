package Chapter5;

/**
 * Created by Administrator on 2017/8/2.
 */
public class Recursive {
    private static int getSum(int num){
     if(num>0){
            return num + getSum(num-1);
        }else{
         return 0;
     }
    }


    public static void main(String[] args) {
        System.out.println(getSum(4));
    }
}
