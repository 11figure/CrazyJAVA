package Chapter7.Map.MapTest;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * @Author: LevenLiu
 * @Description:
 * @Date: Create 2:03 2017/9/16
 * @Modified By:
 */
public class MapTest2 {

    public static void main(String[] args) {
        Map bb = new HashMap<>();
        bb.put("99", "ew");
        bb.put("11", "1w");
        bb.put("232", "10");
        System.out.println(bb);
        System.out.println(bb.containsKey("11"));
        System.out.println(bb.containsValue("10"));
        System.out.println(bb.entrySet());
        Set<Entry> entrySet = bb.entrySet();
        System.out.println(entrySet + "----------------");
        System.out.println(bb.keySet());
        bb.clear();
        System.out.println(bb);
        System.out.println(bb.isEmpty());
        System.out.println(bb.get("99"));

    }
}
