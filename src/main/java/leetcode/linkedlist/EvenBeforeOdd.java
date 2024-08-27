package leetcode.linkedlist;

public class EvenBeforeOdd {

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
        Node res = rearrangeEvenNode(head);
        System.out.println("Generated Re-arranged list");
        while (res != null){
            System.out.printf("%s -> ", res.data);
            res = res.next;
        }
        System.out.println("null");
    }

    private static Node rearrangeEvenNode(Node head) {
        Node oddList = new Node(-1);
        Node evenList = new Node(-1);
        Node odd = oddList, even = evenList;
        Node curr = head;

        while(curr != null){
            if(curr.data %2 != 0){
                odd.next = curr;
                odd = odd.next;
            }else{
                even.next = curr;
                even = even.next;
            }
            curr = curr.next;
        }
        even.next = oddList.next;
        odd.next = null;
        return evenList.next;
    }

    private static Node constructList() {
        Node two = new Node(2);
        Node five = new Node(5);
        Node four = new Node(4);
        Node six = new Node(6);
        Node eight = new Node(8);
        Node three = new Node(3);
        Node seven = new Node(7);

        // mapping
        two.next = five;
        five.next = four;
        four.next = six;
        six.next = eight;
        eight.next = three;
        three.next = seven;

        return two;
    }
}
