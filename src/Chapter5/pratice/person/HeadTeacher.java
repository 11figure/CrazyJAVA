package Chapter5.pratice.person;

import Chapter5.practice.place.School;

/**
 * Created by Administrator on 2017/7/31.
 */
public class HeadTeacher extends Teacher {
    private String Classname;

    public String getClassname() {
        return Classname;
    }

    public void setClassname(String classname) {
        Classname = classname;
    }

    public HeadTeacher() {}

    public HeadTeacher(String name, int age, String gender, School school, String classname) {
        super(name, age, gender, school);
        Classname = classname;
    }

    public void teach(String cname){
        System.out.println("班主任在教" + cname);
    }

    public void eat(){
        System.out.println("班主任吃东西");
    }
    public void talkToStudent(String studentName) {
        System.out.println("班主任" + getName() + "正在和学生" + studentName + "谈话");
    }
}
