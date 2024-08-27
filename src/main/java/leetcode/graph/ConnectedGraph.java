package leetcode.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class ConnectedGraph {
    static HashMap<Integer, LinkedList<Integer>> map = new HashMap<>();

    public static void main(String[] args) {
        int[] vertices = {0,1,2,3};
        int n = vertices.length;
        createAdjacencyList(vertices);
        addEdge(0,1);
        addEdge(1,0);
        addEdge(1,3);
        addEdge(2,0);
        addEdge(3,0);
        addEdge(3,2);
        for(int vertex:vertices){
            Set<Integer> visited = new HashSet<>();
            isGraphConnected(vertex,visited);
            for(int _vertex:vertices)
                if(!visited.contains(_vertex)){
                    System.out.println("Graph is not connected");
                    System.exit(0);
                }
        }
        System.out.println("Graph is connected ");

    }

    private static void isGraphConnected(int vertex, Set<Integer> visited) {
        visited.add(vertex);
        for(int val:map.get(vertex)){
            if(!visited.contains(val))
                isGraphConnected(val,visited);
        }
    }

    private static void addEdge(int src, int dest) {
        map.get(src).add(dest);
    }

    private static void createAdjacencyList(int[] vertices) {
        for(int i=0; i<vertices.length;i++)
            map.put(vertices[i],new LinkedList<Integer>());
    }
}
