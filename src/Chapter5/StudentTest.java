package Chapter5;

/**
 * Created by Administrator on 2017/8/1.
 */
public class StudentTest {
    private static Student[] students = new Student[10];
    public static void main(String[] args) {
        //初始化学生数组，添加学生
        initStu(students);
        Student s =  findStu(students,"stu5","stu5@leven.com","14-135");
        if(s != null){
            System.out.println("学生名为："+s.getName());
        }else{
            System.out.println("抱歉，没有找到该学生");
        }
    }

    private static Student findStu(Student[] students, String name , String email, String address) {
        for (Student stu : students) {
            if(stu.getName().equals(name) && stu.getEmail().equals(email) && stu.getAddress().equals(address)){
                return stu;
            }
        }
        return null;
    }

    private static void initStu(Student[] stus) {
        for (int i = 0; i < students.length; i++) {
            //定义性别
            String gender = (i % 2) == 0 ? "男" : "女";
            Student stu = new Student("stu" + i, i, gender, "66611" + i, "14-31" + i, "stu" + i + "@leven.com");
            stus[i] = stu;
        }
    }
}
