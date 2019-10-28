package homework;

import java.util.Stack;

public class ArrayListTest {
    public static void main(String[] args) {
        ArrayListCustom<String> list = new ArrayListCustom<>();
        System.out.println("size="+list.size());
        list.add("a");
        list.add("b");
        list.add("c");
        System.out.println("size="+list.size());
        System.out.println(list.get(2));
        System.out.println(list.contains("a"));
        System.out.println(list.remove(1));
        System.out.println("size="+list.size());
        list.set(1,"abc");
        System.out.println(list.get(1));
        //迭代器
        for (String str : list) {
            System.out.print(str+" ");
        }
    }
}
