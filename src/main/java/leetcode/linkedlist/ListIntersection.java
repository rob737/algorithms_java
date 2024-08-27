package leetcode.linkedlist;

public class ListIntersection {
    static class Node {
        int data;
        Node next;
        Node(int key){
            data = key;
            next = null;
        }
    }

    private static Node listOne, listTwo;

    public static void main(String[] args) {
        constructListOne();
        int lengthOne = findLength(listOne);
        int lengthTwo = findLength(listTwo);
        int diff = Math.abs(lengthOne - lengthTwo);
        int result = lengthOne > lengthTwo ? findIntersection(diff, listOne, listTwo) : findIntersection(diff, listTwo, listOne);
        System.out.printf("Intersection node value : %s", result);
    }

    private static int findIntersection(int diff, Node listOne, Node listTwo) {
        int i;
        Node headOne = listOne;
        Node headTwo = listTwo;

        for(i=0; i< diff; i++){
            if(headOne == null)
                return -1;
            headOne = headOne.next;
        }

        while (headOne != null && headTwo != null){
            if(headOne.data == headTwo.data)
                return headOne.data;;
            headOne = headOne.next;
            headTwo = headTwo.next;
        }
        return -1;
    }

    private static int findLength(Node list) {
        int count = 0;
        while(list != null){
            count++;
            list = list.next;
        }
        return count;
    }

    private static void constructListOne() {
        Node two = new Node(2);
        Node three = new Node(3);
        Node _three = new Node(3);
        Node one = new Node(1);
        Node zero = new Node(0);

        // List one
        two.next = three;
        three.next = _three;
        _three.next = one;
        one.next = zero;

        // List two
        Node five = new Node(5);
        five.next = one;

        listOne = two;
        listTwo = five;
    }
}
