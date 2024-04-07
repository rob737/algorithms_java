package revision.graph;

import java.util.*;

public class BFSTraversal {
    private static Map<Integer, LinkedList<Integer>> graph = new HashMap<>();

    public static void main(String[] args) {
        int[] vertices = {0,1,2,3,4,5};
        createAdjacenyList(vertices);
        addEdge(0,1);
        addEdge(0,2);
        addEdge(1,3);
        addEdge(1,4);
        addEdge(2,5);
        addEdge(3,4);
        addEdge(3,5);
        bfsTraversal(vertices[0]);
    }

    private static void bfsTraversal(int src) {
        Set<Integer> visited = new HashSet<>();
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(src);
        visited.add(src);

        while (!queue.isEmpty()){
            int currentVertex = queue.pop();
            LinkedList<Integer> neighbours = graph.get(currentVertex);

            System.out.print(currentVertex + " ");

            for(int val : neighbours){
                if(!visited.contains(val)){
                    visited.add(val);
                    queue.add(val);
                }
            }
        }
    }

    private static void addEdge(int src, int dest) {
        graph.get(src).add(dest);
    }

    private static void createAdjacenyList(int[] vertices) {
        for(int val : vertices)
            graph.put(val, new LinkedList<>());
    }
}
