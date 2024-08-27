package leetcode.stack;

import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class StackQueueImplementation {
    public static void main(String[] args) {
        Stack<Integer> _stack = new Stack<>();
        _stack.push(23);
        _stack.push(45);
        _stack.push(54);
        _stack.push(-5);

        System.out.println("Stack Elements - LIFO");
        while (!_stack.isEmpty()){
            System.out.printf("%s ", _stack.pop());
        }
        System.out.println();

        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(56);
        queue.add(65);
        queue.add(-5);

        System.out.println("Queue Elements - FIFO");
        while (!queue.isEmpty()){
            System.out.printf("%s ", queue.pop());
        }

        System.out.println();

        implementCircularLinkedlist();
    }

    private static void implementCircularLinkedlist() {
        System.out.println("Implementing Circular Linked List ...");
        int [] arr = new int[10];
        int front = -1, rear = 0;

        Scanner sc = new Scanner(System.in);
        int ele = -4;

        System.out.println("Insert elements to be inserted to queue");
        while( ele != -1 ){
            ele = sc.nextInt();
            if(front == -1)
                front = 0;
            if(front != rear) {
                arr[rear++%10] = ele;
            }
        }

        System.out.println("Array Elements");
        for(int val : arr){
            System.out.printf("%s ", val);
        }

    }
}
