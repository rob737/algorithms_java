package revision.linkedlist;

class Node<T> {
    T data;
    Node next;

    Node(T val){
        data = val;
        next = null;
    }
}

public class GenericSLLDLL {
    public static void main(String[] args) {
        Node one = new Node(5);
        Node two = new Node("Generic Node");

        System.out.println(one.data + " : " + two.data);
    }
}
