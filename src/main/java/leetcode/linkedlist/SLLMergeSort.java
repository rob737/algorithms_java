package leetcode.linkedlist;

public class SLLMergeSort {

    static class SLL {
        int data;
        SLL next;

        SLL(int key) {
            data = key;
            next = null;
        }
    }

    public static void main(String[] args) {
        SLL head = constructList();
        SLL sortedHead = mergeSort(head);
        System.out.println("---- Sorted List ----");
        while (sortedHead != null){
            System.out.printf("%s -> ", sortedHead.data);
            sortedHead = sortedHead.next;
        }
        System.out.printf("null");
    }

    private static SLL mergeSort(SLL node) {
        if(node == null || node.next == null)
            return node;
        SLL middle = find_middle_list(node);
        SLL nextOfMiddle = middle.next;
        middle.next = null;
        SLL first = mergeSort(node);
        SLL second = mergeSort(nextOfMiddle);
        SLL sortedList = sortedMerge(first,second);
        return sortedList;
    }

    private static SLL sortedMerge(SLL first, SLL second) {
        SLL result = null;
        if(first == null)
            return second;
        if(second == null)
            return first;
        if(first.data <= second.data){
            result = first;
            result.next = sortedMerge(first.next,second);
        }else {
            result = second;
            result.next = sortedMerge(first,second.next);
        }
        return result;
    }

    private static SLL find_middle_list(SLL node) {
        if(node == null)
            return node;
        SLL slow = node, fast = node;
        while (fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private static SLL constructList() {
        SLL four = new SLL(4);
        SLL two = new SLL(2);
        SLL eight = new SLL(8);
        SLL five = new SLL(5);
        SLL one = new SLL(1);
        SLL six = new SLL(6);
        SLL three = new SLL(3);
        SLL seven = new SLL(7);

        four.next = two;
        two.next = eight;
        eight.next = five;
        five.next = one;
        one.next = six;
        six.next = three;
        three.next = seven;

        return four;
    }
}
