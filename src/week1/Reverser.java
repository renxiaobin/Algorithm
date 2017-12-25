package week1;

import java.util.Stack;

public class Reverser {
    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.peek());
        reverse(stack);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }

    private static void reverse(Stack stack) {
        if (stack.empty()) return;

        Object object = getAndRemoveStackBottem(stack);
        reverse(stack);
        stack.push(object);

    }

    private static Object getAndRemoveStackBottem(Stack stack) {
        Object result = stack.pop();
        if (stack.empty()) return result;
        Object temp = getAndRemoveStackBottem(stack);
        stack.push(result);
        return temp;
    }
}
