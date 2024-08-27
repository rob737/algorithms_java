package leetcode.binaryTree;

public class ConnectNodesSameLevel {

    static class ModifiedNode {
        int data;
        ModifiedNode left, right, next;

        ModifiedNode(int value) {
            data = value;
            left = right = next = null;
        }
    }

    public static void main(String[] args) {
        ModifiedNode root = constructTree();
        connectNodesAtSameLevel(root);
        printList(root);
    }

    public static void printList(ModifiedNode head) {
        ModifiedNode temp = head;
        if(temp == null)
            return;
        while (head != null) {
            System.out.print(head.data + " -> ");
            head = head.next;
        }
        System.out.println("null");
        printList(temp.left);
    }

    private static void connectNodesAtSameLevel(ModifiedNode node) {
        if (node == null)
            return;

        connectNodesAtSameLevel(node.next);

        if (node.left != null) {
            node.left.next = (node.right != null) ? node.right : findNextNode(node);
        }

        if (node.right != null) {
            node.right.next = findNextNode(node);
        }

        connectNodesAtSameLevel(node.left);
        connectNodesAtSameLevel(node.right);
    }

    private static ModifiedNode findNextNode(ModifiedNode node) {
        if (node == null || node.next == null)
            return null;

        if (node.next.left != null)
            return node.next.left;
        if (node.next.right != null)
            return node.next.right;
        return findNextNode(node.next);
    }

    private static ModifiedNode constructTree() {

        ModifiedNode six = new ConnectNodesSameLevel.ModifiedNode(6);
        ModifiedNode four = new ConnectNodesSameLevel.ModifiedNode(4);
        ModifiedNode ten = new ConnectNodesSameLevel.ModifiedNode(10);
        ModifiedNode twelve = new ConnectNodesSameLevel.ModifiedNode(12);
        ModifiedNode thirteen = new ConnectNodesSameLevel.ModifiedNode(13);
        ModifiedNode eight = new ConnectNodesSameLevel.ModifiedNode(8);
        ModifiedNode twelveT = new ConnectNodesSameLevel.ModifiedNode(12);
        ModifiedNode nine = new ConnectNodesSameLevel.ModifiedNode(9);
        ModifiedNode eleven = new ConnectNodesSameLevel.ModifiedNode(11);
        ModifiedNode fifteen = new ConnectNodesSameLevel.ModifiedNode(15);
        ModifiedNode fourteen = new ConnectNodesSameLevel.ModifiedNode(14);

        six.left = four;
        six.right = ten;
        four.left = twelve;
        four.right = thirteen;
        ten.left = eight;
        ten.right = twelveT;
        twelve.left = nine;
        eight.left = eleven;
        eight.right = fifteen;
        twelveT.right = fourteen;

        return six;
    }
}
