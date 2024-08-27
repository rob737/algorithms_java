package leetcode.linkedlist;

public class FlattenList {

    static class Node {
        int data;
        Node down,next;
        Node(int key){
            data = key;
            down = next = null;
        }
    }

    public static void main(String[] args) {
        Node head = constructMultiLevelList();
        Node result = flattenList(head);
        System.out.println("Printing Flattened List");
        while(result != null){
            System.out.printf("%s -> ", result.data);
            result = result.down;
        }
        System.out.println("null");
    }

    private static Node flattenList(Node node) {
        if(node == null || node.next == null)
            return node;
        node.next = flattenList(node.next);
        Node res = merge_list(node, node.next);
        node.next = null;
        return res;
    }

    private static Node merge_list(Node first, Node second) {
        Node result = null;
        if(first == null)
            return second;
        if(second == null)
            return first;
        if(first.data <= second.data){
            result = first;
            result.down = merge_list(first.down, second);
        }else{
            result = second;
            result.down = merge_list(first,second.down);
        }
        return result;
    }

    private static Node constructMultiLevelList() {
        Node four = new Node(4);
        Node eleven = new Node(11);
        Node eighteen = new Node(18);
        Node twentyEight = new Node(28);
        Node six = new Node(6);
        Node seven = new Node(7);
        Node thirty = new Node(30);
        Node twenty = new Node(20);
        Node twentyTwo = new Node(22);
        Node fifty = new Node(50);
        Node thirtyFive = new Node(35);
        Node forty = new Node(40);
        Node fortyFive = new Node(45);

        // mappings
        four.next = eleven;
        four.down = six;
        six.down = seven;
        seven.down = thirty;

        eleven.next = eighteen;
        eleven.down = twenty;

        eighteen.next = twentyEight;
        eighteen.down = twentyTwo;
        twentyTwo.down = fifty;

        twentyEight.down = thirtyFive;
        thirtyFive.down = forty;
        forty.down = fortyFive;

        return four;
    }
}
