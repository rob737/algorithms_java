package leetcode.linkedlist;

public class NthSum {
    static class Node {
        int data;
        Node next;

        Node(int key){
            data = key;
            next = null;
        }
    }

    public static void main(String[] args) {
        Node head = constructList();
        int n = 3;
        Node first = head, second = head;
        int i =0;
        while(i++<n){
            if(first == null){
                System.out.printf("List length is smaller than N");
                System.exit(0);
            }
            first = first.next;
        }

        while (first != null){
            second = second.next;
            first = first.next;
        }
        System.out.printf("Nth node from end of list is %s ", second.data);
    }

    private static Node constructList() {
        Node two = new Node(2);
        Node three = new Node(3);
        Node _three = new Node(3);
        Node one = new Node(1);
        Node zero = new Node(0);
        Node twelve = new Node(12);
        Node seven = new Node(7);

        two.next = three;
        three.next = _three;
        _three.next = one;
        one.next = zero;
        zero.next = twelve;
        twelve.next = seven;

        return two;
    }
}
