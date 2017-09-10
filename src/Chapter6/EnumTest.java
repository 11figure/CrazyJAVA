package Chapter6;


/**
 * @Author: LevenLiu
 * @Description:
 * @Date: Create 17:02 2017/9/10
 * @Modified By:
 */
public class EnumTest {

    public static void judge(SeasonEnum s) {
        switch (s) {
            case SPRING:
                System.out.println("春天");
                break;
            case SUMMER:
                System.out.println("夏天");
                break;
            case FALL:
                System.out.println("秋天");
                break;
            case WINTER:
                System.out.println("冬天");
                break;
        }
    }

    public static void main(String[] args) {
        for (SeasonEnum s: SeasonEnum.values()
        ) {
            System.out.println(s);
        }
        judge(SeasonEnum.SPRING);
    }
}
