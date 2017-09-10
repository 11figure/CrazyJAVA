package Chapter5;

/**
 * Created by Administrator on 2017/8/2.
 */

class Animal2{
    private void beat() {
        System.out.println("心脏跳动...");
    }

    public void breath() {
        beat();
        System.out.println("呼吸中...");
    }
}

class Bird {
    //将原来父类组合到原来的子类 ，作为子类的一个组合部分
    private Animal2 a;

    public Bird(Animal2 a) {
        this.a = a;
    }

    public void breath() {
        a.breath();
    }

    public void fly() {
        System.out.println("飞翔中。。。");
    }
}

class Dog {
    private Animal2 a;

    public Dog(Animal2 a) {
        this.a = a;
    }

    public void breath() {
        a.breath();
    }

    public void run() {
        System.out.println("奔跑中。。。");
    }
}

public class CompositeTest {
    public static void main(String[] args) {
        Animal2 a1 =new Animal2();
        Bird b= new Bird(a1);
        b.breath();
        b.fly();

        Animal2 a2 = new Animal2();
        Dog d = new Dog(a2);
        d.breath();
        d.run();
    }
}
