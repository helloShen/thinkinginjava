/**
 *  Used to count the number
 *  @Author shenwei@iro.umontreal.ca
 *  @Version 1.0
 */
package com.ciaoshen.thinkinjava.chapter14;
import java.util.*;

public class TypeCounter extends HashMap<Class<?>,Integer>{

    /**
     *  METHODS
     */
    public void count(Object obj) {
        Class<?> type = obj.getClass();
        if(!baseType.isAssignableFrom(type)){
            throw new RuntimeException(obj + " incorrect type: "+ type + ", should be type or subtype of "+ baseType);
        }
        countClass(type);
    }
    private void countClass(Class<?> type) {
        Integer quantity = get(type);
        put(type, quantity == null ? 1 : quantity + 1);
        Class<?> superClass = type.getSuperclass();
        if(superClass != null && baseType.isAssignableFrom(superClass)){
            countClass(superClass);
        }
    }
    public String toString() {
        StringBuilder result = new StringBuilder("{");
        for(Map.Entry<Class<?>,Integer> pair : entrySet()) {
            result.append(pair.getKey().getSimpleName());
            result.append("=");
            result.append(pair.getValue());
            result.append(", ");
        }
        result.delete(result.length()-2, result.length());
        result.append("}");
        return result.toString();
    }

    /**
     *  CONSTRUCTOR
     */
    public TypeCounter(Class<?> baseType) {
        this.baseType = baseType;
    }

    /**
     *  FIELDS
     */
    private Class<?> baseType;
    private static final long serialVersionUID=0;

}
