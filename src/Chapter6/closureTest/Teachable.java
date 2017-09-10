package Chapter6.closureTest;

/**
 * @Author: LevenLiu
 * @Description:
 * @Date: Create 0:41 2017/9/10
 * @Modified By:
 */
public interface Teachable {
    void work();
}

class Programmer {
    private String name;
    //Programmer 类的两个构造器
    public Programmer(){};

    public Programmer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void work() {
        System.out.println(name + "敲键盘");
    }

}
