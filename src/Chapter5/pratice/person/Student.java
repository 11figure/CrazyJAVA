package Chapter5.pratice.person;

import Chapter5.practice.place.School;

/**
 * Created by Administrator on 2017/7/31.
 */
public class Student extends Person {
    private String num;
    private School school;

    public Student(String name, int age, String gender, String num, School school) {
        super(name, age, gender);
        this.num = num;
        this.school = school;
    }

    public Student() {

    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    @Override
    public void eat() {
        super.eat();
    }

    public void learn(String cName) {
        System.out.println("学生" + getName() + "在学习"  + cName);
    }

}
