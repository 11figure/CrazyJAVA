package Chapter6.equalshash;

/**
 * Created by Administrator on 2017/8/29.
 */
public class Address {
    private final String detail;
    private final String postCode;

    public String getDetail() {
        return detail;
    }

    public String getPostCode() {
        return postCode;
    }

    public Address() {
        this.detail ="";
        this.postCode="";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Address) {
            if (this.getDetail().equals(((Address) obj).getDetail()) && this.getPostCode().equals(((Address) obj).getPostCode())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        return detail.hashCode() + postCode.hashCode();
    }

    public Address(String detail, String postCode) {

        this.detail = detail;
        this.postCode = postCode;
    }
}
