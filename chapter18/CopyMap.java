/**
 *  测试视图和副本
 */
package com.ciaoshen.thinkinjava.chapter18;
import java.util.*;

public class CopyMap<K,V> extends AbstractMap<K,V> {
    private List<K> keys = new ArrayList<K>();
    private List<V> values = new ArrayList<V>();
    public V put(K key, V value) {
        V oldValue = get(key); // The old value or null
        if(!keys.contains(key)) {
            keys.add(key);
            values.add(value);
        } else
            values.set(keys.indexOf(key), value);
        return oldValue;
    }
    public V get(Object key) { // key is type Object, not K
        if(!keys.contains(key)){
            return null;
        }
        return values.get(keys.indexOf(key));
    }
    public Set<Map.Entry<K,V>> entrySet() {
        Set<Map.Entry<K,V>> set= new HashSet<Map.Entry<K,V>>();
        Iterator<K> ki = keys.iterator();
        Iterator<V> vi = values.iterator();
        while(ki.hasNext()){
            set.add(new MapEntry<K,V>(ki.next(), vi.next()));
        }
        return set;
    }
    public static void main(String[] args) {
        CopyMap<Integer,String> m= new CopyMap<Integer, String>();
        for(int i=50;i<70;i++){
            m.put(i, new String(new char[]{(char)i}));
        }
        System.out.println(m);
        System.out.println(m.entrySet());
        
        Integer key = m.keySet().iterator().next();
        System.out.println("Now I remove the first key in map: " + key);
        m.remove(key);
        System.out.println(m.entrySet());
    }
}