package revision.binarytree;

public class BasicTraversal {

    // Revise the use of static inner class.
    static class Node {
        int data;
        Node left, right;

        Node(int val){
            data = val;
            left=right=null;
        }
    }

    public static void main(String[] args) {
        Node root = createBST();
    }

    private static Node createBST() {
        // These would be created in metaspace.
        Node thirteen = new BasicTraversal.Node(13);
        Node ten = new BasicTraversal.Node(10);
        Node eight = new BasicTraversal.Node(8);
        Node twelve = new BasicTraversal.Node(12);
        Node eleven = new BasicTraversal.Node(11);
        Node sixteen = new BasicTraversal.Node(16);
        Node eighteen = new BasicTraversal.Node(18);
        Node twenty = new BasicTraversal.Node(20);

        thirteen.left=ten;
        thirteen.right=eighteen;
        ten.left=eight;
        ten.right=twelve;
        twelve.left=eleven;
        twelve.right=sixteen;
        eighteen.right=twenty;

        return thirteen;
    }
}
