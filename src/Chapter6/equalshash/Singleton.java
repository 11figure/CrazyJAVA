package Chapter6.equalshash;

/**
 * Created by Administrator on 2017/8/29.
 */
public class Singleton {
    private static Singleton instance;
//将构造器使用private 修饰；隐藏该构造器
    private  Singleton() {}
    public static Singleton getInstance() {
        if (instance == null) {
            instance  = new Singleton();
        }
        return instance;
    }
}
