package leetcode.binaryTree;



public class LargestBST {

    public static void main(String[] args) {
        Bnode root = constructTree();
        System.out.println("Largest BST count is : " + Solution.largestBST(root).size);
    }


    private static Bnode constructTree() {

        Bnode fifty = new Bnode(50);
        Bnode thirty = new Bnode(30);
        Bnode five = new Bnode(5);
        Bnode twenty = new Bnode(20);
        Bnode sixty = new Bnode(60);
        Bnode fortyFive = new Bnode(45);
        Bnode seventy = new Bnode(70);
        Bnode sixtyFive = new Bnode(65);
        Bnode eighty = new Bnode(80);
        /*Bnode dummyLeft = new Bnode(66);
        Bnode dummyRight = new Bnode(67);

        sixtyFive.left = dummyLeft;
        sixtyFive.right = dummyRight;*/

        fifty.left = thirty;
        fifty.right = sixty;

        thirty.left = five;
        thirty.right = twenty;

        sixty.left = fortyFive;
        sixty.right = seventy;

        seventy.left = sixtyFive;
        seventy.right = eighty;

        return fifty;
    }

}

class Solution {
    static int MAX = Integer.MAX_VALUE;
    static int MIN = Integer.MIN_VALUE;

    static class nodeInfo {
        int size;
        int max;
        int min;
        boolean isBST;

        nodeInfo() {
        }

        nodeInfo(int size, int max, int min, boolean isBST) {
            this.size = size;
            this.max = max;
            this.min = min;
            this.isBST = isBST;
        }

    }

    static nodeInfo largestBST(Bnode bnode) {

        if (bnode == null)
            return new nodeInfo(0, MAX, MIN, true);
        if (bnode.left == null && bnode.right == null)
            return new nodeInfo(1, bnode.value, bnode.value, true);

        nodeInfo left = largestBST(bnode.left);
        nodeInfo right = largestBST(bnode.right);

        nodeInfo returnInfo = new nodeInfo();


        if (left.isBST && right.isBST && bnode.value < right.min && bnode.value > left.max) {
            returnInfo.min = Math.min(Math.min(left.min, right.min), bnode.value);
            returnInfo.max = Math.max(Math.max(left.max, right.max), bnode.value);
            returnInfo.isBST = true;
            returnInfo.size = left.size + right.size + 1;
            return returnInfo;
        }

        returnInfo.size = Math.max(left.size, right.size); // crucial line
        returnInfo.isBST = false;
        return returnInfo;
    }

}
