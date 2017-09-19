package Chapter7.Map.myHashMap;

/**
 * @Author: LevenLiu
 * @Description:
 * @Date: Create 0:02 2017/9/20
 * @Modified By:
 */
public class FQHashMap<K, V> implements FQMap<K, V> {

    private static Integer defaultLength = 16;
    private static double defaultLoad = 0.75;

    private Entry<K, V>[] table = null;

    //size 记录数组的元素个数
    private int size = 0;

    FQHashMap(Integer defaultLength, double defaultLoad) {
        this.defaultLength =  defaultLength;
        this.defaultLoad  = defaultLoad;
        table = new Entry[defaultLength];
    }

    FQHashMap() {
        this(defaultLength, defaultLoad);
    }


    private int getIndex(K key) {
        int m = this.defaultLength - 1;
        return key.hashCode() % m;
    }


    @Override
    public V put(K key, V value) {
        //根据Key找Index
        int index = this.getIndex(key);

        //2.根据这个下标判断该位置是否有位置
        Entry<K, V> e = table[index];
        if (null == e) {
            table[index]  = new Entry<K, V>(key, value, null, index);
            size++;
        } else {
            Entry newEngtry = new Entry(key, value, e, index);
            table[index] = newEngtry;
        }
        return table[index].getValue();
    }

    @Override
    public V get(K key) {
        int index = this.getIndex(key);


        return table[index]== null? null:table[index].getValue();
    }

    @Override
    public int size() {
        return size;
    }

    class Entry<K, V> implements FQMap.Entry<K,V> {
        private K key;
        private V value;
        Entry<K,V> next;
        int index;

        public Entry(K key, V value, int index) {
            this.key = key;
            this.value = value;
            this.index = index;
        }

        public Entry(K key, V value, Entry<K, V> next, int index) {
            this.key = key;
            this.value = value;
            this.next = next;
            this.index = index;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }
    }
}
