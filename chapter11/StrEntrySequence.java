/**
 *  do not inherit AbstractCollection but implement Collection interface my self. Let's go!
 *  先就不泛型了
 *  @author wei.shen@iro.umontreal.ca
 *  @version 1.0
 */

/*

add(E e)
Ensures that this collection contains the specified element (optional operation).
 
boolean	addAll(Collection<? extends E> c)
Adds all of the elements in the specified collection to this collection (optional operation).
 
void	clear()
Removes all of the elements from this collection (optional operation).

boolean	contains(Object o)
Returns true if this collection contains the specified element.

boolean	containsAll(Collection<?> c)
Returns true if this collection contains all of the elements in the specified collection.

boolean	equals(Object o)
Compares the specified object with this collection for equality.

int	hashCode()
Returns the hash code value for this collection.

boolean	isEmpty()
Returns true if this collection contains no elements.

Iterator<E>	iterator()
Returns an iterator over the elements in this collection.

boolean	remove(Object o)
Removes a single instance of the specified element from this collection, if it is present (optional operation).

boolean	removeAll(Collection<?> c)
Removes all of this collection's elements that are also contained in the specified collection (optional operation)

boolean	retainAll(Collection<?> c)
Retains only the elements in this collection that are contained in the specified collection (optional operation).

int	size()
Returns the number of elements in this collection.

Object[]	toArray()
Returns an array containing all of the elements in this collection.

<T> T[]	toArray(T[] a)
Returns an array containing all of the elements in this collection; the runtime type of the returned array is that of the specified array.

*/

package com.ciaoshen.thinkinjava.chapter11;
import java.util.*;

class StrEntrySequence implements Collection<StrEntry> {
    
    /**
     *  IMPLEMENT COLLECTION INTERFACE
     *  ALL BASED ON ARRAYLIST
     */
    //Ensures that this collection contains the specified element (optional operation).
    public boolean add(StrEntry se){
        sel.add(se);
        return true;
    }
    
    //Adds all of the elements in the specified collection to this collection (optional operation).
    public boolean	addAll(Collection<? extends StrEntry> c){
        sel.addAll(c);
        return true;
    }

    //Removes all of the elements from this collection (optional operation).
    public void clear(){
        for(StrEntry se : sel){
            sel.remove(se);
        }
    }

    //Returns true if this collection contains the specified element.
    //here I only check the "word" field of the element.
    public boolean contains(Object o){
        for(StrEntry se : sel){
            if(se.getWord().equals((String)o)){
                return true;
            }
        }
        return false;
    }
    
    //Returns true if this collection contains all of the elements in the specified collection.
    public boolean	containsAll(Collection<?> c){
        if(c.getClass()==getClass()){
            for(Object o : c){
                if(!sel.contains((String)o)){
                    return false;
                }
            }
            return true;
        } else {
            return false;
        }
    }
    
    //Compares the specified object with this collection for equality.
    public boolean	equals(Object o){
        if(getClass()!=o.getClass()){
            return false;
        } else if(!sel.containsAll((Collection)o)){
            return false;
        } else {
            return true;
        }
    }
    
    //Returns the hash code value for this collection.
    public int	hashCode(){
        int hashValue=0;
        for(StrEntry se : sel){
            hashValue+=se.hashCode();
        }
        return hashValue;
    }
    
    //Returns true if this collection contains no elements.
    public boolean	isEmpty(){
        return sel.size()==0;
    }
    
    //Returns an iterator over the elements in this collection.
    public Iterator<StrEntry>	iterator(){
        return new Iterator<StrEntry>(){
            int pointer=0;
            public boolean hasNext(){
                return pointer==sel.size();
            }
            public StrEntry next(){
                return sel.get(pointer++);
            }
            public void remove(){
                if(pointer<sel.size()){
                    sel.remove(pointer);
                }
            }
        };
    }
    
    //Removes a single instance of the specified element from this collection, if it is present (optional operation).
    public boolean	remove(Object o){
        if(!sel.contains((StrEntry)o)){
            return false;
        } else {
            sel.remove((StrEntry)o);
            return true;
        }
    }
    
    //Removes all of this collection's elements that are also contained in the specified collection (optional operation)
    public boolean	removeAll(Collection<?> c){
        if(!sel.containsAll(c)){
            return false;
        } else {
            for(Object o : c){
                sel.remove((StrEntry)o);
            }
            return true;
        }
    }
    
    //Retains only the elements in this collection that are contained in the specified collection (optional operation).
    public boolean	retainAll(Collection<?> c){
        for(StrEntry se : sel){
            if(!c.contains(se)){
                sel.remove(se);
            }
        }
        return true;
    }
    
    //Returns the number of elements in this collection.
    public int	size(){
        return sel.size();
    }
    
    //Returns an array containing all of the elements in this collection.
    public Object[] toArray(){
        return sel.toArray();
    }
    
    //Returns an array containing all of the elements in this collection; the runtime type of the returned array is that of the specified array.
    public <T> T[]	toArray(T[] a){
        return a;   //do nothing
    }
    
    public String toString(){
        if(!this.isEmpty()){
            String result="";
            for(StrEntry se : sel){
                result=result+"["+se.getWord()+": "+se.getOccurence()+"]    ";
            }
            return result;
        } else {
            return null;
        }
    }
    
    /**
     *  FIELDS
     */
    private List<StrEntry> sel=new ArrayList<StrEntry>();
    
    public static void main(String[] args){
        //container & iterator
        StrEntrySequence sesTest=new StrEntrySequence();
        Iterator<StrEntry> it=sesTest.iterator();
        
        //fil container
        StrEntry.StrEntries generator=StrEntry.getGenerator();
        generator.generate(10, sesTest);
        
        //print
        System.out.println(sesTest.toString());
        
        //test contains() method
        String fakeName="kajihamata";
        String realName=it.next().getWord();
        
        System.out.println(fakeName+"?  "+sesTest.contains(fakeName));
        System.out.println(realName+"?  "+sesTest.contains(realName));
        
    }
    
}