package Chapter5.pratice.person;

import Chapter5.practice.place.School;

/**
 * Created by Administrator on 2017/8/1.
 */
public class Teacher extends Person {
    private School school;

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    public Teacher() {}

    public Teacher(String name, int age, String gender, School school) {
        super(name, age, gender);
        this.school = school;
    }

    /*
    * 老师教书的方法
    *
    * */
    public void teach(String cName){
        System.out.println("老师在教" + cName);
    }

    @Override
    public void eat() {
        System.out.println("老师在吃东西");
    }

    /*
    * 普通老师特有的方法
    * */
    public void test() {
        System.out.println("普通老师各有的方法");
    }
}
