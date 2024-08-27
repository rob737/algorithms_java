package leetcode.linkedlist;

public class SLLSum {

    static class SLL {
        int data;
        SLL next;

        SLL(int key) {
            data = key;
            next = null;
        }
    }

    private static int size1 = 0, size2 = 0, carry = 0;
    private static SLL result = null;


    public static void main(String[] args) {
        int[] arrayOne = {9,9,9,9,7, 9, 4, 8};
        int[] arrayTwo = {2, 3, 3};
        size1 = arrayOne.length;
        size2 = arrayTwo.length;
        SLL head1 = contructListOne();
        SLL head2 = constructListTwo();
        addNumberLinkedList(head1, head2);
        while (result != null) {
            System.out.printf("%s ", result.data);
            result = result.next;
        }
    }


    private static void addNumberLinkedList(SLL head1, SLL head2) {
        if (head1 == null) {
            result = head2;
            return;
        }
        if (head2 == null) {
            result = head1;
            return;
        }

        if (size1 == size2)
            addSameSizeLinkedList(head1, head2);
        else {
            SLL headStart = (size1 > size2) ? head1:head2;
            int diff = Math.abs(size1 - size2);
            SLL temp = headStart;
            boolean isHeadOne = temp == head1 ? true : false;
            for(int i=0; i< diff; i++)
                temp = temp.next;
            SLL headEnd = temp;

            if (isHeadOne)
                addSameSizeLinkedList(temp, head2);
            else
                addSameSizeLinkedList(head1, temp);
            adjustRemainingNode(headStart,headEnd);
        }

        if (carry > 0)
            insert(carry);
    }

    private static void adjustRemainingNode(SLL headStart, SLL headEnd) {
        if(headStart == headEnd)
            return;
        adjustRemainingNode(headStart.next,headEnd);
        int sum = headStart.data + carry;
        carry = sum / 10;
        sum = sum % 10;
        insert(sum);
    }

    private static void addSameSizeLinkedList(SLL head1, SLL head2) {
        if (head1 == null)
            return;
        addSameSizeLinkedList(head1.next, head2.next);
        int sum = head1.data + head2.data + carry;
        carry = sum / 10;
        sum = sum % 10;
        insert(sum);
    }

    private static void insert(int value) {
        SLL temp = new SLL(value);
        temp.next = result;
        result = temp;
    }

    private static SLL contructListOne() {
        SLL nine1 = new SLL(9);
        SLL nine2 = new SLL(9);
        SLL nine3 = new SLL(9);
        SLL nine4 = new SLL(9);
        SLL seven = new SLL(9);
        SLL nine = new SLL(9);
        SLL four = new SLL(4);
        SLL eight = new SLL(8);

        nine1.next = nine2;
        nine2.next = nine3;
        nine3.next = nine4;
        nine4.next = seven;
        seven.next = nine;
        nine.next = four;
        four.next = eight;

        return nine1;
    }

    private static SLL constructListTwo() {
        SLL two = new SLL(2);
        SLL three = new SLL(3);
        SLL _three = new SLL(3);

        two.next = three;
        three.next = _three;

        return two;
    }

}
