package leetcode.graph;

import java.util.*;

public class AllPathSrcDest {
    private static Map<Integer, LinkedList<Integer>> adj = new HashMap<>();
    private static LinkedList<Integer> result = new LinkedList<>();
    private static LinkedList<LinkedList<Integer>> paths = new LinkedList<>();
    private static int dest =2;

    public static void main(String[] args) {
        int[] vertices = {0,1,2,3,4};
        int src=1;
        Set<Integer> visited = new HashSet<>();
        for (int i=0; i<vertices.length; i++){
            adj.put(vertices[i],new LinkedList<>());
        }
        addEdge(1,0);
        addEdge(1,3);
        addEdge(0,1);
        addEdge(0,2);
        addEdge(0,3);
        addEdge(3,2);
        addEdge(3,4);
        dfs(visited,src);
        System.out.println("All paths from src to dest");
        System.out.println(paths);
    }

    private static void dfs(Set<Integer> visited, int src) {
        visited.add(src);
        result.add(src);
        if(src == dest){
            visited.remove(src);
            paths.add(new LinkedList(Arrays.asList(result)));
            System.out.println(Collections.singletonList(result));
        }
        for (int val : adj.get(src)){
            if(!visited.contains(val)){
                dfs(visited,val);
            }
        }
        result.removeLast();
        visited.remove(src);
    }

    private static void addEdge(int src, int dest) {
        adj.get(src).add(dest);
    }
}
