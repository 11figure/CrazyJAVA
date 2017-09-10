package Chapter6.abstractTest;

/**
 * Created by Administrator on 2017/9/3.
 */
public class Triangle extends Shape{
    private double a;
    private double b;
    private double c;

    public Triangle(String color, double a,double b, double c) {
        super(color);
        this.setSides(a, b, c);
    }

    private void setSides(double a, double b, double c) {
        if (a >= b + c || b >= a + c || c >= a + b) {
            System.out.println("三角形两边之和必须大于第三边");
        }
        this.a = a;
        this.b = b;
        this.c = c;
    }
    public double calPerimeter(){
        return a + b + c;
    }

    //重写Shape类的返回形状的抽象方法
    @Override
    public String getType() {
        return null;
    }

    @Override
    public String doSomething() {
        return null;
    }

    public static void main(String[] args) {
        Shape a  = new Triangle("red",1,1,1);
        System.out.println(a.getColor());
        System.out.println(a.getHeight());
    }
}
enum AA{

}
