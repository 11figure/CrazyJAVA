package Chapter4;

/**
 * Created by Administrator on 2017/7/25.
 */
public class SwitchTest {
    public static void main(String[] args) {
        char score = 'c';
        switch (score) {
            case 'A':
                System.out.println("优秀");
                break;
            case 'B':
                System.out.println("良好");
            case 'C':
                System.out.println("及格");
            case 'D':
                System.out.println("不及格");
            default:
                System.out.println("default");

        }
    }
}
