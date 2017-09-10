package Chapter5;

/**
 * Created by Administrator on 2017/8/1.
 */
public class Student{
    private String name;
    private int age;
    private String gender;
    private String phone;
    private String address;
    private String email;

    public Student(String name, int age, String gender, String phone, String address, String email) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.phone = phone;
        this.address = address;
        this.email = email;
    }

    public Student() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void eat() {
        System.out.println("学生再吃放");
    }
    public void drink() {
        System.out.println("在喝水");
    }
    public void play() {
        System.out.println("在玩耍");
    }
    public void sleep() {
        System.out.println("学生在睡觉");
    }
}
