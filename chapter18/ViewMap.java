package com.ciaoshen.thinkinjava.chapter18;
import java.util.*;

public class ViewMap<K,V> extends AbstractMap<K,V> {
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
        if(!keys.contains(key))
            return null;
        return values.get(keys.indexOf(key));
    }
    public Set<Map.Entry<K,V>> entrySet() {
        return new EntrySet();
    }
    
    private class EntrySet extends AbstractSet<Map.Entry<K,V>>{
        public Iterator<Map.Entry<K,V>> iterator(){
            return new Iterator<Map.Entry<K,V>>(){
                private Iterator<K> iteKey=keys.iterator();
                private Iterator<V> iteValue=values.iterator();
                
                private MapEntry<K,V> entry=new MapEntry<K,V>(null,null);
                public boolean hasNext(){
                    return iteKey.hasNext() && iteValue.hasNext();
                }
                public Map.Entry<K,V> next(){
                    entry.setKey(iteKey.next());
                    entry.setValue(iteValue.next());
                    return entry;
                }
                public void remove(){
                    iteKey.remove();
                    iteValue.remove();
                }
            };
        }
        
        public int size(){return Math.min(keys.size(),values.size());}
    }
    
    public static void main(String[] args) {
        ViewMap<Integer,String> m= new ViewMap<Integer, String>();
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