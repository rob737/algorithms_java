package revision.graph;

import java.util.*;

public class ConnectedGraph {

    private static Map<Integer, LinkedList<Integer>> graph = new HashMap<>();

    public static void main(String[] args) {
        int[] vertices = {0,1,3,2};
        createAdjacencyList(vertices);
        addEdge(0,1);
        addEdge(1,0);
        addEdge(1,3);
        addEdge(3,0);
        addEdge(3,2);
        addEdge(2,0);

        boolean result = isGraphConnected(vertices);
        System.out.println("Is aforementioned graph connected ? " + result);
    }

    private static boolean isGraphConnected(int[] vertices) {
        for(int val : vertices){
            Set<Integer> visited = new HashSet<>();
            isConnected();
        }
    }

    private static void addEdge(int src, int dest) {
        graph.get(src).add(dest);
    }

    private static void createAdjacencyList(int[] vertices) {
        for(int val : vertices)
            graph.put(val, new LinkedList<>());
    }
}
