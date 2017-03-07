/**
 *  Exercise 11
 */
package com.ciaoshen.thinkinjava.chapter19;
import java.util.*;

public class Product{
    static List<Product> products=new ArrayList<Product>();
    static Random rand = new Random();
    public static void loadProducts(String path){
        List<String> list=new TextFile(path);
        for(String s:list){
            String[] pair=s.split("\\t");
            if(pair.length==2){
                products.add(new Product(pair[0], Integer.parseInt(pair[1])));
            }
        }
    }
    public static Product randomSelection() {
        // Don’t include STOP:
        return products.get(rand.nextInt(products.size()));
    }
    
    public String name;
    public int value; // In cents
    public Product(String name, int value) { this.name=name; this.value = value; }
    public int amount() { return value; }; // In cents
    public String toString(){ return "["+name+": "+value+"] ";}

    public static void main(String[] args){
        loadProducts("/Users/Wei/java/com/ciaoshen/thinkinjava/chapter19/product.txt");
        for(int i=0;i<10;i++){
            System.out.println(randomSelection());
        }
    }
}