package Chapter4;

/**
 * Created by Administrator on 2017/7/31.
 */
public class ex1 {
    public static void main(String[] args) {
        for(int i = 1;i<10;i++) {
            for(int j = 1;j <= i;j++){
                System.out.print(i +"*" +j + "=" +(i*j)+ "         ");
            }
            System.out.println("");
        }
    }
}