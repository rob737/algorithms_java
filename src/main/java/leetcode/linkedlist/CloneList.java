package leetcode.linkedlist;

public class CloneList {
    static class Node {
        int data;
        Node next;
        Node random;
        Node(int key){
            data = key;
            next = null;
            random = null;
        }
    }

    public static void main(String[] args) {
        Node first = constructOriginalList();
        Node clonedList = constructCloneList(first);
        System.out.println("----- Printing Cloned List ------");
        while (clonedList != null){
            System.out.printf("Current node : %s, Corresponding Random Node : %s ", clonedList.data, clonedList.random.data);
            clonedList = clonedList.next;
        }
    }

    private static Node constructCloneList(Node first) {
        Node second = assignNextPointer(first);
        if(first == null || first.next == null)
            return second;
        return assignRandomPointer(first,second);
    }

    private static Node assignRandomPointer(Node first, Node second) {
        Node ptr = first, str = second;
        Node temp;
        while (ptr != null){
            temp = ptr.next;
            str.random = ptr;
            ptr.next = str;
            str = str.next;
            ptr = temp;
        }

        Node _res =  second;
        while (_res != null){
            _res.random = _res.random.random.next;
            _res = _res.next;
        }

        return second;
    }

    private static Node assignNextPointer(Node first) {
        Node temp = first;
        Node sec = null;

        if(temp!= null){
            Node _tmp = new Node(temp.data);
            sec = _tmp;
            temp = temp.next;
        }

        Node _sec = sec;

        while(temp != null){
            Node _tmp = new Node(temp.data);
            sec.next = _tmp;
            sec = _tmp;
            temp = temp.next;
        }

        return _sec;
    }

    private static Node constructOriginalList() {
        Node one = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        Node four = new Node(4);
        Node five = new Node(5);

        one.next = two;
        one.random = three;

        two.next = three;
        two.random = one;

        three.next = four;
        three.random = five;

        four.next = five;
        four.random = three;

        five.random = two;

        return one;
    }
}
