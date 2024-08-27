package leetcode.backtrack;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

/*
* Minimum steps for knight to reach destination.
* Note: Whenever we need to find minimum distance in a graph we need to use BFS
* BFS is obtained using queue to maintain level order traversing.
* */
public class KnightWalkProblem {
    static class Node {
        int x,y, steps;
        Node(int x,int y){
            this.x = x;
            this.y = y;
        }
        Node(int x, int y, int steps){
            this.x = x;
            this.y = y;
            this.steps = steps;
        }
        /*
        * This is important to identify already visited nodes.
        * equals always works with hash function
        * */
        @Override
        public boolean equals(Object obj){
            if(this == obj)
                return true;
            if(obj == null || getClass() != obj.getClass())
                return false;
            Node node = (Node) obj;
            // this is internally iterated object in set
            // obj is the object that is passed in visited.contains()
            if(this.x != node.x)return false;
            if(this.y != node.y) return false;
            return true;
        }

        @Override
        public int hashCode() {
            int result = this.x;
            result = 31 * result + x;
            result = 31 * result + y;
            return result;
        }
    }

    public static void main(String[] args) {
        int N = 7;
        Node src = new Node(0,6);
        Node dest = new Node(6,2);
        System.out.println("Minimum steps needed " + BFS(src,dest,N));
    }

    private static boolean isValid(int x, int y, int N){
        if(x<0 || y<0 || x>=N || y>= N)
            return false;
        return true;
    }

    private static int BFS(Node src, Node dest, int n) {
        int[] row = {2,2,-2,-2,-1,-1,1,1};
        int[] col = {-1,1,-1,1,-2,2,-2,2};
        Set<Node> visited = new HashSet<>();
        Queue<Node> q = new ArrayDeque<>();
        q.add(src);
        while (!q.isEmpty()){
            Node node = q.poll();
            int x = node.x;
            int y = node.y;
            int steps = node.steps;
            if(x == dest.x && y == dest.y)
                return steps;
            if(!visited.contains(node)){
                visited.add(node);
                for(int i=0; i<8; i++){
                    int x1 = x + row[i];
                    int y1 = y + col[i];
                    if(isValid(x1,y1,n))
                        q.add(new Node(x1,y1,steps+1));
                }
            }
        }
        return -1;
    }


}
