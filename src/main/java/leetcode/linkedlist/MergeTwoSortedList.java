package leetcode.linkedlist;

public class MergeTwoSortedList {
    static class SLL {
        int data;
        SLL next;

        SLL(int key) {
            data = key;
            next = null;
        }
    }

    public static void main(String[] args) {
        SLL listOne = constructListOne();
        SLL listTwo = constructListTwo();
        SLL head, prev = null;

        if (listOne == null)
            head = listTwo;
        else if (listTwo == null)
            head = listOne;
        else if (listOne.data <= listTwo.data) {
            head = listOne;
            prev = listOne;
            listOne = prev.next;
        }
        else {
            head = listTwo;
            prev = listTwo;
            listTwo = prev.next;
        }

        // prev holds the pointer to last visited smaller node.
        while (listOne != null && listTwo != null) {
            if (listOne.data <= listTwo.data) {
                prev.next = listOne;
                prev = listOne;
                listOne = prev.next;
            } else {
                prev.next = listTwo;
                prev = listTwo;
                listTwo = prev.next;
            }
        }
        while (listOne != null){
            prev.next = listOne;
            prev = listOne;
            listOne = prev.next;
        }
        while (listTwo != null){
            prev.next = listTwo;
            prev = listTwo;
            listTwo = prev.next;
        }

        while (head != null) {
            System.out.printf("%d -> ", head.data);
            head = head.next;
        }
        System.out.printf("%s", null);
    }

    private static SLL constructListOne() {
        SLL two = new SLL(2);
        SLL four = new SLL(4);
        SLL five = new SLL(5);
        SLL eight = new SLL(8);

        two.next = four;
        four.next = five;
        five.next = eight;

        return two;
    }

    private static SLL constructListTwo() {
        SLL one = new SLL(1);
        SLL three = new SLL(3);
        SLL six = new SLL(6);
        SLL seven = new SLL(7);

        one.next = three;
        three.next = six;
        six.next = seven;

        return one;
    }


}
