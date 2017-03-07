/**
 * Generic test
 */
package com.ciaoshen.thinkinjava.chapter15;
import java.util.*;

public class GenericTest {
    /**
     * [泛型不是帮你泛化类型的，而是帮你添加编译期类型检查约束的。]
     * 没有类型参数的Collection也可以工作，但却不能约束它内部元素的类型。
     * 所以不要使用原生类。因为这样就是去了泛型在安全性和表述性上的所有优势。
     */
    public static void rawtypeCollection() {
        Collection stamps = new ArrayList<Stamp>(Arrays.asList(new Stamp[]{new Stamp(), new Stamp(), new Stamp()})); // only rawtypes warning
        stamps.add(new Icon()); // Stamp的集合里被插入了Icon，编译器只抛出一个unchecked warning。
        System.out.println(stamps);
    }
    /**
     * [泛型的类型信息，相当于一种注释，限制了集合里元素的类型。]
     * 有了泛型类型参数的约束，编译期就能对插入的类型不匹配的元素做出反应。
     */
    public static void genericCollection() {
        Collection<Stamp> stamps = new ArrayList<Stamp>(Arrays.asList(new Stamp[]{new Stamp(), new Stamp(), new Stamp()})); // 安全声明
        //stamps.add(new Icon()); // ERROR: incompatible types
        System.out.println(stamps);
    }
    /**
     * [不要使用原生类！]
     * 往原生类容器里插入任何元素都是不受保护的。哪怕传入的参数Set本来是带有泛型类型约束的。
     * 后面的测试传入一个Set<Stamp> stamps和一个Set<Icon> icons，最后返回的是这两个集合的并集，里面既有stamp也有icon。
     * @param   [带有泛型信息的某Set。比如：Set<Stamp> stamps]
     * @param   [带有泛型类型信息的某Set。比如：Set<Icon> icons]
     * @return  [Set1和Set2内不重复元素的并集。]
     */
    public static Set dontUseRawtypes1(Set set1, Set set2) {
        for (Object o : set2) {
            if (! set1.contains(o)) {
                set1.add(o); // 往原生类里插入什么都不会受到类型检查。
            }
        }
        return set1;
    }
    /**
     * [不要使用原生类。]
     * 虽然这里用原生类还是可以运行。但很危险。因为两个原生类Set1,Set2不受任何保护。
     * 在函数内，还是可以往Set1和Set2里插入任何对象。
     * @param  [原生类 Set 1]
     * @param  [原生类 Set 2]
     * @return  [Set1 和 Set2 中共有元素的数量。]
     */
    public static int dontUseRawtypes2(Set set1, Set set2) {
        int result = 0;
        for (Object o : set1) { // 原生类元素，全部用Object接住。
            if (set2.contains(o)) {
                result++;
            }
        }
        return result;
    }
    /**
     * [不在乎参数泛型类型参数的时候，可以用无限制通配符<?>替代原生类。]
     * 使用了无限制通配符后，传入的两个参数Set1和Set2就是安全的。
     * 在函数内，无法往Set1和Set2中插入除了null以外的任何元素。
     * @param  [通配符Set 1]
     * @param  [通配符Set 2]
     * @return  [Set1 和 Set2 中共有元素的数量。]
     */
    public static int useWildCard(Set<?> set1, Set<?> set2) {
        int result = 0;
        for (Object o : set1) {
            if (set2.contains(o)) {
                result++;
            }
        }
        return result;
    }
    /**
     * [这里使用Object泛型是不行的。因为容器不支持协变。]
     * @param  [泛型Set 1]
     * @param  [泛型Set 2]
     * @return  [Set1 和 Set2 中共有元素的数量。]
     */
    public static int useObject(Set<Object> set1, Set<Object> set2) {
        int result = 0;
        for (Object o : set1) {
            if (set2.contains(o)) {
                result++;
            }
        }
        return result;
    }
    /**
     * [数组支持协变。协变是不安全的。]
     * 可以把Stamp[]赋值给一个Object[]，因为数组可以协变，Stamp[]是Object[]的派生类。
     * 但却埋下了隐患。因为数组是“具体化”的。虽然objectArray名义上是一个Object[]，但它却记得它元素的类型只能是Stamp。
     */
    public static void arrayCovariantError() {
        Object[] objectArray = new Stamp[]{new Stamp()};
        //objectArray[0] = new Icon(); // ERROR: ArrayStoreException
        //objectArray[0] = new Object(); // ERROR: ArrayStoreException
        System.out.println(Arrays.asList(objectArray));
    }
    /**
     * 如果一定需要使用泛型数组，可以通过显式的强制转型。
     * [如果想通过转型获得泛型数组，必须自己不受检查的类型转换是安全的。]
     * @param  inList [参数List<T>接受编译期类型检查。]
     */
    public static <T> void safeTypeCase(List<T> inList) { // 参数List<T>接受编译期类型检查。
        T[] elementsArray = (T[]) new Object[inList.size()]; // unchecked warning
        int index = 0;
        for (T ele : inList) { // 但这是安全的，因为唯一的数据入口inList是受泛型编译期类型检查的。
            elementsArray[index++] = ele;
        }
        System.out.println(Arrays.toString(elementsArray));
    }
    /**
     * [泛型静态工厂方法可以简化创建参数化类型实例的冗余。]
     */
    public static <K,V> Map<K,V> newHashMap() {
        return new HashMap<K,V>();
    }
    /**
     * [一个使用递归类型限定的泛型方法。返回特定列表中最大的元素。]
     * 递归类型限定了列表中的类型T的元素之间: 可以互相比较。
     * @param  list [元素实现了Comparable接口的列表]
     * @return      [元素列表中相互比较最大的元素。]
     */
    public static <T extends Comparable<T>> T max(List<T> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        Iterator<T> ite = list.iterator();
        T result = ite.next();
        while (ite.hasNext()) {
            T t = ite.next();
            if (t.compareTo(result) > 0) {
                result = t;
            }
        }
        return result;
    }
    /**
     * [泛型方法max()的测试用例]
     */
    public static void testMax() {
        Random rand = new Random();
        List<Integer> list = new ArrayList<Integer>();
        int size = 10;
        int max = 1000;
        for (int i = 0; i < size; i++) {
            list.add(rand.nextInt(max));
        }
        System.out.println("Test List is: " + list);
        System.out.println("The max element is: " + max(list));
    }
    /**
     * [使用上界通配符来扩展pushAll()可接受的参数类型，使之更灵活。]
     * 目标集合里的元素是E类型。理论上可以放置E以及所有E的派生类。
     * 所以在数据源的类型限制上使用上界通配符，实现了能接受E以及所有E的派生类的迭代器作为参数。
     * 这里的数据源，显然是数据的“生产者”。根据PECS原则，显然应该使用上界通配符<? extends E>
     * 和下面的popAll()相比，这个pushAll()更好。因为它的返回值是E。这样不会强迫类库的使用者使用通配符。
     * @param   E>  [数据源。元素类型可以是泛型参数类型E或者E的任何派生类。]
     * @param       [目标集合。参数类型为E。]
     * @return      [填充以后的目标集合。]
     */
    public static <E> Collection<E> pushAll(Iterable<? extends E> src, Collection<E> des) {
        for (E ele : src) {
            des.add(ele);
        }
        return des;
    }
    /**
     * [和pushAll()做同样的事。但这次数据源使用形式类型参数E。目标集合类型使用了下界通配符<? super E>。]
     * pushAll()以目标集合元素类型E为基准，用上界通配符将数据源集合的元素粒度向下放宽为E和E的所有派生类。<? extends E>。
     * popAll()以数据源集合元素类型E为基准，用下界通配符将目标集合的元素粒度向上扩展为E和E的所有基类。<? super E>。
     * @param     [这次数据源使用标准形式类型参数E。]
     * @param  E> [目标集合使用下界通配符，可以接受E以及所有E的基类作为元素。]
     * @return    [填充以后的目标集合。]
     */
    public static <E> Collection<? super E> popAll(Iterable<E> src, Collection<? super E> des) {
        for (E ele : src) {
            des.add(ele);
        }
        return des;
    }
    /**
     * [函数简单删除头元素，和尾元素，然后返回deque。]
     * 这个泛型方法虽然声明了类型参数E，但只出现一次。说明没有和其他类型保持一致的约束。
     * 换句话说，这个参数deque里的元素可以是任何类型，这个函数都能顺利完成任务。
     * 这时候就可以把这个函数转换成下面这个使用无限制通配符<?>的版本。
     * @param  deque [deque的元素的类型参数是E。deque可以用LinkedList初始化。]
     * @return       [空]
     */
    public static <E> void dontCareType(Deque<E> deque){
        if (deque.size() < 2) {
            return;
        }
        System.out.println("Before exchange: " + deque);
        deque.removeFirst();
        deque.removeLast();
        System.out.println("After exchange: " + deque);
    }
    /**
     * [这个函数能完成和前面dontCareType()完全一样的去头去尾的工作。]
     * 因为deque参数里的元素没有任何限制，所以可以用通配符<?>代替。
     * @param deque [类型参数是无限制通配符。]
     */
    public static void dontCareTypeWildCard(Deque<?> deque) {
        if (deque.size() < 2) {
            return;
        }
        System.out.println("Before suppression: " + deque);
        deque.removeFirst();
        deque.removeLast();
        System.out.println("After suppression: " + deque);
    }
    /**
     * [这个函数交换deque参数的首元素和尾元素。需要把首尾元素都取出来，然后再交换插回去。]
     * 但通配符<?>的问题是，拿出来了插不回去。因为读出来会是CAP#1，CAP#2类型，只能放在Object对象里，而且插不回去了。
     * 这种取出来，再插回去的工作，需要一个静态泛型helper方法来完成。
     * @param deque [description]
     */
    public static void wildCardWithHelper(Deque<?> deque) {
        if (deque.size() < 2) {
            return;
        }
        System.out.println("Before suppression: " + deque);
        changeHeadTailHelper(deque);
        System.out.println("After suppression: " + deque);
    }
    /**
     * [利用泛型方法的类型推断，传进来的捕获类型CAP#1会被赋予E类型参数。后面的取出和再插入时编译器知道都是那个E类型，所以允许。]
     * @param  deque [这里传入的deque的元素类型会是CAP#1。]
     * @return       [空]
     */
    public static <E> void changeHeadTailHelper(Deque<E> deque) {
        E first = deque.getFirst();
        E last = deque.getLast();
        deque.remove(first);
        deque.remove(last);
        deque.addFirst(last);
        deque.addLast(first);
    }
    public static class Favorites {
        private Map<Class<?>, Object> favorites = new HashMap<Class<?>, Object>();
        public <T> void putFavorite(Class<T> type, T instance) {
            if (type == null) {
                throw new NullPointerException("Type is null!");
            }
            favorites.put(type,type.cast(instance));
        }
        public <T> T getFavorite(Class<T> type) {
            if (type == null) {
                throw new NullPointerException("Type is null!");
            }
            return type.cast(favorites.get(type));
        }
    }
    public static class Stamp {
        private static int count = 0;
        private final int ID = ++count;
        private static enum Name {
            STAMP
        }
        public String toString() {
            return Name.STAMP.name() + "#" +  ID;
        }
    }
    public static class Icon {
        private static int count = 0;
        private final int ID = ++count;
        private static enum Name {
            ICON
        }
        public String toString() {
            return Name.ICON.name() + "#" +  ID;
        }
    }
    public static void main(String[] args) {
        //whyGeneric(); // 原生类容器里存放什么元素，完全不受限制。
        //genericCollection(); // 有了泛型类型参数的约束，容器变得更安全了。

        Set<Stamp> stamps = new HashSet<Stamp>(Arrays.asList(new Stamp[]{new Stamp(),new Stamp(),new Stamp()}));
        Set<Icon> icons = new HashSet<Icon>(Arrays.asList(new Icon[]{new Icon(),new Icon(),new Icon()}));
        System.out.println(dontUseRawtypes1(stamps, icons)); // 原生类让stamps和icons都变得不安全。
        dontUseRawtypes2(stamps, icons); // 这里stamps和icons也不安全。
        useWildCard(stamps,icons); //使用通配符，stamps和icons都是安全的。
        //useObject(stamps,icons); // ERROR: incompatible types. Java的容器不支持协变。Set<Stamp>不是Set<Object>的派生类。
        arrayCovariantError();
        List<Stamp> stampList = new ArrayList<Stamp>(Arrays.asList(new Stamp[]{new Stamp(),new Stamp(),new Stamp()}));
        safeTypeCase(stampList);
        Map<String,Integer> dictionary = newHashMap();
        dictionary.put("the",100);
        System.out.println(dictionary);
        testMax();
        System.out.println(pushAll(stampList,new ArrayList<Object>())); // 这里推断出的形式类型参数是：Object。
        System.out.println(popAll(stampList,new ArrayList<Object>())); // 这里推断出的形式类型参数是：Stamp。
        Deque<Stamp> deque = new LinkedList<Stamp>(stamps);
        dontCareType(deque);
        dontCareTypeWildCard(deque);
        wildCardWithHelper(deque);

        Favorites myFavorites = new Favorites();
        myFavorites.putFavorite(String.class, "Java");
        myFavorites.putFavorite(Integer.class, 99);
        System.out.println("My favorite String is: " + myFavorites.getFavorite(String.class));
        System.out.println("My favorite Integer is: " + myFavorites.getFavorite(Integer.class));
    }
}
