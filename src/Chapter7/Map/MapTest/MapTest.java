package Chapter7.Map.MapTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @Author: LevenLiu
 * @Description:
 * @Date: Create 0:53 2017/9/16
 * @Modified By:
 */
public class MapTest {

    public static void main(String[] args) {
        HashMap<String,String> map = new HashMap<String,String>();
        map.put("sde","d");
        map.put("de","wew");
        Map<String, ArrayList> map1 = new HashMap<String, ArrayList>();
        ArrayList b1 = new ArrayList<Integer>(){{add(1);add(23);add(34);add(43);add(32);}};
        map1.put("de1",b1);
        map1.put("de2",b1);
//        用Map.Entry遍历map
        for (Map.Entry<String,ArrayList> entry : map1.entrySet()) {
            System.out.println(entry.getKey());
            ArrayList aa = entry.getValue();

            for (int i = 0; i < aa.size(); i++) {
                System.out.println(aa.get(i));
            }
        }

        //用iterator遍历map 用到keySet()；  要注意迭代器泛型
        Set<String> keySet= map.keySet();
        Iterator<String> it = keySet.iterator();
        while (it.hasNext()) {
            String key = (String) it.next();
            String value = map.get(key);
            System.out.println(value);
        }
    }
}
