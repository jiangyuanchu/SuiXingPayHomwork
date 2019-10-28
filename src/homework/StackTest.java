package homework;

import java.util.Stack;

public class StackTest {
    public static void main(String[] args) {
        StackCustom<String> stack = new StackCustom<>();
        stack.push("a");
        System.out.println("stack_size="+stack.size());
        stack.push("b");
        System.out.println("stack_size="+stack.size());
        System.out.println(stack.pop());
        System.out.println("stack_size="+stack.size());
    }
}
