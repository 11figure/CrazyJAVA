package Chapter6.abstractTest;

/**
 * Created by Administrator on 2017/9/1.
 */
public abstract class Shape {
    private String color;
    public static String height = "123";

    public String getHeight() {
        return height;
    }

    public abstract double calPerimeter();
    public abstract String getType();
    //定义Shape的构造器，该构造器并不是用于创建Shape对象，而是用于被子类调用
    public Shape(){}

    public Shape(String color) {
        System.out.println("执行Shape 的构造器");
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public abstract String doSomething();
    //{
    //    System.out.println("dd");
    //    return "dls";
    //}
}