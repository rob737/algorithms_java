package revision.linkedlist;

import java.util.ArrayList;
import java.util.List;

public class MergeSortedLinkedList {

    static class Node{
        int data;
        Node next;

        Node(int val){
            data = val;
            next = null;
        }
    }

    public static void main(String[] args) {
        Node listOne = new Node(2);
        Node listTwo = new Node(1);
        Node first = listOne, second = listTwo;

        addElements(listOne,listTwo);
        Node head = mergeList(first,second);
        System.out.println("Merged List..");
        while (head != null){
            System.out.println(head.data);
            head=head.next;
        }
    }

    private static Node mergeList(Node l1, Node l2) {
        Node head = null, temp = null;
        if(head == null){
            if(l1.data <= l2.data)
                head = l1;
            else
                head = l2;
        }
        while (l1 != null && l2 != null){
            int flag = 0;
            if(l1.data <= l2.data){
                while (l1!=null && l1.data <= l2.data){
                    temp = l1;
                    l1 = l1.next;
                }
            }else {
                while (l2!=null && l2.data < l1.data){
                    temp = l2;
                    flag = 1;
                    l2 = l2.next;
                }
            }
            if(flag == 1)
                temp.next=l1;
            else
                temp.next=l2;
        }
        return head;
    }

    private static void addElements(Node listOne, Node listTwo) {
        Node four = new Node(4);
        Node five = new Node(5);
        Node eight = new Node(8);

        Node three = new Node(3);
        Node six = new Node(6);
        Node seven = new Node(7);
        Node ten = new Node(10);

        listOne.next = four;
        four.next = five;
        five.next = eight;

        listTwo.next = three;
        three.next = six;
        six.next = seven;
        seven.next = ten;

    }

}
