package leetcode.binaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class NaryTree {
    private static Stack<NaryNode> _stack = new Stack<>();
    private static Queue<NaryNode> _queue = new LinkedList<>();

    static class NaryNode {
        int value;
        ArrayList<NaryNode> children;

        NaryNode(int key) {
            value = key;
            children = new ArrayList<>();
        }
    }

    public static void main(String[] args) {
        NaryNode root = preconstructTree();
        NaryNode rootMirror = preconstructTreeMirror();
        pushToStack(root);
        pushToQueue(rootMirror);
        boolean _isMirror = isMirror();
        System.out.println("Is Mirror? : " + _isMirror);
    }

    private static void pushToStack(NaryNode node) {
        if (node == null)
            return;

        _stack.push(node);

        for (int i = 0; i < node.children.size(); i++) {
            pushToStack(node.children.get(i));
        }
    }

    private static void pushToQueue(NaryNode node) {
        if (node == null)
            return;
        for (int i = 0; i < node.children.size(); i++)
            pushToQueue(node.children.get(i));
        _queue.add(node);
    }

    private static boolean isMirror() {
        while (!(_stack.isEmpty() && _queue.isEmpty())) {
            int stackValue = _stack.pop().value;
            int queueValue = _queue.remove().value;
            if(stackValue != queueValue)
                return false;
        }
        return true;
    }

    private static NaryNode preconstructTreeMirror() {
        NaryNode thirteen = new NaryNode(13);
        NaryNode eighteen = new NaryNode(18);
        NaryNode eightyEight = new NaryNode(88);
        NaryNode eighteenSec = new NaryNode(18);
        NaryNode twentyTwo = new NaryNode(22);
        NaryNode thirtySix = new NaryNode(36);
        NaryNode twenty = new NaryNode(20);
        NaryNode fortySix = new NaryNode(46);
        NaryNode eleven = new NaryNode(11);
        NaryNode thirtyTwo = new NaryNode(32);
        NaryNode eight = new NaryNode(8);
        NaryNode elevenSec = new NaryNode(11);
        NaryNode thirtySixSec = new NaryNode(36);
        NaryNode fortySixSec = new NaryNode(46);

        thirteen.children.add(eighteen);
        thirteen.children.add(eightyEight);
        thirteen.children.add(eighteenSec);
        thirteen.children.add(twentyTwo);

        eighteen.children.add(thirtySix);
        eighteen.children.add(twenty);
        eighteen.children.add(fortySix);
        eighteen.children.add(eleven);

        twentyTwo.children.add(thirtyTwo);
        twentyTwo.children.add(eight);
        thirtyTwo.children.add(fortySixSec);
        thirtyTwo.children.add(thirtySixSec);
        thirtyTwo.children.add(elevenSec);

        return thirteen;
    }

    private static NaryNode preconstructTree() {
        NaryNode thirteen = new NaryNode(13);
        NaryNode twentyTwo = new NaryNode(22);
        NaryNode eighteen = new NaryNode(18);
        NaryNode eightyEight = new NaryNode(88);
        NaryNode eighteenSec = new NaryNode(18);
        NaryNode thirtySix = new NaryNode(36);
        NaryNode twenty = new NaryNode(20);
        NaryNode fortySix = new NaryNode(46);
        NaryNode eleven = new NaryNode(11);
        NaryNode thirtyTwo = new NaryNode(32);
        NaryNode eight = new NaryNode(8);
        NaryNode elevenSec = new NaryNode(11);
        NaryNode thirtySixSec = new NaryNode(36);
        NaryNode fortySixSec = new NaryNode(46);


        thirteen.children.add(twentyTwo);
        thirteen.children.add(eighteen);
        thirteen.children.add(eightyEight);
        thirteen.children.add(eighteenSec);

        twentyTwo.children.add(eight);
        twentyTwo.children.add(thirtyTwo);

        eighteenSec.children.add(eleven);
        eighteenSec.children.add(fortySix);
        eighteenSec.children.add(twenty);
        eighteenSec.children.add(thirtySix);

        thirtyTwo.children.add(elevenSec);
        thirtyTwo.children.add(thirtySixSec);
        thirtyTwo.children.add(fortySixSec);

        return thirteen;

    }

}
