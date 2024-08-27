package leetcode.graph;

import java.util.*;

/*
* BFS is basically level order traversal.
* */
public class bfs {
    private static Map<Integer, LinkedList<Integer>> map = new HashMap();
    private static LinkedList<Integer> queue = new LinkedList<>();
    private static Set<Integer> visited = new HashSet<>();

    public static void main(String[] args) {
        int[] vertices = {0,1,2,3,4,5};
        createAdjacencyList(vertices);
        addEdge(0,1);
        addEdge(0,2);
        addEdge(1,3);
        addEdge(1,4);
        addEdge(2,5);
        addEdge(3,4);
        addEdge(3,5);
        printBfs(vertices[0]);
    }

    private static void printBfs(int index) {
        queue.add(index);
        visited.add(index);
        while (!queue.isEmpty()){
            int val = queue.remove();
            System.out.println(val);
            LinkedList<Integer> neighbours = map.get(val);
            for(int _val:neighbours){
                if(!visited.contains(_val)){
                    queue.add(_val);
                    visited.add(_val);
                }
            }
        }
    }

    private static void addEdge(int src, int dest) {
        map.get(src).add(dest);
    }

    private static void createAdjacencyList(int[] vertices) {
        for(int val:vertices){
            map.put(val,new LinkedList<>());
        }
    }
}
