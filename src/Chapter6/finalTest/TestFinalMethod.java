package Chapter6.finalTest;

/**
 * Created by Administrator on 2017/8/31.
 */
public class TestFinalMethod {
    private final void test(){}

}

class Sub extends TestFinalMethod {
    void test(){}
}

final class FinalC {
    public static void main(String[] args) {
        String a ;
    }
}
//class SubFin extends FinalC{
//
//}