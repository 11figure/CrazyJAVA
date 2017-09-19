package Chapter7.Map.myHashMap;

/**
 * @Author: LevenLiu
 * @Description:
 * @Date: Create 0:00 2017/9/20
 * @Modified By:
 */
public interface FQMap<K,V> {

    V put(K key, V value);

    V get(K key);

    int size();

    interface Entry<K,V>{
        K getKey();
        V getValue();
    }
}
