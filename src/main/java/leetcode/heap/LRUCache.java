package leetcode.heap;

import java.util.HashMap;

public class LRUCache {
    static class Node {
        int key,value;
        Node prev,next;
        Node(int key, int value){
            this.key=key;
            this.value=value;
            prev=next=null;
        }
    }

    private static HashMap<Integer,Node> map;
    private static final int CACHE_CAPACITY = 4;
    private static Node head = null;
    private static Node tail = null;

    public static void main(String[] args) {
        map = new HashMap<>();
        addToCache(2,3);
        addToCache(6,5);
        addToCache(11,10);
        addToCache(8,4);
        addToCache(9,45);
        getFromCache(11);
        displayCache();
    }

    private static void displayCache() {
        while (head!=null){
            System.out.println(head.key + ":" + head.value );
            head=head.next;
        }
    }

    private static void getFromCache(int key) {
        Node referenced = map.get(key);
        if(referenced == null)
            System.out.println("Key not present in map");
        else{
            System.out.println("Referenced Key value " + referenced.value);
            referenced.prev.next=referenced.next;
            referenced.next=null;
            head.prev=referenced;
            referenced.next=head;
            head=referenced;
        }
    }

    private static void addToCache(int key, int value) {
        Node temp = new Node(key,value);
        if( map.get(key) == null){
            if(map.size() == CACHE_CAPACITY){
                map.remove(tail.key);
                tail = tail.prev;
                tail.next=null;
                temp.next= head;
                head.prev=temp;
                head=temp;
            }else{
                if(head == null) {
                    head = temp;
                    tail=temp;
                }
                else{
                    temp.next=head;
                    head.prev=temp;
                    head=temp;
                }
            }
            map.put(key,temp);
        }else{
            Node removed = map.remove(key);
            head.prev=temp;
            temp.next=head;
            head=temp;
            if(removed.prev!=null)
                removed.prev.next=removed.next;
            map.put(key,temp);
        }
    }
}
