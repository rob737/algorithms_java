package leetcode.linkedlist;

import org.w3c.dom.Node;

public class BasicOperations {
    static class SingleLinkedList {
        int data;
        SingleLinkedList next;
        SingleLinkedList(int key){
            data = key;
            next = null;
        }
    }

    public static void main(String[] args) {
        SingleLinkedList head = constructList();
        boolean isFound = search(8, head);
        System.out.println("Is Key found "+ isFound);
    }



    private static boolean search(int key, SingleLinkedList head) {
        SingleLinkedList temp = head;
        while(temp != null){
            if(temp.data == key)
                return true;
            temp = temp.next;
        }
        return false;
    }

    private static SingleLinkedList constructList() {
        SingleLinkedList one = new SingleLinkedList(1);
        SingleLinkedList two = new SingleLinkedList(2);
        SingleLinkedList three = new SingleLinkedList(3);
        SingleLinkedList four = new SingleLinkedList(4);

        one.next = two;
        two.next = three;
        three.next = four;

        return one;
    }
}
