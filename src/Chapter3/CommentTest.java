package Chapter3;

/**
 * Created by Administrator on 2017/7/23.
 */
public class CommentTest {
    public static void main(String[] args) {
    //
        System.out.println("HelloWorld");
        //System.out.println("被注释")
        double d = 13.4;
        long l = (long)d;
        System.out.println(l);
        Object q = new Integer(5);
        //父类对象 不可以调用孙辈对象方法？没有重写
        //System.out.println(q.shortVlaue());
        Integer c = new Integer(115);
        short a  =  c.shortValue();
        System.out.println(a);
    }
}
