package Chapter6.equalshash;

/**
 * Created by Administrator on 2017/8/29.
 */
public class CacheImmutable {
    private final String name;
    private static CacheImmutable[] cache = new CacheImmutable[10];

    public CacheImmutable(String name) {
        this.name = name;
    }

    public String getName() {

        return name;
    }

    public static void main(String[] args) {

    }
}



class AimutableC{
    private static AimutableC[] cache = new AimutableC[10];
    private final String name;
    private static int pos = 0;
    public String getName() {
        return name;
    }

    public AimutableC(String name) {
        this.name = name;
    }


    AimutableC valueOf(String name) {
        //判断非空如果有就取出，没有就新建
        for (AimutableC itemAC:cache) {
            if (itemAC != null && name.equals(itemAC.getName())) {
                return itemAC;
            }
        }
        if (cache.length == 10) {
            cache[0] = new AimutableC(name);
            pos = 1;
            return cache[0];
        } else {
            cache[pos++]= new AimutableC(name);
            return cache[pos-1];
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof AimutableC && ((AimutableC) obj).getName().equals(this.getName())) {
            return true;
        }
        return false;
    }


    @Override
    public int hashCode() {
        return name.hashCode();
    }

}