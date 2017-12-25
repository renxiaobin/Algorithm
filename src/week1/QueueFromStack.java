package week1;

import java.util.Stack;

public class QueueFromStack {
    public static void main(String[] args) {
        QueueFromStack queue = new QueueFromStack();
        queue.push(1);
        queue.push(2);
        queue.push(3);
        System.out.println(queue.pop());
        queue.push(4);
        queue.push(5);
        System.out.println(queue.pop());
    }

    Stack stackA = new Stack();
    Stack stackB = new Stack();

    public void push(Object object){
        while (!stackB.empty()){
            stackA.push(stackB.pop());
        }
        stackA.push(object);
        while (!stackA.empty()){
            stackB.push(stackA.pop());
        }
    }

    public Object pop(){
        return stackB.pop();
    }

}
