package Chapter5.practice.place;

/**
 * Created by Administrator on 2017/7/31.
 */
public class School {
    private String schoolName;
    private String address;

    public School(String schoolName, String address) {
        this.schoolName = schoolName;
        this.address = address;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
