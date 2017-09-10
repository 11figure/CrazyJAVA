package Chapter6;

/**
 * Created by Administrator on 2017/8/29.
 */
public class AutoBoxingUnBoxing {
    public static void main(String[] args) {
        Integer inObj = 5;
        Object boolObj = false;
        int it = inObj;
        if (boolObj instanceof Boolean) {
            boolean b = (Boolean)boolObj;
            System.out.println(b);
        }
        String intStr =  "12";
        int it2  = Integer.parseInt(intStr);
        float fl = Float.parseFloat(intStr);
        String strF = String.valueOf(12.34f);
    }
    //Class Person

    //@Override
    //public boolean equals(Object o) {
    //    if (this == o) return true;
    //    if (!(o instanceof AutoBoxingUnBoxing)) return false;
    //    AutoBoxingUnBoxing that = (AutoBoxingUnBoxing) o;
    //    return com.google.common.base.Objects.equal(Person, that.Person);
    //}
    //
    //@Override
    //public int hashCode() {
    //    return com.google.common.base.Objects.hashCode(Person);
    //}
}


