package leetcode.heap;

public class NonRepeatingCharacter {

    static class Node{
        char ch;
        Node prev;
        Node next;
        Node(char ch){
            this.ch=ch;
            prev=next=null;
        }
    }

    private static Node head,tail=null;
    private static Node toggled = new Node('#');
    public static void main(String[] args) {
        String stream = "ABCDBAGHAC";
        findFirstNonRepeatingChar(stream);
    }

    private static void findFirstNonRepeatingChar(String stream) {
        Node[] ascii = new Node[256];
        for (char ch:stream.toCharArray()) {
            if(ascii[ch] !=null && ascii[ch].equals(toggled)){
                System.out.println("Duplicate character");
                continue;
            }
            if(ascii[ch]==null){
                Node temp = new Node(ch);
                if(head == null){
                    head=temp;
                    tail=head;
                }
                else{
                    tail.next=temp;
                    temp.prev=tail;
                    tail=temp;
                }
                ascii[ch]=temp;
            }else{
                Node temp = ascii[ch];
                if(temp == head){
                    head = head.next;
                }
                Node prev = temp.prev;
                Node next = temp.next;
                if(prev != null)
                prev.next = next;
                if(next != null)
                next.prev = prev;
                ascii[ch]=toggled;
            }
            System.out.println("Unique Character at the moment");
            System.out.println(head.ch);

        }

    }
}
