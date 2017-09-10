package Chapter5My;

/**
 * Created by Administrator on 2017/8/28.
 */
public class Son extends Father {
    String name = "Son";
    static String specie = "superMan";
    public Son(String name, int age, String specie) {
        super(name, age);
        this.specie = specie;
    }

    public Son() {
        this("god");
        System.out.println("Son None Pram Cons");
    }
    public Son(String specie) {
        this.specie = specie;
        System.out.println("Son param Constructor");
    }

    void printMyName() {
        System.out.println(name);
    }
    void printFatherName() {
        System.out.println(super.name);
    }
    void walk(){
        System.out.println("Son walk");
    }

    void play() {
        System.out.println("Son play");
    }
    public static void main(String[] args) {
        Son song3 = new Son("sd",23,"Chinese");
        System.out.println("---------------------");
        Son son = new Son("yyy",334);
        System.out.println("---------------------");
        Son son1 = new Son();
        son1.walk();
        System.out.println(son1.age);
        son1.printFatherName();
        son1.printMyName();
        System.out.println(son1.specie);
        Father fa = new Son();
        fa.walk();
        System.out.println(fa.name);
        System.out.println(fa.age);
        //fa.play();
        System.out.println(son1.name instanceof String);
        System.out.println(new Thread() instanceof Runnable);
        //System.out.println(son1.name instanceof Immutable);
        //System.out.println(son1.age instanceof String);
    }
    public Son(String name, int age) {
        this.name = name;
        this.age = age;
        System.out.println("Son 2Param constructor");
    }
}

class Father {
    static String specie = "human";
    String name = "father";
    int age = 232;

    void eat(){
        System.out.println("Father do eat");
    };

    void walk() {
        System.out.println("Father walk");
    }

    public Father() {
        System.out.println("None Param Contructor");
    }

    public Father(String name, int age) {
        this.name = name;
        this.age = age;
        System.out.println("Father Param Constructor");
    }
}

class Daughter {
    String name = "daughter";
    Father fa;
    void dance() {
        System.out.println(this.name +" is dancing");
    }

    void breath() {
        fa.eat();
    }

    void walk() {
        fa.walk();
    }
    public Daughter(Father fa) {
        this.fa = fa;
    }
}