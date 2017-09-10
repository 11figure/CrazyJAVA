package Chapter5;

/**
 * Created by Administrator on 2017/8/18.
 */
public class Person {
    /*
    * 每一个类都有自己的构造器
    * 当程序员调用构造器时，系统会纤维该对象分配内存空间，并未这个对戏那个执行默认初始化
    * ，这个对象已经产生了，--这些操作都在构造器执行之前就完成了，也就是说，当系统开始执行狗仔其的执行体之前，系统已经创建了一个对象，
    * 只是这个对戏那个还不能被外部程序访问，只能在该构造器中通过this来应用他。
    * 当构造器的执行体执行结束后，这个对象作为构造器的返回值被返回，通常还会付给另一个引用类型的变量，从而让外部程序可以访问该对象。
    *
    * 通常建议为Java类保留无参构造器，在java类中新建了有参构造器后，最好额外建一个无参构造器。
    *
    * */
    //一旦程序员提供了自定义的构造器，则系统不再提供默认的构造器
    private int age;
    private  String name;
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age > 100) {
            age = 100;
        } else {
            this.age = age;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        Person p = new Person("d",10);
        p.age = 1000;
        //p.setAge(100);
        System.out.println(p.getAge());
    }
}
