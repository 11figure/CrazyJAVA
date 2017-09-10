package Chapter5.lamda;

/**
 * Created by Administrator on 2017/8/27.
 */
public class JDK8Test {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Before Java8, too much code for too little to do");
            }
        }).start();
        new Thread(()-> System.out.println("In Java8, Lamda Rocks")).start();
    }
}
