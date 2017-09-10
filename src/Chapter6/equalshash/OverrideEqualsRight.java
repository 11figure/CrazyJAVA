package Chapter6.equalshash;

public class OverrideEqualsRight {
    public static void main(String[] args) {

    }
}

class Person {

    String name = "";
    String idStr = "";
    public Person() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdStr() {
        return idStr;
    }

    public void setIdStr(String idStr) {
        this.idStr = idStr;
    }


    @Override
    public boolean equals(Object obj) {
        if (obj != null && obj instanceof Person) {
            if (this.getIdStr().equals(((Person) obj).getIdStr())) {
                return true;
            }
        }
        return false;
    }
}
