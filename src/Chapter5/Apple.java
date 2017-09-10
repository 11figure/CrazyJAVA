package Chapter5;

/**
 * Created by Administrator on 2017/8/18.
 */
public class Apple {
    public String nam;
    public String color;
    public double weight;

    public Apple() {

    }

    public Apple(String color, String nam) {
        this.color = color;
        this.nam = nam;
    }

    /*
    一个构造器覆盖另一个构造器，则可以用这种方式来调用因一个重载的构造器
     */
    public Apple(String nam, String color, double weight) {
        this(nam,color);
        this.weight = weight;
    }
    int addTT() {
        this.color = "dada";
        System.out.println(this.color);
        return 12;
    }
}
class b extends Apple{

    /*
    * 方法重写要遵从“两同两小一大”的原则：
    * 相同方法名，形参列表相同，子类返回类型小于父类返回类型，
    * 子类方法抛出的异常要比父类更小或者相同
    * 子类的方法的访问权限大于父类。
    * */
    @Override
    int addTT() {
        return super.addTT();
    }

    //子类的方法中无法访问父类的重写方法,如果要访问,可以用super关键字.
    //引用变量在编译阶段只能调用其编译时类型所具有的方法,但运行时则执行它运行时类型所具有的方法.
    /*
    *因此，编写java代码时，引用变量只能调用声明该变量是所用的类里的方法，Object a = new People();
    *a只能调用Objcet方法。
    *与方法不同的是，对象的属性不具备多态性：

    * */
    

}