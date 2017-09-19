package Chapter7.Map.myHashMap;

/**
 * @Author: LevenLiu
 * @Description:
 * @Date: Create 0:45 2017/9/20
 * @Modified By:
 */
public class TestMap {

    public static void main(String[] args) {
        FQHashMap map = new FQHashMap();
        map.put("阿迪的","我饿巍峨");
        map.put("we","wewe");
        System.out.println(map.get("阿迪的"));
        System.out.println(map.get("we"));
    }
}
