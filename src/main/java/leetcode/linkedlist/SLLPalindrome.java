package leetcode.linkedlist;

import java.util.concurrent.atomic.AtomicBoolean;

public class SLLPalindrome {
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
        AtomicBoolean odd = new AtomicBoolean(false);
        SLL mid = findMiddle(head, odd);
        if (odd.get()) {
            mid = mid.next;
        }
        mid = reverse(mid);
        while(head != null && mid != null){
            if(head.data != mid.data) {
                System.out.printf("List is not palindromic");
                System.exit(0);
            }
            head = head.next;
            mid = mid.next;
        }
        System.out.println("List is Palindromic");
    }

    private static SLL reverse(SLL mid) {
        if(mid.next == null)
            return mid;
        SLL prev=mid, _next =mid.next.next;
        mid = mid.next;
        while(mid != null) {
            mid.next = prev;
            prev = mid;
            mid = _next;
            if(_next != null)
            _next = _next.next;
        }
        return prev;
    }

    private static SLL findMiddle(SLL head, AtomicBoolean odd) {
        SLL prev = null;
        SLL slow = head, fast = head;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast != null)
            odd.set(true);
        prev.next = null;
        return slow;
    }

    private static SLL constructList() {
        SLL seven = new SLL(7);
        SLL nine = new SLL(9);
        SLL four = new SLL(4);
        SLL _nine = new SLL(8);
        SLL _seven = new SLL(7);

        seven.next = nine;
        nine.next = four;
        four.next = _nine;
        _nine.next = _seven;

        return seven;
    }
}
