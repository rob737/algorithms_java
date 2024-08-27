package leetcode.binaryTree;

public class NodeImmediateRight {

    private static int levelOfKey = 0;

    public static void main(String[] args) {
        Node root = preconstructTree();
        int key = 26;
        Node ans = findImmediateRight(root,key,0);
        System.out.println("Immediate right node for given key is :");
        System.out.print(ans.value);
    }

    private static Node findImmediateRight(Node node, int key, int level) {
        if(node == null)
            return null;

        if(levelOfKey != 0){
            if(level == levelOfKey)
                return node;
        }

        if(node.value == key) {
            levelOfKey = level;
            return null;
        }
        Node left = findImmediateRight(node.left,key,level+1);

        if(left != null)
            return left;

        return findImmediateRight(node.right,key,level+1);
    }

    private static Node preconstructTree() {
        Node one = new Node(1);
        Node four = new Node(4);
        Node thirteen = new Node(13);
        Node twelve = new Node(12);
        Node twentyFive = new Node(25);
        Node thirtyTwo = new Node(32);
        Node twentySix = new Node(26);
        Node twentyTwo = new Node(22);

        one.left = four;
        one.right = twentyFive;
        four.left = thirteen;
        four.right = twelve;
        twentyFive.right = thirtyTwo;
        thirtyTwo.left = twentySix;
        thirtyTwo.right = twentyTwo;

        return one;
    }
}
